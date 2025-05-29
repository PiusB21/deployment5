package com.group2.deployment5.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="alert")
public class Alert {
    @Id
    @GeneratedValue
    private Long id;
    private Long targetId;
    private String type; // email or webhook
    private String destination;
    private String rule; // JSON or expression
}
