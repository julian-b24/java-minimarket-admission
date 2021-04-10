package model;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.NotMatchIdDateException;
import exceptions.TiTypeException;

public class Minimarket {

	private ArrayList<Person> persons;	//List of persons in the minimarket
	private int numAttemps;			//Amount of persons that try go into the minimarket
	private LocalDate date;
	
	public Minimarket(LocalDate dat) {
		persons = new ArrayList<Person>();
		numAttemps = 0;
		date = dat;
	}

	public boolean addmission(String id, String type) throws NotMatchIdDateException, TiTypeException {
		
		boolean added = false;
		numAttemps++;
		
		int day = date.getDayOfMonth();
		int secondLast;
		
		if (id.length() > 1) {
			secondLast = Integer.parseInt(id.substring(id.length()-2,id.length()-1));
		} else {
			secondLast = Integer.parseInt(id.substring(0));
		}
		
		if(type.equals("TI")) {
			throw new TiTypeException(id);
		}
		
		if((day % 2 != 0 && secondLast % 2 == 0) || (day % 2 == 0 && secondLast % 2 != 0)) {
			
			Person person = new Person(id, type);
			persons.add(person);
			added = true;
			
		} else {
			throw new NotMatchIdDateException(date, id);
		}

		return added;
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
