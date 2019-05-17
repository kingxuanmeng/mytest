package com.demo.ex04;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.ex02.entity.User;
@ControllerAdvice
@RequestMapping(value="/response", method=RequestMethod.GET)
public class ResponseController {
	@RequestMapping("/a")
	public @ResponseBody String response(){
		return "The String ResponseBody";
	}
	@RequestMapping("/charset/a")//无设置编码格式导致乱码，可依照下面一个函数或者在spring-mvc.xml中全局配置编码格式
	public @ResponseBody String CharsetResponse() {
		return "\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)";
	}
	@RequestMapping(value="/charset/produces",produces="text/plain;charset=UTF-8")
	public @ResponseBody String CharsetProduce() {
		return "\u3053\u3093\u306b\u3061\u306f\u4e16\u754c\uff01 (\"Hello world!\" in Japanese)";
	}
//	HttpStatus.OK = 200;
//	HttpStatus.BAD_REQUEST = 400;
//	HttpStatus.FORBIDDEN = 403;
//	HttpStatus.NOT_FOUND = 404;
//	HttpStatus.REQUEST_TIMEOUT = 408;
//	HttpStatus.SERVICE_UNAVAILABLE =500;
	@RequestMapping("/entity/headers")
	public ResponseEntity<String> responseEntityCustomHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		return new ResponseEntity<String>("The String ResponseBody with custom header Content-Type=text/plain",
				headers, HttpStatus.OK);
	}
	@RequestMapping("/entity/status")
	public ResponseEntity<String> responseEntityStatusCode() {
		return new ResponseEntity<String>("The String ResponseBody with custom status code (403 Forbidden)",
				HttpStatus.FORBIDDEN);
	}
}