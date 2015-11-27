package edu.mum.libaray.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.Book;
import edu.mum.libaray.web.entity.BookCopy;
import edu.mum.libaray.web.entity.Borrow;
import edu.mum.libaray.web.entity.Fine;
import edu.mum.libaray.web.entity.Publisher;
import edu.mum.libaray.web.libarary.service.AdministrationService;
import edu.mum.libaray.web.libarary.service.LibararyService;
import edu.mum.libaray.web.repository.BookCopyRepository;

@Controller
public class MainLibraryController  extends MainController{
	
	
	@Autowired
	BookCopyRepository bookCopyRepository;
	
	@Autowired
	LibararyService	libararyService;
	
	@Autowired
	AdministrationService administrationService;
	
	
	@RequestMapping(value="/*")
	@ResponseBody
	public String goError(){
		
		return "requested url is not here";
	}
	
	@RequestMapping(value="/")
	public String goRoot(){
		
	/*	return  "/book/search";*/
		return "redirect:/book/search";
	}
	
	@RequestMapping(value="/bookcopy/listavailable/{book}")
	public String goToBookCopyAvailableToBorrow(@PathVariable Long book,
			Model model){
		//ToDo get all available bookCopy for the selected bookid and add it to the Model
		//bookCopyRepository.findByBookIdAndAvailable(id, true);
		model.addAttribute("bookCopies",libararyService.getAvailableBookcopyByBookid(book));
		return "available_book_copy";
		
		
	}
/*	@RequestMapping(value="/bookcopyborrow/{bookcopy}")*/
	@RequestMapping(value="/bookcopyborrow")
	public String goToBorrow(@ModelAttribute ("bookcopy") Long bookcopy,
			
			Model model){
		//ToDo get all available bookCopy for the selected bookid and add it to the Model
		//bookCopyRepository.findByBookIdAndAvailable(id, true);
		model.addAttribute("bookcopyid",bookcopy);
		model.addAttribute("users",administrationService.findAllUser());
		model.addAttribute("borrow",new Borrow());
		System.out.println("===========================kkkk");
		return "Book_Copy_Borrow";
		
		
	}
	
