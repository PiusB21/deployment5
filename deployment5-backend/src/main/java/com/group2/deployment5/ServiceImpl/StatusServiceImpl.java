package com.group2.deployment5.ServiceImpl;

import com.group2.deployment5.Entity.Status;
import com.group2.deployment5.Repo.StatusRepository;
import com.group2.deployment5.Service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;
    //https://www.youtube.com/shorts/wuyh2LkaErc
    @Override
    public Status getStatusForTarget(Long targetId) {
        return null;
    }

    @Override
    public Status saveStatus(Status status) {
        return null;
    }
}
