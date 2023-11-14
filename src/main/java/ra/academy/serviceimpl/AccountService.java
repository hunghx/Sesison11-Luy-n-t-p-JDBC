package ra.academy.serviceimpl;

import ra.academy.dao.IAccountDao;
import ra.academy.daoimpl.AccountDao;
import ra.academy.model.Account;
import ra.academy.service.IAccountService;

import java.util.List;

public class AccountService implements IAccountService {
    private IAccountDao accountDao = new AccountDao();
    @Override
    public Account login(String username, String password) {
        return accountDao.login(username,password);
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Long id) {
        return accountDao.findById(id);
    }

    @Override
    public boolean save(Account account) {
        // logic
        account.setAccountCode(account.getPhone());
        return accountDao.save(account);
    }

    @Override
    public Account checkAccountByCode(String code) {
        return accountDao.findAccountByCode(code);
    }

    @Override
    public void deleteById(Long id) {

    }

}
