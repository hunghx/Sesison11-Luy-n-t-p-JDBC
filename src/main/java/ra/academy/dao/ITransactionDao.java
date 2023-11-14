package ra.academy.dao;

import ra.academy.model.Transaction;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface ITransactionDao extends IGenericDao<Transaction,String> {

    List<Transaction> findByAccountId(Long accountId);
    List<Transaction> findByAccountIdAndPayTime(Long accountId, Date startTime, Date endTime);
    boolean payment(String transId, Long receiverId, Long senderId, BigDecimal amount, String comment);


}
