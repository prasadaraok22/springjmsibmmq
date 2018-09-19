package com.test.testspringjmsmq;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.jms.core.SessionCallback;
import org.springframework.jms.support.destination.DestinationResolver;
import org.springframework.stereotype.Component;

import com.ibm.mq.jms.MQQueue;
import com.ibm.msg.client.wmq.v6.jms.internal.JMSC;

/**
 * A service that sends and receives JMS messages. 
 * 
 */

public class MessageService 
{
	private JmsTemplate jmsTemplate;
	

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	/*@Value("${RES.IDS.QUEUE}")
	private String destination;

	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}*/
	/**
	 * Sends a message to a queue.
	 * 
	 * @param text Message text.
	 */
	/*public void sendMessage(final String text) {
		jmsTemplate.send(destination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(text);
			}
		});
		
		RequestSendMessageCreator messageCreator = new RequestSendMessageCreator();
		//Send the message
		jmsTemplate.send(destination,messageCreator);
		String msgId;
		try {
			msgId = messageCreator.getTextMessage().getJMSMessageID();
			System.out.println("Message id created " + msgId);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	*/
	//@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sendMessage() {
			
		RequestSendMessageCreator messageCreator = new RequestSendMessageCreator();
		System.out.println("getJmsTemplate..."+getJmsTemplate());
		//Send the message
		//Destination destination1 = jmsTemplate.getDestinationResolver().resolveDestinationName(session, queueName, isPubSubDomain);
		//((MQQueue)destination).setTargetClient(JMSC.MQJMS_CLIENT_NONJMS_MQ);
		Destination destination1 = (Destination)jmsTemplate.execute(new SessionCallback() {
            public Object doInJms(Session session) throws JMSException {
                DestinationResolver resolv = jmsTemplate.getDestinationResolver();
                return resolv.resolveDestinationName(session, jmsTemplate.getDefaultDestinationName(), false);
            }
        });
		
		try {
			((MQQueue)destination1).setTargetClient(JMSC.MQJMS_CLIENT_NONJMS_MQ);
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.jmsTemplate.send(destination1,messageCreator);
		String msgId;
		try {
			msgId = messageCreator.getTextMessage().getJMSMessageID();
			System.out.println("Message id created... " + msgId);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		Map map = new HashMap();
	    map.put("Name", "Mark");
	    map.put("Age", new Integer(47));
	    jmsTemplate.convertAndSend(destination, map, new MessagePostProcessor() {
	        public Message postProcessMessage(Message message) throws JMSException {
	            message.setIntProperty("AccountID", 1234);
	            message.setJMSCorrelationID("123-00001");
	            return message;
	        }
	    });*/
		
	}
	/**
	 * Receives a message from a queue.
	 * 
	 * @return Message text.
	 * @throws JMSException
	 */
	/*public String readMessage() throws JMSException {
		String message = null;
		
		Message msg = jmsTemplate.receive(destination);
		if(msg instanceof TextMessage) {
			message = ((TextMessage) msg).getText();
		}
		
		return message;
	}*/
}