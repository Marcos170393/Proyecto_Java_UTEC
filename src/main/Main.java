package main;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;

import proyectogrupal.Ventana;

public class Main {

	static public LinkedList <Persona> listado = new LinkedList<Persona>();
	static public LinkedList <Vehiculo> listaVehiculos = new LinkedList<Vehiculo>();
	static public int idIncremental;// Identificador que se incrementa en cada alta de vehiculo.
	
	public static void main(String[] args) {
		
		/*...................................
		 * LANZAMIENTO DE VENTANA PRINCIPAL
		 * ..............................
		 */
		Ventana inicio = new Ventana();
		inicio.setVisible(true);
		
		/*............................
		 * INSTANCIA DE PERSONAS
		 * ...........................
		 */
		Persona marcos = new Persona(1,"Marcos","Correa","Canelones",(byte)0,LocalDate.of(1993,03,17));
		Persona pedro = new Persona(2,"Pedro","Maciel","Montevideo",(byte)2,LocalDate.of(1996,05,19));
		Persona natalia = new Persona(3,"Natalia","Larrosa","Canelones",(byte)4,LocalDate.of(1989,10,20));
		Persona alejandro = new Persona(4,"Alejadro","Rodriguez","San José",(byte)1,LocalDate.of(1910,11,30));
		Persona enzo = new Persona(6,"Enzo","Gonzalez","San José",(byte)1,LocalDate.of(1910,11,30));
		Persona barbara = new Persona(7,"Barbara","Sanchez","San José",(byte)1,LocalDate.of(1910,11,30));
		Persona fabian = new Persona(8,"Fabian","Larrosa","San José",(byte)1,LocalDate.of(1910,11,30));
		ingresar(alejandro);
		ingresar(marcos);
		ingresar(natalia);
		ingresar(pedro);
		ingresar(enzo);
		ingresar(barbara);
		ingresar(fabian);
		
		
	}

	public static void ingresar(Persona persona) {
		listado.add(persona);
	}
	
	
	
}
