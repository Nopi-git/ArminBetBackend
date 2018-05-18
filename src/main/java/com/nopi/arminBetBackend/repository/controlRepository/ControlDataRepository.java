package com.nopi.arminBetBackend.repository.controlRepository;

import com.nopi.arminBetBackend.model.control.ControlData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlDataRepository extends JpaRepository<ControlData, Long> {
}
