package main;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Iterator;

import proyectogrupal.ventana;

public class Main {

	static public LinkedList <Persona> listado = new LinkedList<Persona>();
	static public LinkedList<Vehiculo> listaVehiculos = new LinkedList<Vehiculo>();
	
	public static void main(String[] args) {
		
		/*...................................
		 * LANZAMIENTO DE VENTANA PRINCIPAL
		 * ..............................
		 */
		ventana inicio = new ventana();
		inicio.setVisible(true);
		
		/*............................
		 * INSTANCIA DE PERSONAS
		 * ...........................
		 */
		Persona marcos = new Persona(1,"Marcos","Correa","Canelones",(byte)0,LocalDate.of(1993,03,17));
		Persona pedro = new Persona(2,"Pedro","Maciel","Montevideo",(byte)2,LocalDate.of(1996,05,19));
		Persona natalia = new Persona(3,"Natalia","Larrosa","Canelones",(byte)4,LocalDate.of(1989,10,20));
		Persona alejandro = new Persona(4,"Alejadro","Rodriguez","San José",(byte)1,LocalDate.of(1910,11,30));
		ingresar(alejandro);
		ingresar(marcos);
		ingresar(natalia);
		ingresar(pedro);
		
		/*.......................
		 * INSTANCIAS DE CLASE VEHICULO
		 * .............................
		 */
		Vehiculo avion2 = new Avion(4, "Jet AirCraft", "Azul", 10, 2);
		Vehiculo avion1 = new Avion(3, "747", "Negro", 50, 200);
		Vehiculo barco1 = new Barco(1, "Barco Naval", "Gris", 32.5, 16.5);
		Vehiculo barco2 = new Barco(2, "Lancha a motor", "Negro con blanco", 34.1, 10.5);
		Vehiculo vehiculo = new Vehiculo(5,"Auto Bmw z4", "Plateado");
		listaVehiculos.add(avion2);
		listaVehiculos.add(avion1);
		listaVehiculos.add(barco1);
		listaVehiculos.add(barco2);
		listaVehiculos.add(vehiculo);
		
		/*......................................
		 * PROCEDIMIENTOS PARA MOSTRAR EL LISTADO VEHICULO
		 * ..................................................
		 */
		System.out.println("Lista de vehiculos en orden normal");
		for(Vehiculo v : listaVehiculos) {
			System.out.println(v);
		}

		System.out.println("_______________________________________________");
		System.out.println("Lista de vehiculos en orden invertido");
		ListIterator<Vehiculo> i = listaVehiculos.listIterator(listaVehiculos.size());
		while(i.hasPrevious()) {
			System.out.println(i.previous());
		}
		
	}

	public static void ingresar(Persona persona) {
		listado.add(persona);
	}
	
	
	
}
