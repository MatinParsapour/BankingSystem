package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedEntityGraph;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User{
    private static final String USER_NAME = "user_name";
    private static final String PASSWORD = "password";

    @JoinColumn(name = USER_NAME)
    private String userName;

    @JoinColumn(name = PASSWORD)
    private String password;

    public Customer(String firstName, String lastName, String email, String phoneNumber, String nationalCode, String birthDate, String userName, String password) {
        super(firstName, lastName, email, phoneNumber, nationalCode, birthDate);
        this.userName = userName;
        this.password = password;
    }
}
