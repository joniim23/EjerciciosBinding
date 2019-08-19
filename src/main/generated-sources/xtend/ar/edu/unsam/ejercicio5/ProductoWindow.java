package ar.edu.unsam.ejercicio5;

import ar.edu.unsam.ejercicio5.Producto;
import ar.edu.unsam.ejercicio5.ProductoVMO;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableItems;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.bindings.PropertyAdapter;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.ControlBuilder;
import org.uqbar.lacar.ui.model.ListBuilder;
import org.uqbar.lacar.ui.model.bindings.Binding;

@SuppressWarnings("all")
public class ProductoWindow extends MainWindow<ProductoVMO> {
  public ProductoWindow(final ProductoVMO model) {
    super(model);
  }
  
  public static void main(final String[] arg) {
    ProductoVMO _productoVMO = new ProductoVMO();
    new ProductoWindow(_productoVMO).startApplication();
  }
  
  @Override
  public void createContents(final Panel mainPanel) {
    this.setTitle("Lista de Productos");
    Label _label = new Label(mainPanel);
    _label.setText("Producto");
    Selector<ProductoVMO> _selector = new Selector<ProductoVMO>(mainPanel);
    final Procedure1<Selector<ProductoVMO>> _function = (Selector<ProductoVMO> it) -> {
      it.allowNull(false);
      ObservableItems<Selector<ProductoVMO>, ProductoVMO, ListBuilder<ProductoVMO>> _items = it.items();
      Binding _spaceship = ArenaXtendExtensions.operator_spaceship(_items, "productosDelRepo");
      PropertyAdapter _propertyAdapter = new PropertyAdapter(Producto.class, "nombre");
      _spaceship.setAdapter(_propertyAdapter);
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "productoObj");
    };
    ObjectExtensions.<Selector<ProductoVMO>>operator_doubleArrow(_selector, _function);
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("Precio");
    ObservableValue<Control, ControlBuilder> _value = new Label(mainPanel).<ControlBuilder>value();
    ArenaXtendExtensions.operator_spaceship(_value, "precioDelProducto");
  }
}
