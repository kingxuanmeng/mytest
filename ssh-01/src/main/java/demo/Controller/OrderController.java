package demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.entity.Order;
import demo.service.IOrderService;


@Controller
@RequestMapping(value="/order")
public class OrderController {
	@Autowired
	private IOrderService ordervice;
	
	@RequestMapping(value="delete/{id}", method=RequestMethod.POST)
	public @ResponseBody String delete(@PathVariable("id") Integer id) {
		ordervice.delete(id);
		return "success";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestParam String userName,@RequestParam String password) {
		List<Order> order=ordervice.findOne(userName,password);
		if(order.size()!=0) {
			return "index";
		}
		return "login";
	}
}
