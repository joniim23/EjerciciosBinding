package ar.edu.unsam.ejercicioTweet

import java.awt.Color
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
class Tweet {
	public static int MAX = 140
	String texto = ""

	@Dependencies("texto")
	def getLetrasRestantes() {

		MAX - texto.length()
	}

	
	def validarLongitud(String tweet) {
		 tweet.length <= MAX 
			
		 
	}
	
}

class TweetWindow extends MainWindow<Tweet> {

	new() {
		super(new Tweet)
	}
	public static int COLOR_CRITICO = 5

	@Dependencies("texto")
	def getEstadoCritico() {
		modelObject.getLetrasRestantes <= COLOR_CRITICO

	}
	@Dependencies("texto")
	def getElegirColor() {
		if (getEstadoCritico) {
			Color.RED
		} else {
			Color.GREEN

		}
		
		
		}
	override createContents(Panel mainPanel) {
		new Label(mainPanel) => [
			text = "Tweet"
		]

		new TextBox(mainPanel) => [
			value <=> "texto"
			height = 100
			width = 200
			withFilter [evento | modelObject.validarLongitud(evento.potentialTextResult)]
		]
		new Label(mainPanel) => [
			value <=> "letrasRestantes"
			foreground <=> "elegirColor"
		]
	}

	def static void main(String[] args) {
		new TweetWindow().startApplication
	}
}
