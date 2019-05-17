package com.demo.ex02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.ex02.entity.User;

@Controller
public class JsonController {
	@RequestMapping(value="/mapping/user", method=RequestMethod.GET)
	public @ResponseBody User byProducesJson() {
		return new User();
	}
}
