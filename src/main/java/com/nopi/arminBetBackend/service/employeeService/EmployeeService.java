package com.nopi.arminBetBackend.service.employeeService;

import com.nopi.arminBetBackend.model.Role;
import com.nopi.arminBetBackend.model.employee.Employee;
import com.nopi.arminBetBackend.repository.RoleRepository;
import com.nopi.arminBetBackend.repository.employeeRepository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RoleRepository roleRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByUsername(username);
        if(employee == null){
            throw new UsernameNotFoundException("Invalid username or password");
        }
        return new org.springframework.security.core.userdetails.User(employee.getUsername(), employee.getPassword(), getAuthority(employee));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Employee employee) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        employee.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
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

    public Employee save(com.nopi.arminBetBackend.model.employee.UserDetails user) {
        Employee newUser = new Employee();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setPendriveSerial(user.getPendriveSerial());
        return employeeRepository.save(newUser);
    }
    public Employee save(com.nopi.arminBetBackend.model.employee.UserDetails user, String role) {
        Role dbRole = roleRepository.findByName(role);
        Employee newUser = new Employee();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setPendriveSerial(user.getPendriveSerial());
        newUser.setRoles(new HashSet<>(Collections.singletonList(dbRole)));
        return employeeRepository.save(newUser);
    }

    public Employee save(Employee employee, String role) {
        Role newRole = new Role().setName(role);
        employee.setPassword(bcryptEncoder.encode(employee.getPassword()));
        employee.setRoles(new HashSet<>(Collections.singletonList(newRole)));
        return employeeRepository.save(employee);
    }
}
