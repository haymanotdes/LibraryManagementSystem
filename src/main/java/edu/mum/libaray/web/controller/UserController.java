package edu.mum.libaray.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.Book;
import edu.mum.libaray.web.entity.User;
import edu.mum.libaray.web.libarary.service.AdministrationService;
import edu.mum.libaray.web.libarary.service.ConfigurationService;

@Controller
@RequestMapping("/user")
public class UserController  extends MainController{
	@Autowired
	AdministrationService administrationService;
	
	@RequestMapping(value="/addUser",method=RequestMethod.GET)
	public String addUser(Model model){
		model.addAttribute("user",new User());
		model.addAttribute("roles",administrationService.findAllRoles());
		return "user_add";
	}
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String addAuthor(@ModelAttribute("user") User user){
		administrationService.save(user);
		
			return "redirect:/user/userlist";
	}
	
	@RequestMapping(value="/userlist", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("users",administrationService.findAllUser());
		return "user_list";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getAuthor(@PathVariable long id,Model model){
		model.addAttribute("users",administrationService.findUser(id));
		model.addAttribute("roles",administrationService.findAllRoles());
		return "user_edit";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String update(User user,@PathVariable long id){
		administrationService.save(user);;
		
		return "redirect:/user/userlist";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(long userId) {
		administrationService.deleteUser(userId);;
		return "redirect:/user/userlist";
	}
	

}
