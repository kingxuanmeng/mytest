package demo.service;

import java.util.List;

import demo.entity.Order;


public interface IOrderService {
	public void save(Order entity);
	public void delete(Integer id);
	public List<Order> findAll();
	public List<Order> findOne(String userName,String password);
}
