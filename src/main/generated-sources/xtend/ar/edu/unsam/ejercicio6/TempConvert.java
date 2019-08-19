package ar.edu.unsam.ejercicio6;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class TempConvert {
  private double celsius;
  
  private double fahrenheit;
  
  @Dependencies("celsius")
  public void setCelsius(final double _celsius) {
    this.celsius = _celsius;
    this.fahrenheit = (((this.celsius * 9) / 5) + 32);
  }
  
  @Dependencies("fahrenheit")
  public void setFahrenheit(final double _fahrenheit) {
    this.fahrenheit = _fahrenheit;
    this.celsius = (((this.fahrenheit - 32) * 9) / 5);
  }
  
  @Pure
  public double getCelsius() {
    return this.celsius;
  }
  
  @Pure
  public double getFahrenheit() {
    return this.fahrenheit;
  }
}
