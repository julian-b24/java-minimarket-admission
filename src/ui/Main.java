package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

import exceptions.NotMatchIdDateException;
import exceptions.TiTypeException;
import model.Minimarket;

public class Main {

	private Minimarket minimarket;
	
	public Main() {
		minimarket = new Minimarket(LocalDate.now());
	}
	
	public static void main(String[] args) throws IOException {
		
		Main app = new Main();
		
		System.out.println("Binvenido al minimarket Mi Barrio Te Quiere");
		int option;
		do {
			option = app.showMenu();
			app.executeOption(option);
			
		}while(option != 3);
	}

	public int showMenu() throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = 0;

		try {
			System.out.println( "¿Qué desea hacer? \n" +
								"[1] Registrar Ingreso nueva persona \n" +
								"[2] Número de personas que han intentado ingresar al minimarket \n" + 
								"[3] Salir del programa \n");
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException  e) {
			e.printStackTrace();
		}
		
		return option;
	}
	
	public void executeOption(int option) {
		
		switch (option) {
		case 1:
			registerPerson();
			break;

		case 2:
			getNumAttemps();
			break;
		
		case 3:
			System.out.println("Has salido de la aplicación, Adiós!");
			break;
		
		default:
			System.out.println("Ha ingresado una opción inválida!");
			break;
		}
	}

	public void registerPerson() {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Ingrese el número de identificación: ");
			String id = br.readLine();
			System.out.println("Ingrese el tipo de identifiación: ");
			System.out.println();
			String type = br.readLine();
			
			if (minimarket.addmission(id, type)) {
				System.out.println("La persona con " + type + " y id: " + id + ". Ha ingresado al minimarket \n");
			}
			
			br.close();
		} catch (IOException ioeExcp) {
			ioeExcp.printStackTrace();
		} catch (NotMatchIdDateException dateExcp) {
			System.out.println(dateExcp.toString() + "\n Proceso terminado");
		} catch (TiTypeException tiExcp) {
			System.out.println(tiExcp.toString() + "\n Proceso terminado");
		}
	}

	public void getNumAttemps() {
		System.out.println("\nEl número de personas que ha intentado ingresar es: " + minimarket.getNumAttemps() + "\n");
	}

}
