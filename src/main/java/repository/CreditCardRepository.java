package repository;

import base.repository.BaseRepository;
import domain.CreditCard;

public interface CreditCardRepository extends BaseRepository<CreditCard, Long> {

    CreditCard findCreditCardByCardNumber(long cardNumber);

    CreditCard findCreditCardByShebaNumber(String shebaNumberString);

    CreditCard findCreditCardById(long id);
}
