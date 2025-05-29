package com.group2.deployment5.Service;

import com.group2.deployment5.Entity.Alert;
import com.group2.deployment5.Entity.Status;

import java.util.List;

public interface AlertService {
    List<Alert> getAll();
    Alert getById(Long id);
    Alert create(Alert alert);
    void triggerAlerts(Status status);
}
