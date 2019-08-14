package ar.edu.unsam.ejercicioTweet;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Tweet {
  public static int MAX = 140;
  
  private String texto = "";
  
  @Dependencies("texto")
  public int getLetrasRestantes() {
    int _length = this.texto.length();
    return (Tweet.MAX - _length);
  }
  
  public boolean validarLongitud(final String tweet) {
    int _length = tweet.length();
    return (_length <= Tweet.MAX);
  }
  
  @Pure
  public String getTexto() {
    return this.texto;
  }
  
  public void setTexto(final String texto) {
    this.texto = texto;
  }
}
