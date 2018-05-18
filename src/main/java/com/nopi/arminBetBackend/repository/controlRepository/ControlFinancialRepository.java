package com.nopi.arminBetBackend.repository.controlRepository;


import com.nopi.arminBetBackend.model.control.ControlFinancialData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ControlFinancialRepository extends JpaRepository<ControlFinancialData, Long> {
}
