package com.frm.commandcenter.repository;

import com.frm.commandcenter.model.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command, Long> {
    boolean existsByControlNumber(String controlNumber);
}
