package main;


public class Vehiculo {
	
	public int idVehiculo;
	public String nombre;
	public String color;
	public Persona dueno = new Persona();
	
	/**
	 * 
	 * @param idVehiculo - Recibe int (id del vehiculo)
	 * @param nombre - Recibe String (Nombre del vehiculo
	 * @param color - Recibe String (Color del vehiculo)
	 */
	public Vehiculo(int idVehiculo,String nombre, String color) {
		this.idVehiculo = idVehiculo;
		this.nombre = nombre;
		this.color = color;
		
	}

	@Override
	public String toString() {
		return "Vehiculo [idVehiculo=" + idVehiculo + ", nombre=" + nombre + ", color=" + color + "]";
	}
	
	
	
	
}
