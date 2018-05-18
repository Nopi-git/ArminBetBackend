package com.nopi.arminBetBackend.controller;

import com.nopi.arminBetBackend.model.control.ControlData;
import com.nopi.arminBetBackend.model.employee.Employee;
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


    @GetMapping(value = "/pendrive/pendriveSerials")
    public String getAllPendriveSerial(){
        return "{\"pendriveSerials\":" + employeeService.getAllPendriveSerialsInFormattedJSON() + "}";
    }

    @CrossOrigin
    @PostMapping(value = "/pendrive/{pendriveSerial}/addControl")
    public void saveControlByEmployeePendriveSerial(@PathVariable String pendriveSerial, @RequestBody ControlData controlData){
        Employee employee = employeeService.findByPendriveSerial(pendriveSerial);
        controlData.setEmployee(employee);
        controlDataService.save(controlData);
    }

    @GetMapping(value = "/pendrive/{pendriveSerial}")
    public Employee getEmployeeByPendriveSerial(@PathVariable String pendriveSerial){
        return employeeService.findByPendriveSerial(pendriveSerial);
    }
}
