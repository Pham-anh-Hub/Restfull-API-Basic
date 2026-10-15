package ra.edu.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.edu.api.model.dto.response.ApiDataResponse;
import ra.edu.api.model.entity.Employee;
import ra.edu.api.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Employee>>> getEmployees() {
        return new ResponseEntity<>(new ApiDataResponse<>(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Employee>> insertEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(new ApiDataResponse<>(
                true,
                "Thêm mới nhân viên thành công!",
                employeeService.insertEmployee(employee),
                HttpStatus.CREATED
        ), HttpStatus.CREATED);
    }
}
