package mypack.aware;

import mypack.beans.A;
import mypack.beans.B;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author i.khan
 * Object of this class is loaded(as we have bean entry for this file in ApplicationContext) when the application 
 * is deployed, because we have entry in web.xml file for ContextLoaderListener. 
 * This listener loads ApplicationContext at the time of deployment and all the beans are loaded when 
 * applicationContext.xml is read.
 * Note: When object of ApplicationContext is created it creates all the objects for all beans present in the 
 * applicationContext.xml. 
 *
 */
public class SetUp implements ApplicationContextAware {

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		
		A a = (A)context.getBean("a");
        B b = (B)context.getBean("b"); 
        System.out.println(a.getName());
        System.out.println(b.getName() + " " + b.getLocation());

	}

}
