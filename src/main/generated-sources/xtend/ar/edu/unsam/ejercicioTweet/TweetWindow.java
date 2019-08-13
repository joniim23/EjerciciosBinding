package ar.edu.unsam.ejercicioTweet;

import ar.edu.unsam.ejercicioTweet.Tweet;
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
import org.uqbar.lacar.ui.model.bindings.ViewObservable;

@SuppressWarnings("all")
public class TweetWindow extends MainWindow<Tweet> {
  public TweetWindow() {
    super(new Tweet());
  }
  
  @Override
  public void createContents(final Panel mainPanel) {
    Label _label = new Label(mainPanel);
    final Procedure1<Label> _function = (Label it) -> {
      it.setText("Tweet");
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label, _function);
    TextBox _textBox = new TextBox(mainPanel);
    final Procedure1<TextBox> _function_1 = (TextBox it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "texto");
      it.setWidth(200);
    };
    ObjectExtensions.<TextBox>operator_doubleArrow(_textBox, _function_1);
    Label _label_1 = new Label(mainPanel);
    final Procedure1<Label> _function_2 = (Label it) -> {
      ObservableValue<Control, ControlBuilder> _value = it.<ControlBuilder>value();
      ArenaXtendExtensions.operator_spaceship(_value, "letrasRestantes");
      ViewObservable<Control, ControlBuilder> _foreground = it.<ControlBuilder>foreground();
      ArenaXtendExtensions.operator_spaceship(_foreground, "elegirColor");
    };
    ObjectExtensions.<Label>operator_doubleArrow(_label_1, _function_2);
  }
  
  public static void main(final String[] args) {
    new TweetWindow().startApplication();
  }
}
