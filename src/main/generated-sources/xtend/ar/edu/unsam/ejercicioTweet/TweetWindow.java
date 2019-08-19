package ar.edu.unsam.ejercicioTweet;

import ar.edu.unsam.ejercicioTweet.Tweet;
import java.awt.Color;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.uqbar.arena.bindings.ObservableValue;
import org.uqbar.arena.filters.TextFilter;
import org.uqbar.arena.widgets.Control;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.TextInputEvent;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.arena.xtend.ArenaXtendExtensions;
import org.uqbar.lacar.ui.model.ControlBuilder;

@SuppressWarnings("all")
public class TweetWindow extends MainWindow<Tweet> {
  public static int COLOR_CRITICO = 5;
  
  public TweetWindow() {
    super(new Tweet());
  }
  
  @Override
  public void createContents(final Panel mainPanel) {
    this.setTitle("Twitter");
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = (Label it) -> {
      it.setText("Tweet");
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_1 = (TextBox it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "texto");
      it.setHeight(100);
      it.setWidth(200);
      final TextFilter _function_2 = (TextInputEvent evento) -> {
        return this.getModelObject().validarLongitud(evento.getPotentialTextResult());
      };
      it.withFilter(_function_2);
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
    Label _label_1 = new Label(mainPanel);
    final Procedure1<Label> _function_2 = (Label it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "letrasRestantes");
      it.setForeground(this.getElegirColor());
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_2);
  }
  
  public static void main(final String[] args) {
    new TweetWindow().startApplication();
  }
  
  public boolean getEstadoCritico() {
    int _letrasRestantes = this.getModelObject().getLetrasRestantes();
    return (_letrasRestantes <= TweetWindow.COLOR_CRITICO);
  }
  
  public Color getElegirColor() {
    Color _xifexpression = null;
    boolean _estadoCritico = this.getEstadoCritico();
    if (_estadoCritico) {
      _xifexpression = Color.RED;
    } else {
      _xifexpression = Color.GREEN;
    }
    return _xifexpression;
  }
}
