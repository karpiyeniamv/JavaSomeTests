package spring.impls.robot;

import java.lang.reflect.Field;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.MySuperAnimalAnnotation;
import lombok.Setter;
import spring.abstracts.robot.BaseModel;
import spring.enums.ColorStyle;
import spring.interfaces.Hand;
import spring.interfaces.Head;
import spring.interfaces.Leg;

@Component
public class ModelT1000 extends BaseModel implements InitializingBean, DisposableBean {


	@MySuperAnimalAnnotation (str = "Koza")
	private ColorStyle color;
	@Getter
	@Setter
	@MySuperAnimalAnnotation (str = "Korova")
	private int year;
	@Getter
	@Setter
	private boolean soundEnabled;

	public ModelT1000() {
	}

	// public ModelT1000(Hand hand, Leg leg, Head head) {
	// super(hand, leg, head);
	// }

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public ModelT1000 model1() {
		return new ModelT1000();
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	
	public ModelT1000 model2() {
		return new ModelT1000(ColorStyle.BLACK, 2005, true);
	}

	public ModelT1000(Hand hand, Leg leg, Head head, ColorStyle color, int year, boolean soundEnabled) {
		// super(hand, leg, head);
		this.color = color;
		this.year = year;
		this.soundEnabled = soundEnabled;
	}

	public ModelT1000(ColorStyle color, int year, boolean soundEnabled) {
		this.color = color;
		this.year = year;
		this.soundEnabled = soundEnabled;
	}

	public void action() {
		getHead().calc();
		getHand().catchSomething();
		getLeg().go();
		System.out.println("color: " + color);
		System.out.println("year: " + year);
		System.out.println("can play sound: " + soundEnabled);
		System.out.println();
	}

	
	public void dance() {
		System.out.println("T1000 is dancing!");
	}

	public ColorStyle getColor() {
		return color;
	}

	public void setColor(ColorStyle color) {
		this.color = color;
	}

	
	
	
	public void destroy() throws Exception {
		System.out.println(this + " - method destroy()");

	}

	
	public void afterPropertiesSet() throws Exception {
		System.out.println(this + " - method init()");

	}

	public void getAnnotations () throws NoSuchFieldException, SecurityException
	{
		System.out.println (this.getClass().getFields()[0]);
		
		Field field =  this.getClass().getField("color");
		MySuperAnimalAnnotation annotation = field.getAnnotation(MySuperAnimalAnnotation.class);
		System.out.println ("Color annotation = " + annotation.str());
		Field field1 =  this.getClass().getField("year");
		MySuperAnimalAnnotation annotation1 = field1.getAnnotation(MySuperAnimalAnnotation.class);
		System.out.println ("Year annotation = " + annotation1.str());
	}
}
