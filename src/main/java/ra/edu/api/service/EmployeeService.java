package ra.edu.api.service;

import ra.edu.api.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployees();
    Employee getEmployeeById(Long empId);
    Employee insertEmployee(Employee employee);
    Employee updateEmployee(Long empId, Employee employee);
    boolean deleteEmployee(Long empId);
    List<Employee> getEmployeesByName(String empName);
    public Long countEmployees();
}
