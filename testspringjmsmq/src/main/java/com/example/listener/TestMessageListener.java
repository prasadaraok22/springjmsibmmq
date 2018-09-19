package com.example.listener;

import java.io.StringReader;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

@Service
public class TestMessageListener implements MessageListener {

	public void onMessage(Message message) {
		Enumeration enume=null;
		try {
			enume=message.getPropertyNames();
		} catch (JMSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    Object content=null;
	    Hashtable dico=new Hashtable();
	    String name="jms-message";
		if (message instanceof TextMessage) {
			try {
				// System.out.println(((TextMessage) message).getText());
				System.out.println("message.getJMSMessageID()..."+message.getJMSMessageID());
				String xml = ((TextMessage) message).getText();
				System.out.println("xml...." + xml);
				/*Document receivedDoc = null;
				try {
					receivedDoc = getXmlAsDOMDocument(xml);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				NodeList nList = receivedDoc.getElementsByTagName("PcdEntry");
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						Element element = (Element) node;
						String sessionid = element.getElementsByTagName("sessionid").item(0).getTextContent();
						System.out.println("sessionid..." + sessionid);
					}
				}*/
			} catch (JMSException ex) {
				throw new RuntimeException(ex);
			}
		} 
		else if (message instanceof MapMessage) {
			MapMessage mapmessage = (MapMessage) message;
			try {
				enume = mapmessage.getMapNames();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (mapmessage.getString("MessageId") != null) {
					name = mapmessage.getString("MessageId");
					System.out.println("map message name...."+name);
				}
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			while (enume.hasMoreElements()) {
				String propname = (String) enume.nextElement();
				Object ob;
				try {
					ob = ((MapMessage) message).getObject(propname);
					dico.put(propname, ob);
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		  
		else {
			throw new IllegalArgumentException("Message must be of type TextMessage");
		}
 
			}

	public static Document getXmlAsDOMDocument(String xmlString) throws Exception {

		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		return documentBuilder.parse(new InputSource(new StringReader(xmlString)));

	}

}
