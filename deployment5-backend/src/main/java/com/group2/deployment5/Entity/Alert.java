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

    @ManyToOne(optional = false)
    @JoinColumn(name = "target_id", nullable = false)
    private Target target;

    @ManyToOne(optional = false)
    @JoinColumn(name = "status_id", nullable = false)
    private Status status;

    private String message;
}
