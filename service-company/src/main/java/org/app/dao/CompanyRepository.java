package org.app.dao;

import org.app.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
