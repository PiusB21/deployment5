package com.group2.deployment5.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class History {
    @Id
    @GeneratedValue
    private Long id;
    private Long targetId;
    private boolean isOnline;
    private long latency;
    private LocalDateTime checkedAt;
}
