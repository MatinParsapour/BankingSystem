package repository;

import base.repository.BaseRepository;
import domain.Transaction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends BaseRepository<Transaction,Long> {

    Transaction findTransactionByTrackingNo(int trackingNo);

    Transaction findTransactionByReferenceNo(long referenceNo);

    List<Transaction> findTransactionsBasedOnDate(LocalDateTime requestDate,long id);
}
