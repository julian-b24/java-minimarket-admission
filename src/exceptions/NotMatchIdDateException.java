package exceptions;

import java.time.LocalDate;

public class NotMatchIdDateException extends Exception{

	private LocalDate date;
	private String id;
	
	public NotMatchIdDateException(LocalDate dte, String id_) {
		super("Se ha intentado ingresado una persona que no puede "+
				"entrar el d�a de hoy.");
		
		date = dte;
		id = id_;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getId() {
		return id;
	}

}
