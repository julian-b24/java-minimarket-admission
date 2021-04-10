package exceptions;

import model.IdType;

public class TiTypeException extends Exception{

	private String id;
	
	public TiTypeException(String id_) {
		super("Se intentó ingresar una persona con Tarjeta de Identidad.");
		id = id_;
	}

	public String getId() {
		return id;
	}

}
