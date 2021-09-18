package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User{
    private static final String EMPLOYEE_CODE = "employee_code";

    @JoinColumn(name = EMPLOYEE_CODE)
    private int employeeCode;

}
