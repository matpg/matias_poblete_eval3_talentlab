package com.everis.data.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.data.models.Producto;
import com.everis.data.repositories.ProductoRespository;

@Service
public class ProductoService {
	//logica de negocio o empresarial
	
	@Autowired
	private ProductoRespository pR; //dependencia de servicio

	public List<Producto> findAll() {
		return pR.findAll();
	}

	public void crearProducto(@Valid Producto producto) {
		pR.save(producto);
	}

	public Producto buscarProducto(Long id) {
		Optional<Producto> oProducto = pR.findById(id);
		if(oProducto.isPresent()) {
			return oProducto.get();
		}
		return null;
	}

	public void modificarProducto(@Valid Producto producto) {
		pR.save(producto);
		
	}

	public void eliminarProducto(Long id) {
		pR.deleteById(id);
	}
	
}
