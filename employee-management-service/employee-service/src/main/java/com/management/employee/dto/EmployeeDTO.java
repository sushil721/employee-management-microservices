package com.management.employee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EmployeeDTO {
    @Schema(description = "Employee ID", example = "1")
    private Long id;
    @Schema(
            description = "Employee First Name",
            example = "Sushil"
    )
    private String firstName;
    @Schema(
            description = "Employee Last Name",
            example = "Singh"
    )
    private String lastName;
    @Schema(
            description = "Employee Email",
            example = "sushil@testmail.com"
    )
    private String email;
    @Schema(
            description = "Department Code",
            example = "IT001"
    )
    private String departmentCode;
    @Schema(
            description = "Organization Code",
            example = "JYOTI_ORG"
    )
    private String organizationCode;
}
