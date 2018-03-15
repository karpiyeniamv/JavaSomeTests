package spring.impls.toshiba;

import org.springframework.stereotype.Component;

import spring.interfaces.Hand;

@Component
public class ToshibaHand implements Hand {

	public void catchSomething() {
		System.out.println("Catched from Toshiba!");
	}

}
