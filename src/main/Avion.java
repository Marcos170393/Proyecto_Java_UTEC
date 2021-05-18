package main;

public class Avion extends Vehiculo{

	public double longitud;
	public int cantPasajeros;
	
	
	/**
	 * 
	 * @param idVehiculo - Recibe int (id del vehiculo)
	 * @param nombre - Recibe String (Nombre del vehiculo
	 * @param color - Recibe String (Color del vehiculo)
	 * @param longitud - Recibe double
	 * @param cantPasajeros - Recibe int
	 */
	public Avion(int idVehiculo, String nombre, String color, double longitud, int cantPasajeros) {
		super(idVehiculo, nombre, color);
		
		this.longitud = longitud;
		this.cantPasajeros = cantPasajeros;
	}


	@Override
	public String toString() {
		return "Avion [longitud=" + longitud + ", cantPasajeros=" + cantPasajeros + ", idVehiculo=" + idVehiculo
				+ ", nombre=" + nombre + ", color=" + color + "]";
	}

	
		
}
