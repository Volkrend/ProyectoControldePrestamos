package control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;

import logica.Item;
import logica.Persona;
import logica.Prestamo;
import logica.Alerta;
import logica.Categoria;
import logica.Tipo;

public class ControladoraPrestamos {
	private static ControladoraPrestamos instance = null;
    
    private ControladoraPrestamos() {
        personas = new TreeMap<>();
        items = new ArrayList<>();
        categorias = new TreeMap<>();
        tipos = new TreeMap<>();
        prestamos = new ArrayList<>();
    }
    
  //SINGLETON

    public static ControladoraPrestamos getInstance() {
        if (instance == null)
            instance = new ControladoraPrestamos();
        return instance;
    }
    
    
    private ArrayList<Item> items;
    private ArrayList<Prestamo> prestamos;
    private TreeMap<String, Persona> personas;
    private TreeMap<String, Categoria> categorias;
    private TreeMap<String, Tipo> tipos;


    // ITEM

    //
    public void crearItem(String nombre, String descripcion, Tipo tipo, ArrayList<Categoria> categorias) {
        Item item = new Item(nombre, descripcion, tipo);
        for (Categoria c : categorias) {
            item.agregarCategoria(c);
        }
        items.add(item);
    }

    public void modificarItem(String nombre, String nuevoNombre, String descripcion, Tipo tipo, ArrayList<Categoria> categorias) throws Exception {
        Item item = consultarItem(nombre);
        item.setNombre(nuevoNombre);
        item.setDescripcion(descripcion);
        item.setTipo(tipo);
        item.getCategorias().clear();
        for (Categoria c : categorias) {
            item.agregarCategoria(c);
        }
    }

    // 
    public void borrarItem(String nombre) throws Exception {
        Item item = consultarItem(nombre);
        if (item.estaDisponible()) {
            items.remove(item);
        }
    }


    public Item consultarItem(String nombre) throws Exception {
        for (Item i : items) {
            if (i.getNombre().equals(nombre)) {
                return i;
            }
            
        }
        throw new Exception("Item no encontrado");
    }


    // PERSONA

 
    public void crearPersona(String nombre, String telefono, String correo) {
        Persona p = new Persona(nombre, telefono, correo);
        personas.put(correo, p);
    }

    //
    public void modificarPersona(String correo, String nombre, String telefono) {
        Persona p = personas.get(correo);
        p.setNombre(nombre);
        p.setTelefono(telefono);
    }


    public void borrarPersona(String correo) {
        Persona p = personas.get(correo);
        if (!p.tienePrestamos()) {
            personas.remove(correo);
        }
    }

    public Persona consultarPersona(String correo) {
        return personas.get(correo);
    }



    // CATEGORIA
 
    public void crearCategoria(String nombre) {
        Categoria c = new Categoria(nombre);
        categorias.put(nombre, c);
    }

 
    public void modificarCategoria(String nombre, String nuevoNombre) {
        Categoria c = categorias.get(nombre);
        categorias.remove(nombre);   
        c.setNombre(nuevoNombre);
        categorias.put(nuevoNombre, c); 
    }

    public void borrarCategoria(String nombre) {
        categorias.remove(nombre);
    }

    public Categoria consultarCategoria(String nombre) {
        return categorias.get(nombre);
    }

    //TIPO
	
  	public void crearTipo(String nombre) {
  		Tipo t = new Tipo(nombre);
  		tipos.put(nombre, t);
  	}
   
  	public void modificarTipo(String nombre, String nuevoNombre) {
        Persona p = personas.get(nombre);
        p.setNombre(nuevoNombre);
    }
  	
  	public void borrarTipo(String nombre) {
  	    tipos.remove(nombre);
  	}

  	public Tipo consultarTipo(String nombre) {
  		return tipos.get(nombre);
  	}
  	
  	// PRESTAMO
    
  	public void crearPrestamo(String correo, ArrayList<Item> items, String datosA) { //alertas
  	    Persona persona = personas.get(correo);
  	    Prestamo prestamo = new Prestamo(persona);
  	    for (Item i : items) {
  	        prestamo.agregarItem(i);
  	    }
  	    persona.agregarPrestamo(prestamo);
  	    prestamos.add(prestamo);
  	}
  	
  	public void agregarAlerta(Prestamo prestamo, String mensaje, boolean esRecurrente, int intervalo, LocalDateTime fechaActivacion) { //"Si lo desea, el usuario crea una alerta para el préstamo"
	Alerta alerta = new Alerta(mensaje, esRecurrente, intervalo, fechaActivacion);
	prestamo.setAlerta(alerta);
	
	}

  	public void agregarItemP(String nombre, Prestamo prestamo) throws Exception {
  	    Item item = consultarItem(nombre);
  	    prestamo.agregarItem(item);
  	}

  	public void eliminarItemP(String nombre, Prestamo prestamo) throws Exception {
  	    Item item = consultarItem(nombre);
  	    prestamo.eliminarItem(item);
  	}


  	public void finalizarPrestamo(Prestamo prestamo) {
  	    ArrayList<Item> copia = new ArrayList<>(prestamo.getItems()); //copia para evitar erroe
  	    for (Item i : copia) {
  	        prestamo.eliminarItem(i);
  	    }
  	    prestamo.getPersona().eliminarPrestamo(prestamo);
  	    prestamos.remove(prestamo);
  	}

    
  	public ArrayList<Prestamo> obtenerDatosAlerta() { //cambios
  	    ArrayList<Prestamo> resultado = new ArrayList<>();
  	    for (Prestamo p : prestamos) {
  	        if (p.getAlerta() != null && p.getAlerta().debeActivarse()) {
  	            resultado.add(p);
  	            p.getAlerta().actualizarFecha();
  	        }
  	    }
  	    return resultado;
  	}

}