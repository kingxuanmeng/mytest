package demo.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import demo.entity.Order;
import demo.entity.User;
import demo.service.IUserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private IUserService userService;
	//登录
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(@RequestParam String userName,@RequestParam String password) {
		List<User>  user=userService.findOne(userName,password);
		if(user.size()!=0) {
			return "index";
		}
		return "login";
	}
	
	
	//注册
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String register(User user,@RequestParam String userName,@RequestParam String password) {
		/*
		 * user.setUserName(userName); user.setPassword(password);
		 */
		userService.save(user);
	
		return "login";
	}
	
	//查询所有用户
	@RequestMapping(value="search")
	public String search(@RequestParam(value="pageNo",required=false,defaultValue="1")String pageNoStr, Map<String,Object>map){
		int pageNo=1;
		try {
			pageNo=Integer.parseInt(pageNoStr);
			if(pageNo<0) {
				pageNo=1;
			}
		}catch(Exception e) {
			
		}
		Page<User> page=userService.findAll(pageNo,3);
		map.put("page",page);
		return "allUser";
//		map.put("userList",userService.findAll());
//		return "allUser";
	}
	
	//删除一个用户
	@RequestMapping(value="delete")
	public String delete(Integer id) {
		userService.delete(id);
		return "redirect:search";
	}
}
