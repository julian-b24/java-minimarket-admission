package model;

public class Person {

	private String id;
	private IdType type;
	
	public Person(String _id, String typ) {
		id = _id;
		type = IdType.valueOf(typ);
	}

}
