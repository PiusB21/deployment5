package com.group2.deployment5.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "target_id", nullable = false)
    private Target target;

    @Column(name = "http_status_code")
    private int httpStatusCode;

    @Column(name = "latency_ms")
    private long latency; // milliseconds

    @Column(name = "is_success")
    private boolean success;

    @Column(name = "checked_at")
    private LocalDateTime checkedAt;

    // Optional: store response snippet or error message
    @Column(name = "message", length = 1024)
    private String message;
}
