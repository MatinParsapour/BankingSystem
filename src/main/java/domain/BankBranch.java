package domain;

import base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = BankBranch.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
public class BankBranch extends BaseEntity<Long> {
    public static final String TABLE_NAME = "bank_branch";
    private static final String CEO = "ceo";
    private static final String EMPLOYEES = "employees";
    private static final String BRANCH_CODE = "branch_code";
    private static final String BANK_NAME = "bank_name";
    private static final String BANK_ACCOUNTS = "bank_accounts";

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = CEO,unique = true)
    private CEO cEO;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = EMPLOYEES)
    private Set<Employee> employees;

    @JoinColumn(name = BRANCH_CODE,unique = true)
    private int branchCode;

    @JoinColumn(name = BANK_NAME)
    private String bankName;

    @OneToMany(mappedBy = "bankBranch",cascade = CascadeType.ALL)
    private Set<Account> bankAccounts;

    public BankBranch(domain.CEO cEO, int branchCode, String bankName) {
        this.cEO = cEO;
        employees = new TreeSet<>();
        this.branchCode = branchCode;
        this.bankName = bankName;
        bankAccounts = new TreeSet<>();
    }
}
