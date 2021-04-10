package model;

import java.time.LocalDate;

public class MinimarketTest {

	private Minimarket market;
	
	public void setupScenary1() {	
		market = new Minimarket(LocalDate.parse("2021-02-20"));
	}
	
	public void setupScenary2() {
		market = new Minimarket(LocalDate.parse("2021-02-15"));
	}
	
	public void setupScenary3() {
		market = new Minimarket(LocalDate.parse("2021-02-06"));
		market.getPersons().add(new Person("4783297", "CC"));
		market.setNumAttemps(4);
	}
	
	public void setupScenary4() {
		market = new Minimarket(LocalDate.parse("2021-02-07"));
		market.getPersons().add(new Person("234443", "CC"));
		market.getPersons().add(new Person("1919121", "PP"));
	}
	
	
}
