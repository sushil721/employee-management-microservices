package com.management.department.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DepartmentDTO {
    @Schema(description = "Department ID", example = "1")
    private Long id;
    @Schema(
            description = "Department Name",
            example = "IT Department"
    )
    private String departmentName;
    @Schema(
            description = "Department Description",
            example = "This department handles all IT related tasks."
    )
    private String departmentDescription;
    @Schema(
            description = "Department Code",
            example = "IT001"
    )
    private String departmentCode;
}
