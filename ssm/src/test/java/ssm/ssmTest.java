package ssm;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ssm.service.AccountService;

public class ssmTest {
	@Test
	public void run1() {
		ApplicationContext ac = new
				ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		AccountService as = (AccountService) ac.getBean("accountService");
		as.findAll();
	}
}
