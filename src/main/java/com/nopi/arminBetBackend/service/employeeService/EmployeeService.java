package com.nopi.arminBetBackend.service.employeeService;

import com.nopi.arminBetBackend.model.employee.Employee;
import com.nopi.arminBetBackend.repository.employeeRepository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public void save(Employee employee){
        employeeRepository.save(employee);
    }

    public List<String> getAllPendriveSerial(){
        List<String> pendriveSerials = new LinkedList<>();
        employeeRepository.findAll().forEach(e-> pendriveSerials.add(e.getPendriveSerial()));
        return pendriveSerials;
    }

    public String getAllPendriveSerialsInFormattedJSON(){
        List<String> pendriveSerials = getAllPendriveSerial();
        StringBuilder result = new StringBuilder("[");
        Iterator it = pendriveSerials.iterator();

        while(it.hasNext()){
            result.append("\"").append(it.next()).append("\"");
            if(it.hasNext()){
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }

    public Employee findByPendriveSerial(String pendriveSerial){
        return employeeRepository.findByPendriveSerial(pendriveSerial);
    }

    public Employee findById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
}
