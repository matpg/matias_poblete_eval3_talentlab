package com.everis.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.everis.data.models.Producto;

public interface ProductoRespository extends JpaRepository<Producto, Long>{
	
	
}
