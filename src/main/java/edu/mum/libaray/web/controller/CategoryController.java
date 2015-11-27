package edu.mum.libaray.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.Category;
import edu.mum.libaray.web.libarary.service.ConfigurationService;
import edu.mum.libaray.web.repository.CategoryRepository;



@Controller
@RequestMapping("/category")
public class CategoryController  extends MainController{
	
	@Autowired
	ConfigurationService configurationService;
	
	@RequestMapping(value="/addCategory",method=RequestMethod.GET)
	public String addAuthor(Model model){
		return "category_add";
	}


	@RequestMapping(value="/addCategory", method=RequestMethod.POST)
	public String addAuthor(@ModelAttribute("category") Category category){
		configurationService.save(category);
		
			return "redirect:/category/categorylist";
	}
	
	@RequestMapping(value="/categorylist", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("categories",configurationService.findAllCategory());
		return "category_list";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getAuthor(@PathVariable long id,Model model){
		model.addAttribute("categories",configurationService.findCategory(id));
		return "category_edit";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String update(Category category,@PathVariable long id){
		configurationService.save(category);
		
		return "redirect:/category/categorylist";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(long categoryId) {
		configurationService.deleteCategory(categoryId);;
		return "redirect:/category/categorylist";
	}

}

