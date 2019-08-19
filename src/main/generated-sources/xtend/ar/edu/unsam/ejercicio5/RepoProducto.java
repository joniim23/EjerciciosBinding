package ar.edu.unsam.ejercicio5;

import ar.edu.unsam.ejercicio5.Producto;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@SuppressWarnings("all")
public class RepoProducto {
  private static RepoProducto instance;
  
  public static RepoProducto getInstance() {
    RepoProducto _xblockexpression = null;
    {
      if ((RepoProducto.instance == null)) {
        RepoProducto _repoProducto = new RepoProducto();
        RepoProducto.instance = _repoProducto;
      }
      _xblockexpression = RepoProducto.instance;
    }
    return _xblockexpression;
  }
  
  public List<Producto> getProductos() {
    List<Producto> _xblockexpression = null;
    {
      final Producto milanesa = new Producto("Milanesa", Integer.valueOf(45));
      final Producto bife = new Producto("Bife", Integer.valueOf(60));
      _xblockexpression = Collections.<Producto>unmodifiableList(CollectionLiterals.<Producto>newArrayList(milanesa, bife));
    }
    return _xblockexpression;
  }
}
