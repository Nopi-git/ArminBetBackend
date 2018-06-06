package com.nopi.arminBetBackend.repository.employeeRepository;

import com.nopi.arminBetBackend.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByPendriveSerial(String pendriveSerial);

    public Employee findByUsername(String username);
}
