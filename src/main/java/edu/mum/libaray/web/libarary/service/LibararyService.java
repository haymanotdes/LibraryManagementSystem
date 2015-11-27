package edu.mum.libaray.web.libarary.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.quartz.JobBuilder;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.libaray.web.entity.Author;
import edu.mum.libaray.web.entity.Book;
import edu.mum.libaray.web.entity.BookCopy;
import edu.mum.libaray.web.entity.Borrow;
import edu.mum.libaray.web.entity.Fine;
import edu.mum.libaray.web.entity.Publisher;
import edu.mum.libaray.web.entity.User;
import edu.mum.libaray.web.repository.AuthorRepository;
import edu.mum.libaray.web.repository.BookCopyRepository;
import edu.mum.libaray.web.repository.BookRepository;
import edu.mum.libaray.web.repository.BorrowRepository;
import edu.mum.libaray.web.repository.FineRepository;
import edu.mum.libaray.web.repository.PublisherRepository;
import edu.mum.libaray.web.repository.UserRepository;

public class LibararyService {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	FineRepository	fineRepository;
	
	@Autowired
	BorrowRepository borrowRepository;
	
	@Autowired
	AuthorRepository authorRepository;
	
	@Autowired
	PublisherRepository publisherRepository;
	
	@Autowired
	BookCopyRepository bookCopyRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	
	
	public LibararyService(){
		
				
	}
	
	public List<String> getAnything(){
		
		List<String> ss=new ArrayList<String>();
		ss.add("one");
		ss.add("two");
		ss.add("three");
		
		return ss;
	}
	
	public List<Book> searchBook(String name, Long publisher,Long author){
		
		
		
		return bookRepository.findByNameLikeAndPublisherIdAndAuthorId(name, publisher, author);
		
	}
public List<Book> searchBook(String name){
			
		
		return bookRepository.findByNameLike(name);
		
	}
public List<Book> searchBook(Long publisher){
	
	
	return bookRepository.findByPublisherId(publisher);
	
}
public List<Book> searchBookByAuthor(Long author){
	
	
	return bookRepository.findByAuthorId(author);
	
}

public List<Book> searchBook(String name, Long publisher){
	
	
	return bookRepository.findByNameLikeAndPublisherId(name,publisher);
	
}
public List<Book> getAllBooks(){
	
	Iterable<Book> iterable=bookRepository.findAll();
	List<Book> list=new ArrayList<Book>();
	
	for(Book book: iterable) {
        list.add(book);
      }
	
	return Collections.unmodifiableList(list);
	 
	
}

	
	public List<Fine> getFinesForUser(long userid){
		
		return fineRepository.findByBorrowUserId(userid);
		
	}
	public List<Borrow> searchBorrows(long userid,Date takeDate,Date returnDate,String bookName){
		
		return borrowRepository.findByUserIdOrTakeDateOrReturnDateOrBookCopyBookNameLike(
				userid, takeDate, returnDate, bookName);
		
	}
public List<Borrow> searchBorrows(long userid){
		
		return borrowRepository.findByUserId(userid);
	
		
	}
    @Transactional(propagation=Propagation.REQUIRED)
	public void placeBorrow(Borrow borrow, Long bookCopyId, Long userId){
		userId=1L;
		
		borrow.setBookCopy(bookCopyRepository.findOne(bookCopyId));
		borrow.setUser(userRepository.findOne(userId));
		borrowRepository.save(borrow);
		
	}
public List<Borrow>	getAllBorrow(){
	
	/*Iterable<Borrow> iterable=borrowRepository.findAll();
	List<Borrow> list=new ArrayList<Borrow>();
	
	for(Borrow borrow: iterable) {

        list.add(borrow);
	
		
	}
	
	return Collections.unmodifiableList(list);*/
	return borrowRepository.findByReturned(false);
		
}

public List<Borrow> getAllUnReturnedBorrows(){
	
	System.out.println("getAllUnReturnedBorrows size: "+(borrowRepository.findByReturned(false)).size());
	return borrowRepository.findByReturned(false);
	
}



@Transactional(propagation=Propagation.REQUIRED)
public void returnBorrowedBook(Long borrowId){
	
	Borrow borrow=borrowRepository.findOne(borrowId);
	borrow.setReturned(true);
	borrow.setReturnedDate(Calendar.getInstance().getTime());
	borrowRepository.save(borrow);
	BookCopy bookCopy=borrow.getBookCopy();
	bookCopy.setAvailable(true);
	bookCopyRepository.save(bookCopy);
}
public List<Borrow> getAllBorrowByUserId(Long userid){
	
	return borrowRepository.findByUserId(userid);
	
}
public List<Publisher>	getAllPublishers(){
	
	Iterable<Publisher> iterable=publisherRepository.findAll();
	List<Publisher> list=new ArrayList<Publisher>();
	
	for(Publisher publisher: iterable) {
        list.add(publisher);
      }
	
	return Collections.unmodifiableList(list);
		
}

public List<Author>	getAllAuthors(){
	
	Iterable<Author> iterable=authorRepository.findAll();
	List<Author> list=new ArrayList<Author>();
	
	for(Author author: iterable) {
        list.add(author);
      }
	
	return Collections.unmodifiableList(list);
		
}
public List<Fine> getAllFines(){
	
	Iterable<Fine> iterable=fineRepository.findAll();
	List<Fine> list=new ArrayList<Fine>();
	
	for(Fine fine: iterable) {
        list.add(fine);
      }
	
	return Collections.unmodifiableList(list);
		
		
		
	}

public List<BookCopy> getAvailableBookcopyByBookid(Long bookid){
	
	return bookCopyRepository.findByBookIdAndAvailable(bookid,true);
}


public List<User> getAllUsers(){
	
	Iterable<User> iterable=userRepository.findAll();
	List<User> list=new ArrayList<User>();
	
	for(User user: iterable) {
        list.add(user);
      }
	
	return Collections.unmodifiableList(list);
	
	
	
}

public void remindUserToReturnBook(Date returnDate,String userEmailAddress){
	
	//Scheduler scheduler =new StdSchedulerFactory().getScheduler();
	//scheduler.start();
//	JobDetail jobDetail= JobBuilder.newJob(ReturnBookRemindJob.class);
//			new JobDetail("HelloWorldJob",scheduler.DEFAULT_GROUP,ReturnBookRemindJob.class);
	try {
	
	JobDetail jobDetail = JobBuilder.newJob(ReturnBookRemindJob.class)
																	.withIdentity("ReturnBookRemindJob", "group1").build();
	//JobDetail job = JobBuilder.newJob(HelloJob.class)			.withIdentity("dummyJobName", "group1").build();
	Trigger trigger = TriggerBuilder
			.newTrigger()
			.withIdentity("dummyTriggerName", "group1")
			.withSchedule(
				SimpleScheduleBuilder.simpleSchedule()
					.withIntervalInSeconds(5).repeatForever())
			.build();

		// schedule it
		Scheduler scheduler;
		
			scheduler = new StdSchedulerFactory().getScheduler();
		
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
	
	//Trigger simpleTrigger=new SimpleTrigger("mytrigger",scheduler.DEFAULT_GROUP,returnDate,null,SimpleTrigger.REPEAT_INDEFINITELY,5000);
	//scheduler.scheduleJob(jobDetail, simpleTrigger);
	} catch (SchedulerException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

}
