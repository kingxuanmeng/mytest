package com.demo.ex05;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileuploadController {
	//单文件上传
	@RequestMapping(value="/uploads",method=RequestMethod.POST)
	public @ResponseBody String processUpload(@RequestParam MultipartFile file, Model model) throws IOException {
		System.out.println("文件类型："+file.getContentType());
		System.out.println("文件名："+file.getOriginalFilename());
      	System.out.println("文件大小："+file.getSize());
		model.addAttribute("message", "File '" + file.getOriginalFilename() + "' uploaded successfully");
		 try {
			 	File file1=new File("E:\\"+file.getOriginalFilename());
	            file.transferTo(file1);//用file.transferTo（"fileURL"）方法来对上传文件进行存储
	            return file.getOriginalFilename()+ "  上传成功！";
	        } catch (IllegalStateException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		return "上传失败";
	}
	
	//多文件上传
	@RequestMapping(value="/uploadfiles",method=RequestMethod.POST)
	public @ResponseBody String processUpload1(@RequestParam("files") MultipartFile files[], Model model) throws IOException {
		for(int i=0;i<files.length;i++) {
			System.out.println("文件类型："+files[i].getContentType());
			System.out.println("文件名："+files[i].getOriginalFilename());
	      	System.out.println("文件大小："+files[i].getSize());
			 try {
				 	File file1=new File("E:\\"+files[i].getOriginalFilename());
				 	files[i].transferTo(file1);//用file.transferTo（"fileURL"）方法来对上传文件进行存储
				 	if((i+1)==files.length) {
				 		return "上传成功！";
				 	}
		        } catch (IllegalStateException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (IOException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		}
		return "上传失败";
	}
}
