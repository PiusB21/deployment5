package com.group2.deployment5.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TargetDTO {
    private String name;
    private String url;
    private String frontendNode;
    private boolean enabled;
}
