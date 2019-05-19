package Test;



import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import demo.entity.Order;
import demo.service.IOrderService;

public class OrderTest extends Common{
	@Autowired
	private IOrderService orderService;
	@Test
	@Rollback(value=false)
	public void save() {
		Order order=new Order();
		order.setPrice(5);
		orderService.save(order);
	}
	
	@Test
	public void find() {
		orderService.findAll();
		
	}
}
