package ssm.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import ssm.entity.Account;

public interface IAccountService {
	public void saveAccount(Account account);
	public List<Account> findAll();
	//String findAll(Model model);
	//void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response);
}
