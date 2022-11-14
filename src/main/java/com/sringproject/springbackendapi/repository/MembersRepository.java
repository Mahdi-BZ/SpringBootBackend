package com.sringproject.springbackendapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sringproject.springbackendapi.model.Members;

@Repository
public interface MembersRepository extends JpaRepository<Members, Long>{

}
