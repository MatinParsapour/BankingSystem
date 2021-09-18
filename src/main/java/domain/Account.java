package domain;

import base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = Account.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class Account extends BaseEntity<Long> {
    public static final String TABLE_NAME = "account_table";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String NATIONAL_CODE = "national_code";
    private static final String BIRTH_DATE = "birth_date";
    private static final String FATHER_NAME = "father_name";
    private static final String ACCOUNT_NUMBER = "account_number";
    private static final String ACCOUNT_TYPE = "account_type";
    private static final String JOIN_DATE = "join_date";
    private static final String CREDIT_CARD = "credit_card";
    private static final String IS_ACTIVE = "is_active";

    @JoinColumn(name = FIRST_NAME)
    private String firstName;

    @JoinColumn(name = LAST_NAME)
    private String lastName;

    @JoinColumn(name = NATIONAL_CODE,unique = true)
    private int nationalCode;

    @JoinColumn(name = BIRTH_DATE)
    private LocalDate birthDate;

    @JoinColumn(name = FATHER_NAME)
    private String fatherName;

    @JoinColumn(name = ACCOUNT_NUMBER)
    private int accountNumber;

    @JoinColumn(name = ACCOUNT_TYPE)
    private String accountType;

    @JoinColumn(name = JOIN_DATE)
    private LocalDateTime joinDate;

    @OneToOne
    @JoinColumn(name = CREDIT_CARD)
    private CreditCard creditCard;

    @JoinColumn(name = IS_ACTIVE)
    private boolean isActive = false;
}
