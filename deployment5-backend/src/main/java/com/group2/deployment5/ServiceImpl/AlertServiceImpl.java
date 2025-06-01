package com.group2.deployment5.ServiceImpl;

import com.group2.deployment5.Entity.Alert;
import com.group2.deployment5.Entity.Status;
import com.group2.deployment5.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${alert.recipient}")
    private String recipientEmail;

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
    public void sendAlert(String messageBody) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipientEmail);
        message.setSubject("System Alert");
        message.setText(messageBody);
        mailSender.send(message);
    }
}
