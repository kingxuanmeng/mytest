package demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import demo.entity.Order;

@Component
public interface IOrderDao extends PagingAndSortingRepository<Order, Integer>{
	@Query("from Order order where order.userName like ?1 and order.password like ?2")
	List<Order> findone(String userName,String password);
}
