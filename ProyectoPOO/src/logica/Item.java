package logica;

import java.util.ArrayList;

public class Item {
	private Prestamo prestamo;
	private String nombre;
	private String descripcion;
	private ArrayList<Categoria> categorias;
	private Tipo tipo;
	
	public Item(String nombre, String descrpcion, Tipo tipo) {
		this.nombre = nombre;
		this.descripcion = descrpcion;
		this.categorias = new ArrayList<>();
		this.prestamo = null;
		this.tipo = tipo;
	}

	public Prestamo getPrestamo() {
		return prestamo;
	}

	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
    
	public boolean estaDisponible() {
        return prestamo == null;
    }

    public void agregarCategoria(Categoria c) {
        categorias.add(c);
    }

    public void eliminarCategoria(Categoria c) {
        categorias.remove(c);
    }
}
