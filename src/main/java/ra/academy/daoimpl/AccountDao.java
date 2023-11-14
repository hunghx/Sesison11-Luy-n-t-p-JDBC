package ra.academy.daoimpl;

import ra.academy.dao.IAccountDao;
import ra.academy.model.Account;
import ra.academy.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao implements IAccountDao {
    @Override
    public Account login(String username, String password) {
        Connection conn = ConnectDB.getConnection();
        Account a = null;
        try {
            CallableStatement callSt = conn.prepareCall("{call Proc_Login_Account(?,?)}");
            callSt.setString(1,username);
            callSt.setString(2,password);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()){
                a = new Account();
                a.setId(rs.getLong("id"));
                a.setAccountCode(rs.getString("account_code"));
                a.setPhone(rs.getString("phone"));
                a.setUsername(rs.getString("username"));
                a.setAvatarUrl(rs.getString("avatar_url"));
                a.setBalance(rs.getBigDecimal("balance"));
                a.setFullName(rs.getString("full_name"));
                a.setStatus(rs.getBoolean("status"));
                a.setBirthDay(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return a;
    }

    @Override
    public List<Account> findAll() {
        Connection conn = ConnectDB.getConnection();
        List<Account> list = new ArrayList<>();
        try {
            CallableStatement callSt = conn.prepareCall("{call Proc_Find_All_Account()}");
            ResultSet rs = callSt.executeQuery();
            while (rs.next()){
                Account a = new Account();
                a.setId(rs.getLong("id"));
                a.setAccountCode(rs.getString("account_code"));
                a.setPhone(rs.getString("phone"));
                a.setUsername(rs.getString("username"));
                a.setAvatarUrl(rs.getString("avatar_url"));
                a.setFullName(rs.getString("full_name"));
                a.setBalance(rs.getBigDecimal("balance"));
                a.setStatus(rs.getBoolean("status"));
                a.setBirthDay(rs.getDate("birthday"));
                list.add(a);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return list;
    }

    @Override
    public Account findById(Long id) {
        Connection conn = ConnectDB.getConnection();
        Account a = null;
        try {
            CallableStatement callSt = conn.prepareCall("{call Proc_Find_Account_By_Id(?)}");
            callSt.setLong(1,id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()){
                a = new Account();
                a.setId(rs.getLong("id"));
                a.setAccountCode(rs.getString("account_code"));
                a.setPhone(rs.getString("phone"));
                a.setUsername(rs.getString("username"));
                a.setFullName(rs.getString("full_name"));
                a.setAvatarUrl(rs.getString("avatar_url"));
                a.setBalance(rs.getBigDecimal("balance"));
                a.setStatus(rs.getBoolean("status"));
                a.setBirthDay(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return a;
    }

    @Override
    public boolean save(Account account) {
        Connection conn = ConnectDB.getConnection();
        CallableStatement callSt = null;
        Account old = findById(account.getId());
        try {
            if(old!=null){
                // cập nhật

            }else {
                // thêm mới
                callSt = conn.prepareCall("{call Proc_Insert_Account(?,?,?,?,?,?)}");
                callSt.setString(1,account.getAccountCode());
                callSt.setString(2,account.getPhone());
                callSt.setString(3,account.getUsername());
                callSt.setString(4,account.getPassword());
                callSt.setDate(5,new Date(account.getBirthDay().getTime()));
                callSt.setString(6,account.getFullName());
                callSt.executeUpdate();
            }
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return true;
    }

    @Override
    public Account findAccountByCode(String code) {
        Connection conn = ConnectDB.getConnection();
        Account a = null;
        try {
            CallableStatement callSt = conn.prepareCall("{call Proc_Find_Account_By_Code(?)}");
            callSt.setString(1,code);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()){
                a = new Account();
                a.setId(rs.getLong("id"));
                a.setAccountCode(rs.getString("account_code"));
                a.setPhone(rs.getString("phone"));
                a.setUsername(rs.getString("username"));
                a.setFullName(rs.getString("full_name"));
                a.setAvatarUrl(rs.getString("avatar_url"));
                a.setBalance(rs.getBigDecimal("balance"));
                a.setStatus(rs.getBoolean("status"));
                a.setBirthDay(rs.getDate("birthday"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
        return a;
    }


    @Override
    public void deleteById(Long id) {

    }
}
