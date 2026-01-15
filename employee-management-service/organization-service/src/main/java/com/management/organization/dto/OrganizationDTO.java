package com.management.organization.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {
    @Schema(
            description = "Organization ID",
            example = "1"
    )
    private Long id;
    @Schema(
            description = "Organization Name",
            example = "Jyoti Organization"
    )
    private String organizationName;
    @Schema(
            description = "Organization Description",
            example = "This is Jyoti Organization"
    )
    private String organizationDescription;
    @Schema(
            description = "Organization Address",
            example = "123, Main Street, Cityville"
    )
    private String organizationAddress;
    @Schema(
            description = "Organization Code",
            example = "JYOTI_ORG"
    )
    private String organizationCode;
    @Schema(
            description = "Organization Created Date",
            example = "2024-01-01T10:00:00"
    )
    private LocalDateTime createdDate;
}
