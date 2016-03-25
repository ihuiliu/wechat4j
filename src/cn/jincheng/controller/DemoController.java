package cn.jincheng.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import cn.jincheng.domain.User;
import cn.jincheng.service.UserService;
@Controller
public class DemoController {
	 @Resource
	  private UserService userService;


	 @RequestMapping("/showUser.action")
	    public ModelAndView toIndex() {
		 ModelAndView model=new ModelAndView();
	       // int userId = Integer.parseInt(request.getParameter("id"));
	        //User user = this.userService.getUserById(userId);
	        //model.addAttribute("user", user);
		List<User> list= userService.findAll();
		 System.out.println("--------------------"+list);
		 model.setViewName("haha");
	        return model;
	    }
	 
	 @RequestMapping("/save.action")
	    public ModelAndView toSave() {
		 ModelAndView model=new ModelAndView();
	       // int userId = Integer.parseInt(request.getParameter("id"));
	        //User user = this.userService.getUserById(userId);
	        //model.addAttribute("user", user);
		List<User> list= userService.findAll();
		User u1=new User();
		u1.setName("111");
		User u2=new User();
		u2.setName("1112");
		userService.save(u1);
		//int x=1/0;
		//userService.save(u2);
		 System.out.println("--------------------"+list);
		 model.setViewName("haha");
	        return model;
	    }
}
