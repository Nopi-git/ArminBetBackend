package com.nopi.arminBetBackend.service.controlService;

import com.nopi.arminBetBackend.model.control.ControlFinancialData;
import com.nopi.arminBetBackend.repository.controlRepository.ControlFinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlFinancialDataService {

    @Autowired
    ControlFinancialRepository controlFinancialRepository;

    public void save(ControlFinancialData controlFinancialData){
        controlFinancialRepository.save(controlFinancialData);
    }
}
