package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CEO extends User{

    private static final String CEO_CODE = "ceo_code";

    @JoinColumn(name = CEO_CODE,unique = true)
    private int cEOCode;

    @OneToOne(mappedBy = "cEO")
    private BankBranch bankBranch;

    public CEO(String firstName, String lastName, String email, String phoneNumber, String nationalCode, LocalDate birthDate, int cEOCode) {
        super(firstName, lastName, email, phoneNumber, nationalCode, birthDate);
        this.cEOCode = cEOCode;
    }
}
