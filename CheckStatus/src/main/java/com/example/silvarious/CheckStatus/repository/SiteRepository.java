package com.example.silvarious.CheckStatus.repository;

import com.example.silvarious.CheckStatus.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<Site, Long> {
}
