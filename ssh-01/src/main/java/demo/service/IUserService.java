package demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import demo.entity.User;

public interface IUserService {
	public List<User> findOne(String userName,String password);
	public int save(User user);
	public Page<User> findAll(int pageNo,int pageSize);
	public void delete(Integer id);
}
