package ar.edu.unsam.ejercicio6;

import ar.edu.unsam.ejercicio6.TempConvert;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.ErrorsPanel;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class TempConvertWindow extends MainWindow<TempConvert> {
  public TempConvertWindow() {
    super(new TempConvert());
  }
  
  public static void main(final String[] args) {
    new TempConvertWindow().startApplication();
  }
  
  @Override
  public void createContents(final Panel mainPanel) {
    this.setTitle("Conversor de temperatura");
    VerticalLayout _verticalLayout = new VerticalLayout();
    mainPanel.setLayout(_verticalLayout);
    new ErrorsPanel(mainPanel, "Listo para convertir");
    Label _label = new Label(mainPanel);
    _label.setText("° Celsius");
    ObservableValue<Control, ControlBuilder> _value = new TextBox(mainPanel).<ControlBuilder>value();
    ArenaXtendExtensions.operator_spaceship(_value, "celsius");
    Label _label_1 = new Label(mainPanel);
    _label_1.setText("° Fahrenheit");
    ObservableValue<Control, ControlBuilder> _value_1 = new TextBox(mainPanel).<ControlBuilder>value();
    ArenaXtendExtensions.operator_spaceship(_value_1, "fahrenheit");
  }
}
