package com.byterupt.subh.repository;

import com.byterupt.subh.model.studentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface studentRepo extends JpaRepository<studentDetails, Long> {

}
