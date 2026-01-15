package com.management.organization.mapper;

import com.management.organization.dto.OrganizationDTO;
import com.management.organization.entity.Organization;

public class OrganizationMapper {

    public static OrganizationDTO mapToOrganizationDTO(Organization organization) {
        if (organization == null) {
            return null;
        }
        return new OrganizationDTO(
                organization.getId(),
                organization.getOrganizationName(),
                organization.getOrganizationDescription(),
                organization.getOrganizationAddress(),
                organization.getOrganizationCode(),
                organization.getCreatedDate());

    }

    public static Organization mapToOrganization(OrganizationDTO organizationDTO) {
        if (organizationDTO == null) {
            return null;
        }
        return new Organization(
                organizationDTO.getId(),
                organizationDTO.getOrganizationName(),
                organizationDTO.getOrganizationDescription(),
                organizationDTO.getOrganizationAddress(),
                organizationDTO.getOrganizationCode(),
                organizationDTO.getCreatedDate()
        );

    }
}
