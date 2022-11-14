package com.sringproject.springbackendapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.sringproject.springbackendapi.model.Absences;

@Repository
public interface AbsencesRepository extends JpaRepository<Absences, Long>, JpaSpecificationExecutor {

}
