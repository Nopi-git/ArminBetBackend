package com.nopi.arminBetBackend.controller;

import com.nopi.arminBetBackend.model.Agency;
import com.nopi.arminBetBackend.model.employee.Employee;
import com.nopi.arminBetBackend.model.employee.UserDetails;
import com.nopi.arminBetBackend.service.AgencyService;
import com.nopi.arminBetBackend.service.employeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControlDataRestController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AgencyService agencyService;


    @GetMapping(value = "/pendrive/pendriveSerials")
    public String getAllPendriveSerial() {
        return "{\"pendriveSerials\":" + employeeService.getAllPendriveSerialsInFormattedJSON() + "}";
    }

    @CrossOrigin
    @PostMapping(value = "/agency")
    public void saveAgency(@RequestBody Agency agency){
        System.out.println(agency.getId());
        agencyService.save(agency);
    }

    @CrossOrigin
    @GetMapping(value = "/agency/{armId:\\d+}")
    public Agency getAgency(@PathVariable Integer armId){
        return agencyService.findById(armId);
    }

    @CrossOrigin
    @PostMapping(value = "/employee")
    public void saveEmployee(@RequestBody UserDetails employee){
        employeeService.save(employee);
    }

    @CrossOrigin
    @GetMapping(value = "/employee/pendrive={pendriveSerial}")
    public Employee getEmployeeByPendriveSerial(@PathVariable String pendriveSerial){
        return employeeService.findByPendriveSerial(pendriveSerial);
    }

    /*@CrossOrigin
    @GetMapping(value = "/employee/username={username}")
    public Employee getEmployeeByUsername(@PathVariable String username){

    }*/
}
