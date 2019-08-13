package ar.edu.unsam.ejercicio1;

import ar.edu.unsam.ejercicio1.Saludo;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class SaludoWindow extends MainWindow<Saludo> {
  public SaludoWindow() {
    super(new Saludo());
  }
  
  @Override
  public void createContents(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = (Label it) -> {
      it.setText("Nombre:");
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_1 = (TextBox it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "nombre");
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
    Label _label_1 = new Label(mainPanel);
    final Procedure1<Label> _function_2 = (Label it) -> {
      it.setText("Apellido:");
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_2);
    TextBox _textBox_1 = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_3 = (TextBox it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "apellido");
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_3);
    Label _label_2 = new Label(mainPanel);
    final Procedure1<Label> _function_4 = (Label it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "nombreCompleto");
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_2, _function_4);
  }
  
  public static void main(final String[] args) {
    new SaludoWindow().startApplication();
  }
}
