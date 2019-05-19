package ssm.dao;

import java.util.List;

import ssm.entity.Account;

public interface IAccountDao {
	public void saveAccount(Account account);
	public List<Account> findAll();
}
