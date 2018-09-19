package com.example.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.test.testspringjmsmq.MessageService;
 
public class DemoMain {
 
  public static void main(String[] args) {
	  boolean flag=true;
	  if(true){
	   GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();  
	    ctx.load("App-context.xml");  
	    ctx.refresh(); 
	    
	    MessageService sender=ctx.getBean("messageService",MessageService.class);  
	    sender.sendMessage(); 
	    
	    flag = false;
	  }
	  new DemoMain();
  }
	 public  DemoMain(){
    // create Spring context
    ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
         
    // sleep for 1 second
    
    /*while(true){
    	try {
    	      Thread.sleep(1000);
    	    } catch (InterruptedException e) {
    	      e.printStackTrace();
    	      ((ClassPathXmlApplicationContext)ctx).close();
    	    }
    	
    	   
    	
    }*/
    
    // close application context // 
	 
  }
}
