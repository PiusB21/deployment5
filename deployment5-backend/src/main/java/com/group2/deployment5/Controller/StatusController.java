package com.group2.deployment5.Controller;

import com.group2.deployment5.ServiceImpl.StatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/status")
public class StatusController {
    @Autowired
    private StatusServiceImpl statusService;

    @GetMapping("all")
    public ResponseEntity<?> getStatusForAllTargets() {
        return ResponseEntity.ok(statusService.getLatestStatusForAllTargets());
    }
}
