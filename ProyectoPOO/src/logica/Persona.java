package logica;

import java.util.ArrayList;

public class Persona {
	private String nombre;
	private String telefono;
	private String correo;
	private ArrayList<Prestamo> prestamos;
	
	public Persona(String nombre, String telefono, String correo) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.prestamos = new ArrayList<>(); 			
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}
	
	public void agregarPrestamos(Prestamo p) {
		prestamos.add(p);
	}
	
	public void eliminarPrestamo(Prestamo p) {
		prestamos.remove(p);
	}
	
	public boolean tienePrestamo() {
		return !prestamos.isEmpty();
	}
}
