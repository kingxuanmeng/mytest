package ssm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ssm.entity.Account;
import ssm.service.IAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:applicationContext.xml"})
public class SpringMybatisTest {
	@Autowired
	IAccountService accountService;
	
	@Test
	public void save() {
		Account account=new Account();
		account.setName("测试");
		account.setMoney((double) 10);
		accountService.saveAccount(account);
	}
}
