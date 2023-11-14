package ra.academy.serviceimpl;

import org.apache.commons.lang3.RandomStringUtils;
import ra.academy.dao.IAccountDao;
import ra.academy.dao.ITransactionDao;
import ra.academy.daoimpl.AccountDao;
import ra.academy.daoimpl.TransactionDao;
import ra.academy.model.Account;
import ra.academy.model.Transaction;
import ra.academy.service.ITransactionService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TransactionService implements ITransactionService {
    private IAccountDao accountDao =new AccountDao();
    private ITransactionDao transactionDao = new TransactionDao();
    @Override
    public List<Transaction> findAll() {
        return null;
    }

    @Override
    public Transaction findById(String id) {
        return null;
    }

    @Override
    public boolean save(Transaction transaction) {
        return false;
    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public List<Transaction> findByAccountId(Long accountId) {
        return null;
    }

    @Override
    public List<Transaction> findByAccountIdAndPayTime(Long accountId, Date startTime, Date endTime) {
        return null;
    }

    @Override
    public boolean payment(String receiverCode, String senderCode, double amount, String comment) {
       // tạo mã giao dịch
        String transId = RandomStringUtils.randomAlphanumeric(10);
        // lấy id của tài khoản thông qua số tài khoản
        Account sender= accountDao.findAccountByCode(senderCode);
        Account receiver= accountDao.findAccountByCode(receiverCode);
        BigDecimal money = new BigDecimal(amount);
        transactionDao.payment(transId,receiver.getId(),sender.getId(),money,comment);
        return true;
    }
}
