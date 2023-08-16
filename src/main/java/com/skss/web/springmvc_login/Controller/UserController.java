package com.skss.web.springmvc_login.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skss.web.springmvc_login.dao.impl.UserDaoimpl;
import com.skss.web.springmvc_login.dto.model.UserModel;

@Controller
public class UserController {
	
	@Autowired
	UserDaoimpl userDaoImpl;//copy
	
	
	
	@RequestMapping("editUser")//convention
		
		public ModelAndView editUser(@RequestParam int id   ) {
			
		UserModel existing=userDaoImpl.getUser(id);
		ModelAndView mv=new ModelAndView();
		mv.addObject("olduser",existing);
		mv.setViewName("edit.jsp");//lowercase
		return mv;
		
				}
	
	
	@RequestMapping("updateUser")//convention
	
	public ModelAndView updateUser(@ModelAttribute UserModel userModel   ) {
	
		String message=userDaoImpl.updateteUser(userModel);

		
	ModelAndView mv=new ModelAndView();
	mv.addObject("result",message);
	mv.setViewName("message.jsp");//lowercase
	return mv;
	
	}

	
	
@RequestMapping("deleteUser")//convention
	
	public ModelAndView deleteUser(@RequestParam int id   ) {
	
	String message=userDaoImpl.deleteUser(id);
	
		//ArrayList<UserModel> users=userDaoImpl.getAllUsers();
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",message);
		mv.setViewName("message.jsp");//lowercase
		return mv;
	
}


	
	
@RequestMapping("displayUsers")//convention
	
	public ModelAndView displayUsers() {
		ArrayList<UserModel> users=userDaoImpl.getAllUsers();
		ModelAndView mv=new ModelAndView();
		mv.addObject("allusers",users);
		mv.setViewName("displayusers.jsp");//lowercase
		return mv;
		
	}

	

		@RequestMapping("createUser")//convention
	
	public ModelAndView createUser() {
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",new UserModel());
		mv.setViewName("createuser.jsp");//lowercase
		return mv;
	
	}

		
		
	@RequestMapping("saveUser")//convention
	
	public ModelAndView saveUser(@ModelAttribute UserModel user) {
		
		String message=userDaoImpl.saveUser(user);
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("result",message);
		mv.setViewName("message.jsp");//lowercase
		return mv;
		
	}
	

}







