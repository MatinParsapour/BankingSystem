package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User{
    private static final String EMPLOYEE_CODE = "employee_code";
    private static final String IS_EMPLOYEE = "is_employee";

    @JoinColumn(name = EMPLOYEE_CODE,unique = true)
    private int employeeCode;

    @JoinColumn(name = IS_EMPLOYEE)
    private boolean isEmployee;

    public Employee(String firstName, String lastName, String email, String phoneNumber, String nationalCode, LocalDate birthDate, int employeeCode, boolean isEmployee) {
        super(firstName, lastName, email, phoneNumber, nationalCode, birthDate);
        this.employeeCode = employeeCode;
        this.isEmployee = isEmployee;
    }
}
