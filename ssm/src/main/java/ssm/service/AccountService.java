package ssm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.dao.IAccountDao;
import ssm.entity.Account;

@Service("accountService")
public class AccountService implements IAccountService{
	 @Autowired
	    private IAccountDao accountDao;
	@Override
	public void saveAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.saveAccount(account);
	}

	@Override
	public List<Account> findAll() {
		 System.out.println("业务层：查询所有账户...");
	     return accountDao.findAll();
    }
	
}
