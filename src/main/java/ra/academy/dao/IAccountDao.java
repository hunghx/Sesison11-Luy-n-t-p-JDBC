package ra.academy.dao;

import ra.academy.model.Account;

public interface IAccountDao extends IGenericDao<Account,Long> {

    Account login(String username, String password);
    Account findAccountByCode(String code);
}
