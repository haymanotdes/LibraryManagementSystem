package edu.mum.libaray.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.libaray.web.entity.Role;
import edu.mum.libaray.web.entity.User;
import edu.mum.libaray.web.libarary.service.AdministrationService;

@Controller
@RequestMapping("/role")
public class RoleController  extends MainController{
	
	@Autowired
	AdministrationService administrationService;
	
	@RequestMapping(value="/addRole",method=RequestMethod.GET)
	public String addRole(Model model){
		return "role_add";
	}
	
	@RequestMapping(value="/addRole", method=RequestMethod.POST)
	public String addRole(@ModelAttribute("role") Role role){
		administrationService.save(role);;
		
			return "redirect:/role/rolelist";
	}
	
	@RequestMapping(value="/rolelist", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("roles",administrationService.findAllRoles());
		return "role_list";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getRole(@PathVariable long id,Model model){
		model.addAttribute("roles",administrationService.findRole(id));
		return "role_edit";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String update(Role role,@PathVariable long id){
		administrationService.save(role);
		
		return "redirect:/role/rolelist";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(long roleId) {
		administrationService.deleteRole(roleId);;
		return "redirect:/role/rolelist";
	}

}
