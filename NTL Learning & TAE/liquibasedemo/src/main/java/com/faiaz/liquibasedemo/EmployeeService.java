package com.faiaz.liquibasedemo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Transactional
    public Employee createEmployee(Employee employee) {
        return (Employee) employeeRepository.findByEmail(employee.getEmail())
                .map(existingEmployee -> {
                    throw new EmployeeAlreadyExistsException("An employee with this email already exist");
                })
                .orElseGet(() -> employeeRepository.save(employee));
    }

    public Employee updateEmployee(Employee employee, Long id) {
        return  employeeRepository.findById(id)
                .map(existingEmployee -> {
                    existingEmployee.setFirstName(employee.getFirstName());
                    existingEmployee.setLastName(employee.getLastName());
                    existingEmployee.setJobTitle(employee.getJobTitle());
                    existingEmployee.setDepartment(employee.getDepartment());
                    existingEmployee.setSalary(employee.getSalary());
                    return employeeRepository.save(existingEmployee);
                })
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    public Void deleteEmployee(Long id) {
        employeeRepository.findById(id).ifPresentOrElse(employeeRepository::delete, () -> new EmployeeNotFoundException("Employee not found"));
        return null;
    }
}
