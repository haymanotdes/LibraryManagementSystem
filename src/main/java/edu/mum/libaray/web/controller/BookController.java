package edu.mum.libaray.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.Book;
import edu.mum.libaray.web.entity.BookCopy;
import edu.mum.libaray.web.entity.Category;
import edu.mum.libaray.web.entity.Publisher;
import edu.mum.libaray.web.libarary.service.ConfigurationService;
import edu.mum.libaray.web.repository.BookCopyRepository;
import edu.mum.libaray.web.repository.BookRepository;

//import edu.mum.libaray.web.libarary.service.LibararyService;

@Controller
@RequestMapping("/book")

public class BookController  extends MainController{
	
	@Autowired
	ConfigurationService configurationService;
	
	@RequestMapping(value="/addBook",method=RequestMethod.GET)
	public String addBook(Model model){
		model.addAttribute("book",new Book());
		
		model.addAttribute("publisherlist",configurationService.findPublisher());
		model.addAttribute("authorlist",configurationService.findAllAuthors());
		model.addAttribute("categorylist",configurationService.findAllCategory());
		return "book_add";
	}


	@RequestMapping(value="/addBook", method=RequestMethod.POST)
	public String addBook(/*@Valid*/ @ModelAttribute("book") Book book/*,BindingResult result*/){
	/*	if(!result.hasErrors()){*/
			configurationService.save(book);
		/*}
		else{*/
			/*return "redirect:/book/addBook";*/
	/*	}*/
		
	
		
		
			return "redirect:/book/booklist";
	}
	
	@RequestMapping(value="/booklist", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("books",configurationService.findBook());
		return "book_list";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getBook(@PathVariable long id,Model model){
		model.addAttribute("book",configurationService.findBook(id));
		model.addAttribute("books",configurationService.findBook(id));
		model.addAttribute("publisherlist",configurationService.findPublisher());
		
		return "book_edit";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String update(Book book,@PathVariable long id){
		configurationService.save(book);
		
		return "redirect:/book/booklist";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(long bookId) {
		configurationService.deleteBook(bookId);
		return "redirect:/book/booklist";
	}
	
}
