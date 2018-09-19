package com.test.testspringjmsmq;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

public class RequestSendMessageCreator implements MessageCreator {

	
	//private Message message = null;
	private Message textMessage;

	
	public Message getTextMessage() {
	return textMessage;
	}

	public void setTextMessage(Message message2) {
	this.textMessage = message2;
	}


	public Message createMessage(Session session) throws JMSException {
	/*message = session.createTextMessage("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:sam='http://www.soapui.org/sample/'><soapenv:Header/><soapenv:Body><PcdEntry><sessionid>123455</sessionid><searchstring>nkumar235</searchstring></PcdEntry></soapenv:Body></soapenv:Envelope>");
	setTextMessage(message);*/
	/*MapMessage mapMessage = session.createMapMessage();
	
	
	mapMessage.setString("MessageId", "12345");
	mapMessage.setString("MmbId", "12345");
	
	mapMessage.setString("ACCOUNT_DETAILS", "12345");
	setTextMessage(mapMessage);
	return mapMessage;*/
		/*message = session.createTextMessage("<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:sam='http://www.soapui.org/sample/'><soapenv:Header/><soapenv:Body><PcdEntry><sessionid>123455</sessionid><searchstring>nkumar235</searchstring></PcdEntry></soapenv:Body></soapenv:Envelope>");
		setTextMessage(message);*/
		Message message = session.createTextMessage("Account:123456");
		message.setStringProperty("PROP1", "value1");
		message.setStringProperty("PROP2", "value2");
		
		setTextMessage(message);
		return message;
	
	
	
	}

}
