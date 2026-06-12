package logica;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Prestamo {
	private LocalDateTime fechaInicio;
	private Persona persona;
	private ArrayList<Item> items;
	private Alerta alerta; //
	
	public Prestamo(Persona persona) {
		this.persona = persona;
        this.fechaInicio = LocalDateTime.now(); //fecha automaticamente
        this.items = new ArrayList<>();
        this.alerta = null;              
    }

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Alerta getAlerta() {
		return alerta;
	}

	public void setAlerta(Alerta alerta) {
		this.alerta = alerta;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void agregarItem(Item i) {
		items.add(i);
		i.setPrestamo(this); //bidireccionales
	}
	
	public void eliminarItem(Item i) {
		items.remove(i);
		i.setPrestamo(null); //
	}
}
