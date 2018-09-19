package com.test.testspringjmsmq;

import static org.junit.Assert.*;

import javax.jms.JMSException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.Document;

/**
 * Unit tests for <code>MessageService</code>.
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="/spring.xml")
public class MessageServiceTest
{
	@Autowired
	private MessageService messageService;
	private String message;
	
	/**
	 * Test setup.
	 */
	@Before
	public void setUp() {
		//message = "TestSpringJMSMQ test message final3.";
		/*message = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:sam='http://www.soapui.org/sample/'>"+
   "<soapenv:Header/>"+
   "<soapenv:Body>"+
      "<PcdEntry>"+
         "<sessionid>123455</sessionid>"+
         "<searchstring>nkumar235</searchstring>"+
      "</PcdEntry>"+
   "</soapenv:Body>"+
"</soapenv:Envelope>";*/
		
	}
	

	
	/**
	 * Test that sends a message to a queue.
	 */
	@Test
	public void testSendMessage() {
		//messageService.sendMessage(message);
		messageService.sendMessage();
	}
	
	/**
	 * Test that receives a message from a queue.
	 * 
	 * @throws JMSException
	 */
	/*@Test
	public void testReadMessage() throws JMSException {
		String readMessage = messageService.readMessage();
		
		assertEquals(readMessage, message);
	}*/
}