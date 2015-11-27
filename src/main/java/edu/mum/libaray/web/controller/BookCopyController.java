package edu.mum.libaray.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.libaray.web.entity.Book;
import edu.mum.libaray.web.entity.BookCopy;
import edu.mum.libaray.web.libarary.service.ConfigurationService;
import edu.mum.libaray.web.repository.BookCopyRepository;

@Controller
@RequestMapping("/bookcopy")
public class BookCopyController  extends MainController{
	
	@Autowired
	ConfigurationService configurationService;
	
	@RequestMapping(value="/addCopy",method=RequestMethod.GET)
	public String addCopy(Model model){
		model.addAttribute("bookCopy",new BookCopy());
		model.addAttribute("books",configurationService.findBook());
		return "book_copy_add";
	}


@RequestMapping(value="/addCopy", method=RequestMethod.POST)
public String addCopy(@ModelAttribute("bookCopy")BookCopy bookCopy){
	configurationService.save(bookCopy);

	return "redirect:/bookcopy/bookCopylist";
}

@RequestMapping(value="/bookCopylist", method=RequestMethod.GET)
public String getAll(Model model) {
	
	model.addAttribute("bookCopies",configurationService.findAllBookCopy());
	return "book_copy_list";
}

@RequestMapping(value="/{id}", method=RequestMethod.GET)
public String getCopy(@PathVariable long id, Model model) {
	
	model.addAttribute("bookCopy", configurationService.findBookCopy(id));
	return "book_copy_edit";
}

@RequestMapping(value="/{id}", method=RequestMethod.POST)
public String update(BookCopy bookCopy, @PathVariable long id) {
	configurationService.save(bookCopy);
	
	return "redirect:/bookcopy/bookCopylist";
}

@RequestMapping(value="/delete", method=RequestMethod.POST)
public String delete(long bookCopyId) {
	configurationService.deleteBookCopy(bookCopyId);;;
	return "redirect:/bookcopy/bookCopylist";
}
}
