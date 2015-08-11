package com.ss.training.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main (String[] args){
		//xml file
		XmlBeanFactory factory =  new XmlBeanFactory(new FileSystemResource("message-context.xml"));
	
		
		DefaultMessage message = (DefaultMessage)factory.getBean("defaultMessage");
	
		ConstructorMessage message2 = (ConstructorMessage)factory.getBean("constructorMessage");
		SetterMessage message3 = (SetterMessage)factory.getBean("setterMessage");
		ConstructMessageRenderer message4 = (ConstructMessageRenderer)factory.getBean("below");
		//ListMessage message5 =(ListMessage)factory.getBean("list"); 
		
		
	
		 System.out.println("DefaultMessage = "+message.getMessage());
	
		 System.out.println("ConstructorMessage = "+message2.getMessage());
		 System.out.println("SetterMessage = "+message3.getMessage());
	
		 System.out.println("Referrence = "+message4.getMessage().getMessage());
		
		 SetMessage  message6= (SetMessage)factory.getBean("set");
		 ListMessage  message7= (ListMessage)factory.getBean("list");
		
		 
		 
		 for(int i=0;i<message7.getList().size();i++){
			 System.out.print("list :"+message7.getList().get(i)+"  ");
		 }
		// System.out.println("List :"+message7.getList());
		 
		 
		 System.out.println("");
		 
		 
		 MapMessage  message8= (MapMessage)factory.getBean("map");
		 
		 
		 for(Object o:message8.getMaps().keySet()){
			 System.out.println("Maps : Value = "+message8.getMaps().get(o)+ " key ="+o+" ");
		 }
		 
		 
		
		 
		 
		 System.out.println("\nMaps :"+message8.getMaps());
		 PropertyMessage  message9= (PropertyMessage)factory.getBean("property");
		//set
		 for(Object o:message6.getS()){
			 System.out.print("Set :"+o+" ");
		 }
		 //prop
		 for(Object o:message9.getProps().keySet()){
		 System.out.print("\nProperties :"+message9.getProps().get(o) +": key = "+o);	
		 }
		// System.out.println("Set :"+message6.getS());
		 System.out.println("");
		 for(Iterator i=message9.getProps().keySet().iterator();i.hasNext();){
			String key=(String) i.next();
			 System.out.println(i.next()+" "+ message9.getProps().get(key)) ;
			 
		 }
		}
}
