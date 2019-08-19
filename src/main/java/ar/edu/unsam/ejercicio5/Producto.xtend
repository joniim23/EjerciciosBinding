package ar.edu.unsam.ejercicio5

import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.windows.MainWindow
import org.uqbar.commons.model.annotations.Observable

import static extension org.uqbar.arena.xtend.ArenaXtendExtensions.*
import org.uqbar.commons.model.annotations.Dependencies

@Accessors
@Observable
class Producto {
	String nombre
	Integer precio
	
	new(String nombre, Integer precio) {
		this.nombre = nombre
		this.precio = precio
	}
}

class RepoProducto {
	static RepoProducto instance

	static def getInstance() {
		if (instance === null) {
			instance = new RepoProducto()
		}
		instance
	}
	
	def getProductos(){
		val milanesa = new Producto("Milanesa", 45)
		val bife = new Producto("Bife", 60)
		#[milanesa,bife]
	}
}

@Accessors
@Observable
class ProductoVMO {
	RepoProducto repoProductos
	Producto productoObj
	
	new () {
		repoProductos = RepoProducto.instance
		productoObj = repoProductos.productos.get(0)
	}
	
	def getProductosDelRepo() {
		repoProductos.productos
	}
	
	@Dependencies("productoObj")
	def getPrecioDelProducto() {
		productoObj.precio
	}
}

class ProductoWindow extends MainWindow<ProductoVMO> {
	
	new(ProductoVMO model) {
		super(model)
	}
	
	static def void main(String[] arg) {
		new ProductoWindow(new ProductoVMO).startApplication
	} 
		
	override createContents(Panel mainPanel) {
		this.title = "Lista de Productos"
		new Label(mainPanel).text = "Producto"
		new Selector<ProductoVMO>(mainPanel) => [
			allowNull = false
			(items <=> "productosDelRepo").adapter = new PropertyAdapter(Producto, "nombre")
			value <=> "productoObj"
		]
		
		new Label(mainPanel).text = "Precio"
		new Label(mainPanel).value <=> "precioDelProducto"
	}
}