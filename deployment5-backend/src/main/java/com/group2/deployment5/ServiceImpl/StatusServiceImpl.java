package com.group2.deployment5.ServiceImpl;

import com.group2.deployment5.Entity.Status;
import com.group2.deployment5.Entity.Target;
import com.group2.deployment5.Repo.StatusRepository;
import com.group2.deployment5.Repo.TargetRepository;
import com.group2.deployment5.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TargetRepository targetRepository;
    //https://www.youtube.com/shorts/wuyh2LkaErc
    @Override
    public Status getStatusForTarget(Long targetId) {
        return null;
    }

    @Override
    public Status saveStatus(Status status) {
        return null;
    }

    @Override
    public Status getLatestStatus(Long targetId) {
        return statusRepository.findTopByTargetIdOrderByCheckedAtDesc(targetId)
                .orElseThrow(() -> new RuntimeException("No status found for target " + targetId));
    }

    @Override
    public Map<Long, Status> getLatestStatusForAllTargets() {
        List<Target> targets = targetRepository.findAll();
        Map<Long, Status> result = new HashMap<>();
        for (Target target : targets) {
            Status latest = statusRepository.findTop1ByTargetOrderByCheckedAtDesc(target);
            result.put(target.getId(), latest);
        }
        return result;
    }
}
