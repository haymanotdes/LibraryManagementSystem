package edu.mum.libaray.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.libaray.web.entity.Category;
import edu.mum.libaray.web.entity.Publisher;
import edu.mum.libaray.web.libarary.service.ConfigurationService;
import edu.mum.libaray.web.repository.BookRepository;
import edu.mum.libaray.web.repository.PublisherRepository;


@Controller
@RequestMapping("/publisher")
public class PublisherController  extends MainController{
	
	@Autowired
	ConfigurationService configurationService;
	
	@RequestMapping(value="/addPublisher",method=RequestMethod.GET)
	public String addPublisher(Model model){
		return "publisher_add";
	}


	@RequestMapping(value="/addPublisher", method=RequestMethod.POST)
	public String addAuthor(@ModelAttribute("publisher") Publisher publisher){
		configurationService.save(publisher);
		
			return "redirect:/publisher/publisherlist";
	}
	
	@RequestMapping(value="/publisherlist", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("publishers",configurationService.findPublisher());
		return "publisher_list";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getAuthor(@PathVariable long id,Model model){
		model.addAttribute("publishers",configurationService.findPublisher(id));
		return "publisher_edit";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String update(Publisher publisher,@PathVariable long id){
		configurationService.save(publisher);
		
		return "redirect:/publisher/publisherlist";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(long publisherId) {
		configurationService.deletePublisher(publisherId);;
		return "redirect:/publisher/publisherlist";
	}


}
