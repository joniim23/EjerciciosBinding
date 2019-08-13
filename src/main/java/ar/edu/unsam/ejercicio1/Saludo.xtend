package ar.edu.unsam.ejercicio1

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.model.annotations.Dependencies
import org.uqbar.commons.model.annotations.Observable

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*

@Accessors
@Observable
class Saludo {
	String nombre
	String apellido
	
	@Dependencies("nombre", "apellido")
	def getNombreCompleto() {
		"Hola "+ nombre + " " + apellido
	}
}

class SaludoWindow extends MainWindow<Saludo> {
	
	new() {
		super(new Saludo)
	}
	
	override createContents(Panel mainPanel) {
		new Label(mainPanel) => [text = "Nombre:" ]
		
		new TextBox(mainPanel) => [value <=> "nombre"]
		
		new Label(mainPanel) => [text = "Apellido:" ]
		
		new TextBox(mainPanel) => [value <=> "apellido"]
		
		new Label(mainPanel) => [value <=> "nombreCompleto" ]
	}
	
	def static void main(String[] args) {
		new SaludoWindow().startApplication		
	}
	
}