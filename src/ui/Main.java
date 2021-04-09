package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Minimarket;

public class Main {

	private Minimarket minimarket;
	private int numRejected;
	
	public Main() {
		minimarket = new Minimarket();
		numRejected = 0;
	}
	
	public static void main(String[] args) {
		
		Main app = new Main();
		System.out.println("Binvenido al minimarket Mi Barrio Te Quiere");
		
		int option;
		do {
			option = app.showMenu();
			app.executeOption(option);
			
		}while(option != 3);
	}
	
	
	public int showMenu() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int option = 0;
		
		System.out.println();
		try {
			System.out.println( "¿Qué desea hacer? \n" +
								"[1] Registrar Ingreso nueva persona \n" +
								"[2] Número de personas que han intentado ingresar al minimarket \n" + 
								"[3] Salir del programa \n");
			option = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException  e) {
			option = 0;
		}
		
		return option;
	}
	
	public void executeOption(int option) {
		
		switch (option) {
		case 1:
			break;

		case 2:
			break;
		
		case 3:
			System.out.println("Has salido de la aplicación, Adiós!");
			break;
		
		default:
			System.out.println("Ha ingresado una opción inválida!");
			break;
		}
	}

}
