package ra.academy.service;

import ra.academy.model.Account;

public interface IAccountService extends IGenericService<Account,Long>{

    Account login(String username, String password);
    Account checkAccountByCode(String code);
}
