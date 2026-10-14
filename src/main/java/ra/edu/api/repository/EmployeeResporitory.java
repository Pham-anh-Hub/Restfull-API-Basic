package ra.edu.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.edu.api.model.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeResporitory extends JpaRepository<Employee,Long> {
    List<Employee> getEmployeesByEmpNameContaining(String empName);
}
