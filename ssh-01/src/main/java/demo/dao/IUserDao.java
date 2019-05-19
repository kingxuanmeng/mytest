package demo.dao;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import demo.entity.User;

@Component
public interface IUserDao extends PagingAndSortingRepository<User, Integer>{
	@Query("from User user where user.userName like ?1 and user.password like ?2")
	List<User> findone(String userName,String password);
}
