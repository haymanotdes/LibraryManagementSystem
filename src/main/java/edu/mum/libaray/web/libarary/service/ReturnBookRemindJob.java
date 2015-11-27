package edu.mum.libaray.web.libarary.service;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ReturnBookRemindJob implements Job{
	
	

	

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("send mail to that user...");
		
	}

}
