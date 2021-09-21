package com.everis.data.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.data.models.Producto;
import com.everis.data.services.ProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService ps;

	//PathVariable, desde el URL al Controller
    //RequestParam, desde el jsp al controller
	//ModelAttribute, desde el controller al jsp
	
	// =================CREAR====================
	@RequestMapping("")
	public String index(@ModelAttribute("producto") Producto producto, Model model) {
		System.out.println("Index");
		List<Producto> lista_productos = ps.findAll();
		model.addAttribute("lista_productos", lista_productos);
		
		return "producto.jsp";
	}

	@RequestMapping(value = "/crear", method = RequestMethod.POST)
	public String crear(@Valid @ModelAttribute("producto") Producto producto) {
		System.out.println("CREATE" + producto);
		ps.crearProducto(producto);
		return "redirect:/producto";
	}

	// ============================================
	// ==============DELETE=======================
	@RequestMapping(value = "/eliminar", method = RequestMethod.POST)
	public String eliminar(@RequestParam("id") Long id) {
		System.out.println("eliminar la id:" + id);
		ps.eliminarProducto(id);
		return "redirect:/producto";
	}
	// ============================================
	
	// ==================EDITAR================
	@RequestMapping(value = "/actualizar/{id}", method = RequestMethod.GET)
	public String actualizar(@PathVariable("id") Long id, Model model) {
		System.out.println("actualizar id: " + id);
		Producto producto = ps.buscarProducto(id);
		model.addAttribute("producto", producto);
		return "productoEditar.jsp";
	}
	// ============================================
	// ==================MODIFICAR==================
	@RequestMapping(value="/modificar", method= RequestMethod.PUT)
	public String modificar(@Valid @ModelAttribute("venta") Producto producto) {
		ps.modificarProducto(producto);
		return "redirect:/producto";
	}
	//===============================================
	//AGREGAR PRODUCTOS A CARRITO
	
	
	Map<String, Integer> productDict = new HashMap<String, Integer>(); //Diccionario que guarda key(nombre), value(precio) 
	public Integer precioTotal = 0;
	
	@RequestMapping(value="/agregarcarrito", method= RequestMethod.POST)
	public String agregarCarrito(@RequestParam("nombre") String nombre,
			@RequestParam("precio") Integer precio, Model model) {
		
		productDict.put(nombre, precio);
		precioTotal += precio;
		model.addAttribute("lista_carrito", productDict);
		model.addAttribute("precio_total", precioTotal);

		return "carro.jsp";
	}
	
	@RequestMapping(value="/eliminarcarrito", method= RequestMethod.POST)
	public String eliminarCarrito(@RequestParam("nombre") String nombre,
								@RequestParam("precio") Integer precio, Model model) {
		
		productDict.remove(nombre);
		precioTotal -= precio;
		if(precioTotal < 0) {
			precioTotal = 0;
		}
		model.addAttribute("lista_carrito", productDict);
		model.addAttribute("precio_total", precioTotal);

		return "carro.jsp";
	}
}
