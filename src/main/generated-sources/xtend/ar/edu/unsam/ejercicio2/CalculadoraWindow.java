package ar.edu.unsam.ejercicio2;

import ar.edu.unsam.ejercicio2.Calculadora;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.Action;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class CalculadoraWindow extends MainWindow<Calculadora> {
  public CalculadoraWindow() {
    super(new Calculadora());
  }
  
  @Override
  public void createContents(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = (Label it) -> {
      it.setText("Operando1:");
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_1 = (TextBox it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "operando1");
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
    Label _label_1 = new Label(mainPanel);
    final Procedure1<Label> _function_2 = (Label it) -> {
      it.setText("Operando2:");
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_2);
    TextBox _textBox_1 = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_3 = (TextBox it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "operando2");
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox_1, _function_3);
    Button _button = new Button(mainPanel);
    final Procedure1<Button> _function_4 = (Button it) -> {
      it.setCaption("+");
      final Action _function_5 = () -> {
        this.getModelObject().sumar();
      };
      it.onClick(_function_5);
    };
    ObjectExtensions.<Button>operator_doubleArrow(_button, _function_4);
    Label _label_2 = new Label(mainPanel);
    final Procedure1<Label> _function_5 = (Label it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "resultado");
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_2, _function_5);
  }
  
  public static void main(final String[] args) {
    new CalculadoraWindow().startApplication();
  }
}
