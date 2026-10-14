package ra.edu.api.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long empId;
    @Column(name = "employee_name",length = 50)
    private String empName;
    private Boolean gender;
    private LocalDate birthday;
    private String address;
    @Column(length = 100,nullable = false)
    private String company;
    private Double salary;
}
