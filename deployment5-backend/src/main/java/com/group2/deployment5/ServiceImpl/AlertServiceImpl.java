package com.group2.deployment5.ServiceImpl;

import com.group2.deployment5.Entity.Alert;
import com.group2.deployment5.Entity.Status;
import com.group2.deployment5.Service.AlertService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {
    @Override
    public List<Alert> getAll() {
        return List.of();
    }

    @Override
    public Alert getById(Long id) {
        return null;
    }

    @Override
    public Alert create(Alert alert) {
        return null;
    }

    @Override
    public void triggerAlerts(Status status) {

    }
}
