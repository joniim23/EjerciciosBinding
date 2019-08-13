package ar.edu.unsam.ejercicio2

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*

@Accessors
@Observable
class Calculadora {

	double operando1
	double operando2
	double resultado

	@Dependencies("operando1", "operando2")
	def sumar() {
		resultado = operando1 + operando2
	}
}

class CalculadoraWindow extends MainWindow<Calculadora> {

	new() {
		super(new Calculadora)
	}

	override createContents(Panel mainPanel) {
		new Label(mainPanel) => [
			text = "Operando1:"
		]

		new TextBox(mainPanel) => [
			value <=> "operando1"
		]

		new Label(mainPanel) => [
			text = "Operando2:"
		]

		new TextBox(mainPanel) => [
			value <=> "operando2"
		]

		new Button(mainPanel) => [
			caption = "+"
			onClick [|this.modelObject.sumar]
		]

		new Label(mainPanel) => [
			value <=> "resultado"
		]
	}

	def static void main(String[] args) {
		new CalculadoraWindow().startApplication
	}

}
