package ar.edu.unsam.ejercicio2;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.annotations.Dependencies;
import org.uqbar.commons.model.annotations.Observable;

@Accessors
@Observable
@SuppressWarnings("all")
public class Calculadora {
  private double operando1;
  
  private double operando2;
  
  private double resultado;
  
  @Dependencies({ "operando1", "operando2" })
  public double sumar() {
    return this.resultado = (this.operando1 + this.operando2);
  }
  
  @Pure
  public double getOperando1() {
    return this.operando1;
  }
  
  public void setOperando1(final double operando1) {
    this.operando1 = operando1;
  }
  
  @Pure
  public double getOperando2() {
    return this.operando2;
  }
  
  public void setOperando2(final double operando2) {
    this.operando2 = operando2;
  }
  
  @Pure
  public double getResultado() {
    return this.resultado;
  }
  
  public void setResultado(final double resultado) {
    this.resultado = resultado;
  }
}
