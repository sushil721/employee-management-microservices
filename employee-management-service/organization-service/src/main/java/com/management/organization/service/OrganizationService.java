package com.management.organization.service;

import com.management.organization.dto.OrganizationDTO;

public interface OrganizationService {
    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO);
    public OrganizationDTO getOrganizationByCode(String organizationCode);
}
