package edu.mum.libaray.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.BookCopy;
import edu.mum.libaray.web.libarary.service.ConfigurationService;
import edu.mum.libaray.web.repository.AuthorRepository;

@Controller
@RequestMapping("/author")
public class AuthorController extends MainController{
	
	@Autowired
	ConfigurationService configurationService;
	
	@RequestMapping(value="/addAuthor",method=RequestMethod.GET)
	public String addAuthor(Model model){
		model.addAttribute("author",new Author());
		return "author_add";
	}


	@RequestMapping(value="/addAuthor", method=RequestMethod.POST)
	public String addAuthor(@ModelAttribute("author") Author author){
		configurationService.save(author);
		
			return "redirect:/author/authorlist";
	}
	
	@RequestMapping(value="/authorlist", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("authors",configurationService.findAllAuthors());
		return "author_list";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getAuthor(@PathVariable long id,Model model){
		model.addAttribute("authors",configurationService.findAuthor(id));
		return "author_edit";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String update(Author author,@PathVariable long id){
		configurationService.save(author);;
		
		return "redirect:/author/authorlist";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(long authorId) {
		configurationService.deleteAuthor(authorId);;;
		return "redirect:/author/authorlist";
	}
}
