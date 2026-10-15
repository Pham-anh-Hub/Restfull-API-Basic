package ra.edu.api.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ra.edu.api.model.entity.Employee;
import ra.edu.api.repository.EmployeeResporitory;
import ra.edu.api.service.EmployeeService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeResporitory employeeResporitory;


    @Override
    public List<Employee> getEmployees() {
        return employeeResporitory.findAll();
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        return employeeResporitory.findById(empId).orElseThrow(() -> new NoSuchElementException("Không tìm thấy nhân viên có id " + empId));
    }
    @Override
    public Long countEmployees(){
        return employeeResporitory.count();
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeResporitory.save(employee);
    }

    @Override
    public Employee updateEmployee(Long empId, Employee employee) {
        employeeResporitory.findById(empId).orElseThrow(()->new NoSuchElementException("Không tồn tại nhân viên: "+empId));
        employee.setEmpId(empId);
        return employeeResporitory.save(employee);
    }

    @Override
    public boolean deleteEmployee(Long empId) {
        employeeResporitory.findById(empId).orElseThrow(()->new NoSuchElementException("Không tồn tại nhân viên: "+empId));
        employeeResporitory.deleteById(empId);
        return true;
    }

    @Override
    public List<Employee> getEmployeesByName(String empName) {
        return employeeResporitory.getEmployeesByEmpNameContaining(empName);
    }
}
