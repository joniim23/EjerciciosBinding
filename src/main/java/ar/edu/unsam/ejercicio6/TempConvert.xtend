package ar.edu.unsam.ejercicio6

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.arena.layout.VerticalLayout
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.ErrorsPanel
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*

@Accessors
@Observable
class TempConvert {
	double celsius
	double fahrenheit
	
	@Dependencies("celsius")
	def void setCelsius(double _celsius) {
		celsius = _celsius
		fahrenheit = (celsius * 9/5) + 32
	}
	
	@Dependencies("fahrenheit")
	def void setFahrenheit(double _fahrenheit) {
		fahrenheit = _fahrenheit
		celsius = (fahrenheit - 32) * 9/5
	}
}

class TempConvertWindow extends MainWindow<TempConvert> {
	
	new() {
		super(new TempConvert)
	}
	
	static def main(String[] args) {
		new TempConvertWindow().startApplication
	}
	
	override createContents(Panel mainPanel) {
		this.title = "Conversor de temperatura"
		mainPanel.layout = new VerticalLayout
		
		new ErrorsPanel(mainPanel, "Listo para convertir")
		
		new Label(mainPanel).text = "° Celsius"
		new TextBox(mainPanel).value <=> "celsius"
		
		new Label(mainPanel).text = "° Fahrenheit"
		new TextBox(mainPanel).value <=> "fahrenheit"
	}
	
}