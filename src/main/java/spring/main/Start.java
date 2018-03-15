package spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.impls.robot.ModelT1000;

public class Start {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("all_context.xml");
		ModelT1000 model1 = (ModelT1000) context.getBean("model1");
		ModelT1000 model2 = (ModelT1000) context.getBean("model2");
		// ModelT1000 model3 = (ModelT1000) context.getBean("model1");
		model1.action();
		model2.action();
		try {
			model1.getAnnotations();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println(model3);
	}
}
