package com.nopi.arminBetBackend.service.controlService;

import com.nopi.arminBetBackend.model.control.ControlData;
import com.nopi.arminBetBackend.model.employee.Employee;
import com.nopi.arminBetBackend.repository.controlRepository.ControlDataRepository;
import com.nopi.arminBetBackend.service.employeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class ControlDataService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    ControlDataRepository controlDataRepository;

    @Autowired
    ControlFinancialDataService controlFinancialDataService;

    @Autowired
    EmployeeService employeeService;

    public List<ControlData> findAll(){
        return controlDataRepository.findAll();
    }

    public void save(ControlData controlData){

        controlDataRepository.save(controlData);
    }
}
