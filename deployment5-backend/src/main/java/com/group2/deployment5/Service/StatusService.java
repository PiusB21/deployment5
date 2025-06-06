package com.group2.deployment5.Service;

import com.group2.deployment5.Entity.Status;

import java.util.Map;

public interface StatusService {
    Status getStatusForTarget(Long targetId);
    Status saveStatus(Status status);
    public Status getLatestStatus(Long targetId);
    public Map<Long, Status> getLatestStatusForAllTargets();
}
