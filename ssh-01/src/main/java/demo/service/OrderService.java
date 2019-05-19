package demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.IOrderDao;
import demo.entity.Order;

@Service
@Transactional
public class OrderService implements IOrderService{
	@Autowired
	private IOrderDao orderDao;

	@Override
	public void save(Order entity) {
		// TODO Auto-generated method stub
		orderDao.save(entity);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		orderDao.delete(id);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return (List<Order>) orderDao.findAll();
	}
	@Override
	public List<Order> findOne(String userName,String password) {
		// TODO Auto-generated method stub
		return orderDao.findone(userName, password);
	}
	
}
