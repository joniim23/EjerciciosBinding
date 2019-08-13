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
	String texto = ""
	public static int MAX = 6

	@Dependencies("texto")
	def getLetrasRestantes() {

		MAX - texto.length()
	}

	@Dependencies("texto")
	def getEstadoCritico() {
		this.getLetrasRestantes <= 5

	}

	@Dependencies("texto")
	def getElegirColor() {
		if (getEstadoCritico) {
			Color.RED
		} else {
			Color.GREEN

		}
	}
}

class TweetWindow extends MainWindow<Tweet> {

	new() {
		super(new Tweet)
	}

	override createContents(Panel mainPanel) {
		new Label(mainPanel) => [
			text = "Tweet"
		]

		new TextBox(mainPanel) => [
			value <=> "texto"
			width = 200
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
