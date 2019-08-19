package ar.edu.unsam.ejercicio5;

import ar.edu.unsam.ejercicio5.Producto;
import ar.edu.unsam.ejercicio5.RepoProducto;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class ProductoVMO {
  private RepoProducto repoProductos;
  
  private Producto productoObj;
  
  public ProductoVMO() {
    this.repoProductos = RepoProducto.getInstance();
    this.productoObj = this.repoProductos.getProductos().get(0);
  }
  
  public List<Producto> getProductosDelRepo() {
    return this.repoProductos.getProductos();
  }
  
  @Dependencies("productoObj")
  public Integer getPrecioDelProducto() {
    return this.productoObj.getPrecio();
  }
  
  @Pure
  public RepoProducto getRepoProductos() {
    return this.repoProductos;
  }
  
  public void setRepoProductos(final RepoProducto repoProductos) {
    this.repoProductos = repoProductos;
  }
  
  @Pure
  public Producto getProductoObj() {
    return this.productoObj;
  }
  
  public void setProductoObj(final Producto productoObj) {
    this.productoObj = productoObj;
  }
}
