package com.nopi.arminBetBackend.controller;

import com.nopi.arminBetBackend.model.Agency;
import com.nopi.arminBetBackend.model.control.ControlData;
import com.nopi.arminBetBackend.model.employee.Employee;
import com.nopi.arminBetBackend.service.AgencyService;
import com.nopi.arminBetBackend.service.controlService.ControlDataService;
import com.nopi.arminBetBackend.service.controlService.ControlFinancialDataService;
import com.nopi.arminBetBackend.service.employeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControlDataRestController {

    @Autowired
    ControlDataService controlDataService;

    @Autowired
    ControlFinancialDataService controlFinancialDataService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    AgencyService agencyService;


    @GetMapping(value = "/pendrive/pendriveSerials")
    public String getAllPendriveSerial(){
        return "{\"pendriveSerials\":" + employeeService.getAllPendriveSerialsInFormattedJSON() + "}";
    }

    @CrossOrigin
    @PostMapping(value = "/pendrive/{armId:\\d+}/{pendriveSerial}/addControl")
    public void saveControlByEmployeePendriveSerial(@PathVariable Integer armId, @PathVariable String pendriveSerial, @RequestBody ControlData controlData){
        Employee employee = employeeService.findByPendriveSerial(pendriveSerial);
        System.out.println(armId);
        Agency agency = agencyService.findById(armId);
        System.out.println(agency.getId());
        controlData.setEmployee(employee);
        controlData.setAgency(agency);
        controlDataService.save(controlData);
    }

    @CrossOrigin
    @GetMapping(value = "/pendrive/{pendriveSerial}")
    public Employee getEmployeeByPendriveSerial(@PathVariable String pendriveSerial){
        return employeeService.findByPendriveSerial(pendriveSerial);
    }

    @CrossOrigin
    @GetMapping(value = "/pendrive/employee/{employeeId:\\d+}")
    public List<ControlData> getControlDataByEmployee(@PathVariable Long employeeId){
        return controlDataService.findAllByEmployee_Id(employeeId);
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
    public void saveEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
    }
}
