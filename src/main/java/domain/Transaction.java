package domain;

import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = Transaction.TABLE_NAME)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction extends BaseEntity<Long> {

    public static final String TABLE_NAME = "transaction_table";
    private static final String BANK_NAME = "bank_name";
    private static final String USER_SURE_NAME = "user_sure_name";
    private static final String SOURCE_CARD_NUMBER = "source_card_number";
    private static final String AMOUNT = "amount";
    private static final String DATE = "date";
    private static final String DESTINATION_CARD_NUMBER = "destination_card_number";
    private static final String BALANCE_AFTER_TRANSACTION = "balance_after_transaction";
    private static final String TRACKING_NO = "tracking_no";
    private static final String REFERENCE_NO = "reference_no";

    @JoinColumn(name = BANK_NAME)
    private String bankName;

    @JoinColumn(name = USER_SURE_NAME)
    private String userSureName;

    @JoinColumn(name = SOURCE_CARD_NUMBER)
    private long sourceCardNumber;

    @JoinColumn(name = DESTINATION_CARD_NUMBER)
    private long DestinationCardNumber;

    @JoinColumn(name = AMOUNT)
    private double amount;

    @JoinColumn(name = DATE)
    private LocalDateTime date;

    @JoinColumn(name = BALANCE_AFTER_TRANSACTION)
    private double balanceAfterTransaction;

    @JoinColumn(name = TRACKING_NO)
    private int trackingNo;

    @JoinColumn(name = REFERENCE_NO)
    private long referenceNo;
}
