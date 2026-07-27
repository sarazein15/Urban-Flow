package com.example.districtservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.districtservice.entity.Zone;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
}