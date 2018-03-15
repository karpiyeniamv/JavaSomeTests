package spring.impls.toshiba;

import org.springframework.stereotype.Component;

import spring.interfaces.Head;

@Component
public class ToshibaHead implements Head {

	public void calc() {
		System.out.println("Thinking about Toshiba...");
	}

}
