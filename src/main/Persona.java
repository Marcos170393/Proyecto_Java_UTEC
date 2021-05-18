package main;

import java.time.LocalDate;
import java.util.HashMap;

public class Persona {
	public int idPersona;
	public String nombre;
	public String apellido;
	public String dptoResidencia;
	private byte cantHijos;
	private LocalDate fechaNacimiento;
	private HashMap<Integer,Vehiculo> listaVehiculos = new HashMap<Integer,Vehiculo>();
	
	public Persona(int idPersona, String nombre, String apellido, String dptoResidencia, byte cantHijos,
			LocalDate fechaNacimiento) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dptoResidencia = dptoResidencia;
		this.cantHijos = cantHijos;
		this.fechaNacimiento = fechaNacimiento;
	}

	/*...............
	 * Getters 
	 * ...............
	 */
	
	public HashMap<Integer,Vehiculo> getListaVehiculos(){
		return listaVehiculos;
	}
	
	public LocalDate getDate() {
		return fechaNacimiento;
	}
	public Byte getHijos() {
		return cantHijos;
	}
	public LocalDate getFecha() {
		return fechaNacimiento;
	}
	
	/*
	 * Setters
	 */
	public void setVehiculo(int clave, Vehiculo v) {
		listaVehiculos.put(clave, v);
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public void setCantHijos(byte cantHijos) {
		this.cantHijos = cantHijos;
	}

	
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
}
