package com.grupollano.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupollano.model.entity.ProductoEntity;
import com.grupollano.service.ProductoServiceImpl;
import com.grupollano.util.GenericoResponse;

/**
 * 
 * @author oabaquero
 *
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/producto")
public class ProductoRestController {
	
	@Autowired
	private ProductoServiceImpl productoServiceImpl;
	
	@GetMapping(path = "/all/v1", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductoEntity> getProductos() {
		return productoServiceImpl.findAll();
	}
	
	@PostMapping(path = {"/save/v1"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<GenericoResponse> saveProducto(@RequestBody ProductoEntity productoEntity) {
		this.productoServiceImpl.save(productoEntity);
		return new ResponseEntity<>( new GenericoResponse<>(productoEntity, "Se Grabo exitosamente"), HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = {"/remove/v1/{Id}"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<GenericoResponse> removeUsuario( @PathVariable("Id") Long Id) {
		try {
			ProductoEntity retorna = new ProductoEntity(); 
			retorna =  this.productoServiceImpl.findOne(Id) ;
			if(retorna == null) 
				return new ResponseEntity<>(new GenericoResponse<>(null, "No esiste el producto a Eliminar "), HttpStatus.OK);		
			if(retorna.getProide().longValue() == Id)
			this.productoServiceImpl.delete(Id);
			
		} catch (Exception e) {
			System.out.print(e);
		}
		
		return new ResponseEntity<>(new GenericoResponse<>(null, "Se elimino con exito"), HttpStatus.OK);
	}
	
	

}
