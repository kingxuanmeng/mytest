package ssm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import ssm.dao.IAccountDao;
import ssm.entity.Account;

public class MybatisTest {
	@Test
	public void save() throws IOException {
		Account account=new Account();
		account.setName("test");
		account.setMoney((double) 100);
		InputStream inputStream=Resources.getResourceAsStream("SqlMapper.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=factory.openSession();
		IAccountDao accountDao=sqlSession.getMapper(IAccountDao.class);
		accountDao.saveAccount(account);
		sqlSession.commit();
		sqlSession.close();
		inputStream.close();
	}
}
