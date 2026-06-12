package control;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Comparator;

import logica.Item;
import logica.Persona;
import logica.Prestamo;
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

    // crea un item
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


   
}