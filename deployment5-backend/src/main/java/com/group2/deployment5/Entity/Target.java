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
public class Target {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String url;
    private String frontendNode;
    private boolean enabled;
    private LocalDateTime createdAt;
}
