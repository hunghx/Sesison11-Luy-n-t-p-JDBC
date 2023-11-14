package ra.academy.daoimpl;

import ra.academy.dao.ITransactionDao;
import ra.academy.model.Account;
import ra.academy.model.Transaction;
import ra.academy.util.ConnectDB;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class TransactionDao implements ITransactionDao {
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
    public boolean payment(String transId, Long receiverId, Long senderId, BigDecimal amount, String comment) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("{call Proc_Payment(?,?,?,?,?,?)}");
            callSt.setString(1,transId);
            callSt.setLong(2,senderId);
            callSt.setLong(3,receiverId);
            callSt.setBigDecimal(4,amount);
            callSt.setString(5,comment);
            callSt.registerOutParameter(6, Types.VARCHAR);
            callSt.executeUpdate();
            String out = callSt.getString(6);
        } catch (SQLException e) {
            return false;
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return true;
    }
}
