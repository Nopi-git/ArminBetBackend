package com.nopi.arminBetBackend.utility;

import com.nopi.arminBetBackend.model.Role;
import com.nopi.arminBetBackend.model.employee.Employee;
import com.nopi.arminBetBackend.model.employee.UserDetails;
import com.nopi.arminBetBackend.repository.RoleRepository;
import com.nopi.arminBetBackend.service.employeeService.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InitializerBean {


    public InitializerBean(EmployeeService employeeService,
                           RoleRepository roleRepository,
                           @Value("${admin.username}") String adminUsername,
                           @Value("${admin.password}") String adminPassword,
                           @Value("${employee.password}") String employeePassword){
        Employee admin = new Employee().setPendriveSerial("0B0F1BB0F6C9").setUsername(adminUsername).setPassword(adminPassword);
        Employee admin1 = new Employee().setPendriveSerial("4C530200851112122325").setUsername("nyeste.sandor").setPassword(adminPassword);

        UserDetails employee1 = new UserDetails();
        employee1.setPendriveSerial("AA00000000000489").setUsername("totos.istvan").setPassword(employeePassword);

        UserDetails employee2 = new UserDetails();
        employee2.setPendriveSerial("1BC11AB004D9").setUsername("zubor.andras").setPassword(employeePassword);

        UserDetails employee3 = new UserDetails();
        employee3.setPendriveSerial("4B0188D051C9").setUsername("gal.szabolcs").setPassword(employeePassword);

        UserDetails employee4 = new UserDetails();
        employee4.setPendriveSerial("4C531001500713106593").setUsername("ladislau.szasz").setPassword(employeePassword);

        UserDetails employee5 = new UserDetails();
        employee5.setPendriveSerial("FB416CD10349").setUsername("elinescu.cosmin").setPassword(employeePassword);

        UserDetails employee6 = new UserDetails();
        employee6.setUsername("gavril.claudiu").setPendriveSerial("12345678123456781234567812345678").setPassword(employeePassword);

        UserDetails employee7 = new UserDetails();
        employee7.setPendriveSerial("5B01E9504897").setUsername("nyaguly.laszlo").setPassword(employeePassword);

        UserDetails employee8 = new UserDetails();
        employee8.setUsername("vintila.alin").setPendriveSerial("6BC16C2163D9").setPassword(employeePassword);


        employeeService.save(employee1);
        employeeService.save(employee2);
        employeeService.save(employee3);
        employeeService.save(employee4);
        employeeService.save(employee5);
        employeeService.save(employee6);
        employeeService.save(employee7);
        employeeService.save(employee8);
        employeeService.save(admin, "ADMIN");
        employeeService.save(admin1,"ADMIN");
    }
}
