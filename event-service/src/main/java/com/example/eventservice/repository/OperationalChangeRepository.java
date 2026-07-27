package com.example.eventservice.repository;

import com.example.eventservice.model.OperationalChange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationalChangeRepository extends JpaRepository<OperationalChange, Long> {
}