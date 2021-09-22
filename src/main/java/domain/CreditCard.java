package domain;

import base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = CreditCard.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class CreditCard extends BaseEntity<Long> {

    public static final String TABLE_NAME = "credit_card_table";
    private static final String BANK_NAME = "bank_name";
    private static final String USER_SURE_NAME = "user_sure_name";
    private static final String CARD_NUMBER = "card_number";
    private static final String CVV2 = "cvv2";
    private static final String EXPIRATION_DATE = "expiration_date";
    private static final String BRANCH_CODE = "branch_code";
    private static final String SHEBA_NUMBER = "sheba_number";
    private static final String FIRST_PASSWORD = "first_password";
    private static final String SECOND_PASSWORD = "second_password";
    private static final String BALANCE = "balance";

    @JoinColumn(name = BANK_NAME)
    private String bankName;

    @JoinColumn(name = USER_SURE_NAME)
    private String userSureName;

    @JoinColumn(name = CARD_NUMBER,unique = true)
    private long cardNumber;

    @JoinColumn(name = CVV2)
    private int cVV2;

    @JoinColumn(name = EXPIRATION_DATE)
    private LocalDate expirationDate;

    @JoinColumn(name = BRANCH_CODE)
    private int branchCode;

    @JoinColumn(name = SHEBA_NUMBER,unique = true)
    private String shebaNumber;

    @JoinColumn(name = FIRST_PASSWORD)
    private int firstPassword;

    @JoinColumn(name = SECOND_PASSWORD)
    private int secondPassword;

    @OneToOne(mappedBy = "creditCard")
    private Account account;

    @JoinColumn(name = BALANCE)
    private double balance;

    public CreditCard(String bankName, String userSureName,
                      long cardNumber, int cVV2, LocalDate expirationDate,
                      int branchCode, String shebaNumber, int firstPassword) {
        this.bankName = bankName;
        this.userSureName = userSureName;
        this.cardNumber = cardNumber;
        this.cVV2 = cVV2;
        this.expirationDate = expirationDate;
        this.branchCode = branchCode;
        this.shebaNumber = shebaNumber;
        this.firstPassword = firstPassword;
        balance = 0;
    }
}
