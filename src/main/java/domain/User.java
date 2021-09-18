package domain;

import base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Inheritance
@Table(name = User.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class User extends BaseEntity<Long> {
    public static final String TABLE_NAME = "user_table";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String NATIONAL_CODE = "national_code";
    private static final String BIRTH_DATE = "birth_date";
    private static final String USER_ACCOUNTS = "user_accounts";

    @JoinColumn(name = FIRST_NAME)
    private String firstName;

    @JoinColumn(name = LAST_NAME)
    private String lastName;

    @JoinColumn(name = EMAIL)
    private String email;

    @JoinColumn(name = PHONE_NUMBER)
    private String phoneNumber;

    @JoinColumn(name = NATIONAL_CODE)
    private String nationalCode;

    @JoinColumn(name = BIRTH_DATE)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Account> userAccounts;

    public User(String firstName, String lastName, String email, String phoneNumber,
                String nationalCode, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
        this.birthDate = birthDate;
        userAccounts = new TreeSet<>();
    }
}
