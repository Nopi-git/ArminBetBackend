package com.nopi.arminBetBackend.utility;

import com.nopi.arminBetBackend.model.employee.Employee;
import com.nopi.arminBetBackend.service.employeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {


    public InitializerBean(EmployeeService employeeService){
        Employee employee1 = new Employee();
        employee1.setPendriveSerial("AA00000000000489").setUsername("totos.istvan");

        Employee employee2 = new Employee();
        employee2.setPendriveSerial("1BC11AB004D9").setUsername("zubor.andras");

        Employee employee3 = new Employee();
        employee3.setPendriveSerial("4B0188D051C9").setUsername("gal.szabolcs");

        Employee employee4 = new Employee();
        employee4.setPendriveSerial("4C531001500713106593").setUsername("ladislau.szasz");

        Employee employee5 = new Employee();
        employee5.setPendriveSerial("FB416CD10349").setUsername("elinescu.cosmin");

        Employee employee6 = new Employee();
        employee6.setUsername("gavril.claudiu");

        Employee employee7 = new Employee();
        employee7.setPendriveSerial("5B01E9504897").setUsername("nyaguly.laszlo");

        Employee employee8 = new Employee();
        employee8.setUsername("vintila.alin");

        Employee admin = new Employee().setPendriveSerial("2008012500000000000003C6").setUsername("admin");
        Employee admin1 = new Employee().setPendriveSerial("4C530200851112122325").setUsername("nyeste.sandor");

        employeeService.save(employee1);
        employeeService.save(employee2);
        employeeService.save(employee3);
        employeeService.save(employee4);
        employeeService.save(employee5);
        employeeService.save(employee6);
        employeeService.save(employee7);
        employeeService.save(employee8);
        employeeService.save(admin);
        employeeService.save(admin1);
    }
}
