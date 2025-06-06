package com.group2.deployment5.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private String regNo;
    private String first_name;
    private String last_name;
    private String email;
    private String program;
}
