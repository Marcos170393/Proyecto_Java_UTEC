package main;

import java.util.LinkedList;


public class Barco extends Vehiculo{

	public double eslora;
	public double manga;
	Persona dueno;
	
	/**
	 * 
	 * @param idVehiculo - Recibe int (id del vehiculo)
	 * @param nombre - Recibe String (Nombre del vehiculo
	 * @param color - Recibe String (Color del vehiculo)
	 * @param eslora - Recibe double
	 * @param manga - Recibe double
	 */
	public Barco(int idVehiculo,String nombre, String color,double eslora, double manga) {
		super(idVehiculo,nombre, color);
		this.eslora = eslora;
		this.manga = manga;
	}


	@Override
	public String toString() {
		return "Barco [eslora=" + eslora + ", manga=" + manga + ", idVehiculo=" + idVehiculo + ", nombre=" + nombre
				+ ", color=" + color + "]";
	}
	
	
	
}
