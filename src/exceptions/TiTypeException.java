package exceptions;

import model.IdType;

public class TiTypeException extends Exception{

	private IdType type;
	
	public TiTypeException() {
		super("Se intentó ingresar una persona con Tarjeta de Identidad.");
		type = IdType.TI;
	}

	public IdType getType() {
		return type;
	}

}
