package ar.edu.unsam.ejercicio5;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Producto {
  private String nombre;
  
  private Integer precio;
  
  public Producto(final String nombre, final Integer precio) {
    this.nombre = nombre;
    this.precio = precio;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public Integer getPrecio() {
    return this.precio;
  }
  
  public void setPrecio(final Integer precio) {
    this.precio = precio;
  }
}
