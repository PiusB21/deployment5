package com.group2.deployment5.Service;

import com.group2.deployment5.Entity.Status;

public interface StatusService {
    Status getStatusForTarget(Long targetId);
    Status saveStatus(Status status);
}
