package com.group2.deployment5.ServiceImpl;

import com.group2.deployment5.Entity.Alert;
import com.group2.deployment5.Entity.Status;
import com.group2.deployment5.Entity.Target;
import com.group2.deployment5.Repo.AlertRepository;
import com.group2.deployment5.Repo.StatusRepository;
import com.group2.deployment5.Repo.TargetRepository;
import com.group2.deployment5.Service.StatusCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StatusCheckServiceImpl implements StatusCheckerService {
    @Autowired
    private TargetRepository targetRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AlertServiceImpl alertService;

    private final Map<Long, Integer> failureCounts = new ConcurrentHashMap<>();

    @Override
    @Scheduled(fixedRate = 300000)
    public void checkAllTargets() {
        List<Target> targets = targetRepository.findAll();

        for (Target target : targets) {
            if (!target.isEnabled()) continue;

            String url = target.getUrl();
            Status status = new Status();
            status.setTarget(target);
            status.setCheckedAt(LocalDateTime.now());

            try {
                long start = System.currentTimeMillis();
                ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
                long latency = System.currentTimeMillis() - start;

                status.setHttpStatusCode(response.getStatusCode().value());
                status.setLatency(latency);
                status.setSuccess(true);
                failureCounts.put(target.getId(), 0);

            } catch (Exception e) {
                status.setHttpStatusCode(0); // Could not connect
                status.setLatency(-1);
                status.setSuccess(false);
                int fails = failureCounts.getOrDefault(target.getId(), 0) + 1;
                failureCounts.put(target.getId(), fails);

                if (fails == 2) {
                    var message = "ALERT: \n name : " + target.getName() + " \n" + "url : "+ target.getUrl() + " is unreachable.";
                    var alert = Alert.builder()
                            .target(target)
                            .message(message)
                            .status(status)
                            .build();
                    alertRepository.save(alert);
                    alertService.sendAlert(message);
                }
            }

            statusRepository.save(status);
        }
    }
}