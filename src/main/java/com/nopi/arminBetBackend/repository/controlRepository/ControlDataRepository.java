package com.nopi.arminBetBackend.repository.controlRepository;

import com.nopi.arminBetBackend.model.control.ControlData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ControlDataRepository extends JpaRepository<ControlData, Long> {

    public List<ControlData> findAllByEmployee_Id(Long employeID);
}
