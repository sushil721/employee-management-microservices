package com.management.organization.service;

import com.management.organization.dto.OrganizationDTO;
import com.management.organization.entity.Organization;
import com.management.organization.mapper.OrganizationMapper;
import com.management.organization.repository.OrganizationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{

    private OrganizationRepository organizationRepository;

    public OrganizationDTO saveOrganization(OrganizationDTO organizationDTO) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDTO);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDTO(savedOrganization);
    }

    @Override
    public OrganizationDTO getOrganizationByCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        return OrganizationMapper.mapToOrganizationDTO(organization);
    }
}