	/*@RequestMapping(value="/borrow/addBorrow",method=RequestMethod.POST)*/
	@RequestMapping(value="/bookcopyborrow22",method=RequestMethod.GET)
	public String saveBookBorrow(
			@RequestParam(value = "userid") Long  userid,
			@RequestParam(value="takeDate") String takeDate,
			@RequestParam(value="returnDate") String returnDate,
			@RequestParam(value="bookcopyid") Long bookcopyid,
			final RedirectAttributes redirectAttributes
			//@ModelAttribute("borrow") Borrow borrow
			){
		System.out.println("===========================sssss");
		
		System.out.println("======================takeDate"+takeDate);
		System.out.println("======================returnDate"+returnDate);
		//ToDo get all available bookCopy for the selected bookid and add it to the Model
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try{
		Date takeDateObject=formatter.parse(takeDate);
		Date returnDateObject=formatter.parse(returnDate);
		
			Borrow borrow=new Borrow();
		borrow.setTakeDate(takeDateObject);
		borrow.setReturnDate(returnDateObject);
		libararyService.placeBorrow(borrow,bookcopyid,userid);
		
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
		
		/*System.out.println("===================================userid "+userid);*/
	/*	System.out.println("===================================userid "+((String)request.getAttribute("userid")));
		
		Long bookcopyid=Long.decode((String)request.getAttribute("bookcopyid"));
		Long userid=Long.decode((String)request.getAttribute("userid"));
		System.out.println("===================================userid : "+userid);
		System.out.println("===================================bookcopyid : "+bookcopyid);
		//libararyService.placeBorrow(borrow,bookcopy,userid);
		redirectAttributes.addFlashAttribute("userid", userid);
		//forward:/results
		 * 
*/		
	/*	Borrow borrow=new Borrow();
		borrow.setTakeDate(takeDate);
		borrow.setReturnDate(returnDate);
		libararyService.placeBorrow(borrow,bookcopyid,userid);*/
		
		/*redirectAttributes.addFlashAttribute("userid", userid);*/
		return "redirect:/bookborrow/search";
	}

	@RequestMapping(value="/bookborrow/search")
	public String searchBookBorrow(/*@RequestParam(value = "user", required = false)*/
			//@PathVariable Long user,
//			@RequestParam(value = "takeDate", required = false) Date takeDate,
//			@RequestParam(value = "returnDate", required = false) Date returnDate,
//			@RequestParam(value = "bookName", required = false) String book,
			/*@ModelAttribute ("userid") Long userid,*/
			Model model){
		//ToDo get all available bookCopy for the selected bookid and add it to the Model
	
		/*if(userid!=null ){
			System.out.println("OOOO===================================userid : "+userid);
		model.addAttribute("brrows",libararyService.getAllBorrowByUserId(userid));}
		else{*/
		
			model.addAttribute("brrows",libararyService.getAllBorrow());
		
		
		//bookCopyRepository.findByBookIdAndAvailable(id, true);
		
		return "bookborrow_list";
	}
	
	@RequestMapping(value="/bookborrow/searchUnreturned")
	public String searchUnturnedBorrow(Model model){
		
		model.addAttribute("brrows",libararyService.getAllUnReturnedBorrows());
		return "bookborrow_list";
	}
	
	
	@RequestMapping(value="/bookborrow/list")
	public String listBookBorrow(HttpServletRequest request,Model model){
		//ToDo get all available bookCopy for the selected bookid and add it to the Model
		Long Userid=Long.parseLong((String)request.getAttribute("userid"));
				
		model.addAttribute("borrows",libararyService.getAllBorrowByUserId(Userid));
		//bookCopyRepository.findByBookIdAndAvailable(id, true);
		
		return "bookborrow_list";
	}
	
	@RequestMapping(value="/borrowfine/list")
	public String listBookfine(@RequestParam(value = "userid", required = false) Long userid,
								Model model){
		//ToDo get all available book fines for the selected user id and add it to the Model
		List<Fine> fines=null;
		
		if(userid!=null){
			fines=libararyService.getFinesForUser(userid);}
		else{
			
			fines=libararyService.getAllFines();}
		model.addAttribute("fines", fines);
		
		
		return "bookfine_list";
	}
	
	@RequestMapping(value="/book/search")
	public String goToBooksearch(@RequestParam(value = "publisher", required = false) Long publisher,
								@RequestParam(value = "author", required = false) Long author,
								@RequestParam(value = "name", required = false) String name,
								Model model){
		//ToDo get all available book fines for the selected user id and add it to the Model
//		List<Publisher> publishers=new ArrayList<Publisher>();
//		
//		Publisher p1=new Publisher();
//		p1.setName("aaaabbbbbccc");
//		p1.setId(1);
//		publishers.add(p1);
//		Publisher p2=new Publisher();
//		p2.setName("ddddeeeeeffff");
//		p2.setId(2);
//		publishers.add(p2);
		
		model.addAttribute("publishers", libararyService.getAllPublishers());
		
//List<Author> authors=new ArrayList<Author>();
//		
//Author a1=new Author();
//		a1.setFname("jkjkjkjkj");
//		a1.setId(1);
//		authors.add(a1);
//		Author a2=new Author();
//		a2.setFname("ytytytytyt");
//		a2.setId(2);
//		authors.add(a2);
		
		model.addAttribute("authors", libararyService.getAllAuthors());
		
		System.out.println("publisher:"+publisher);
		System.out.println("author:"+author);
		System.out.println("name:"+name);
		//bookCopyRepository.findByBookIdAndAvailable(id, true);
		if(name!=null && publisher!=null && author!=null ){
		model.addAttribute("books", libararyService.searchBook(name, publisher, author));
		}else if(name!=null && publisher!=null){
			model.addAttribute("books", libararyService.searchBook(name, publisher));
		}else if(name!=null && name.equals("")&& publisher!=null){
			model.addAttribute("books", libararyService.searchBook(publisher));
		}else if(name!=null && name.equals("")&& author!=null){
			model.addAttribute("books", libararyService.searchBookByAuthor(author));
		}
		
		else if(name!=null ){
			model.addAttribute("books", libararyService.searchBook(name));
		}else{
			
			model.addAttribute("books", libararyService.getAllBooks());
		}
		
		return "book_search";
	}
	
	@RequestMapping(value="/bookborrow/{id}")
	public String returnBook(@PathVariable long id){
		
		
		//update get all borrow to get all borrow that not retune
		libararyService.returnBorrowedBook(id);
		return "redirect:/bookborrow/searchUnreturned";
		/*libararyService.*/
		
	}
	
	
	
	
	
	
	
}
