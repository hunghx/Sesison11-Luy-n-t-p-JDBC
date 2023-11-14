package ra.academy.service;

import ra.academy.model.Transaction;

import java.util.Date;
import java.util.List;

public interface ITransactionService extends IGenericService<Transaction,String> {

    List<Transaction> findByAccountId(Long accountId);
    List<Transaction> findByAccountIdAndPayTime(Long accountId, Date startTime, Date endTime);

    boolean payment(String receiverCode,String senderCode,double amount,String comment);

}
