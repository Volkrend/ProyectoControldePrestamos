package logica;

import java.util.ArrayList;

public class Tipo {
	private String nombre;
	private ArrayList<Item> items;
	
	public Tipo(String nombre) {
		this.nombre = nombre;
		this.items = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Item> getItems() {
		return items;
	}
	
	public void agregarItems(Item i) {
		items.add(i);
	}
	
	public void elimarItem(Item i) {
		items.remove(i);
	}
}
