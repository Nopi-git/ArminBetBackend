package com.nopi.arminBetBackend.service;


import com.nopi.arminBetBackend.model.Agency;
import com.nopi.arminBetBackend.repository.AgencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgencyService {

    @Autowired
    AgencyRepository agencyRepository;

    public void save(Agency agency){
        agencyRepository.save(agency);
    }

    public Agency findById(Integer id){
        return agencyRepository.findById(id).orElse(null);
    }
}
