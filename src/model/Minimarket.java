package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Minimarket {

	private ArrayList<Person> persons;	//List of persons in the minimarket
	private int numAttemps;			//Amount of persons that try go into the minimarket
	private LocalDate date;
	
	public Minimarket(LocalDate dat) {
		persons = new ArrayList<Person>();
		numAttemps = 0;
		date = dat;
	}

	public LocalDate getDate() {
		return date;
	}

	public int getNumAttemps() {
		return numAttemps;
	}

	public ArrayList<Person> getPersons() {
		return persons;
	}
	
	public void setNumAttemps(int attemp) {
		numAttemps = attemp;
	}


}
