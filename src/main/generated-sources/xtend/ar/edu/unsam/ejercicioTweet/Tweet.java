package ar.edu.unsam.ejercicioTweet;

import java.awt.Color;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Tweet {
  private String texto = "";
  
  public static int MAX = 6;
  
  @Dependencies("texto")
  public int getLetrasRestantes() {
    int _length = this.texto.length();
    return (Tweet.MAX - _length);
  }
  
  @Dependencies("texto")
  public boolean getEstadoCritico() {
    int _letrasRestantes = this.getLetrasRestantes();
    return (_letrasRestantes <= 5);
  }
  
  @Dependencies("texto")
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
  
  @Pure
  public String getTexto() {
    return this.texto;
  }
  
  public void setTexto(final String texto) {
    this.texto = texto;
  }
}
