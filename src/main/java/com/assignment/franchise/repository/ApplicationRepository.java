package com.assignment.franchise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.franchise.entity.ApplicationFormEntity;


public interface ApplicationRepository extends JpaRepository<ApplicationFormEntity, Integer> {

}