package com.grupollano.controllers;

import java.util.List;
import java.util.Optional;
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

import com.grupollano.model.entity.InventarioEntity;
import com.grupollano.service.IInventarioServiceImpl;
import com.grupollano.util.GenericoResponse;

/**
 * 
 * @author oabaquero
 *
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/inventario")
public class InventarioController {
	
	@Autowired
	private IInventarioServiceImpl inventarioServiceImpl;
	
	@GetMapping(path = "/all/v1", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<InventarioEntity> getVentas() {
		return inventarioServiceImpl.findAll();
	}
	

	@PostMapping(path = {"/save/v1"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<GenericoResponse> saveVenta(@RequestBody InventarioEntity inventarioEntity) {
		this.inventarioServiceImpl.save(inventarioEntity);
		return new ResponseEntity<>( new GenericoResponse<>(inventarioEntity, "Se Grabo exitosamente"), HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = {"/remove/v1/{Id}"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<GenericoResponse> removeVenta( @PathVariable("Id") Long Id) {
		try {
			Optional<InventarioEntity> retorna = Optional.of(new InventarioEntity()); 
			retorna =  this.inventarioServiceImpl.findOne(Id) ;
			if(retorna == null) 
				return new ResponseEntity<>(new GenericoResponse<>(null, "No esiste el producto a Eliminar "), HttpStatus.OK);		
			
			this.inventarioServiceImpl.delete(Id);
			
		} catch (Exception e) {
			System.out.print(e);
		}
		
		return new ResponseEntity<>(new GenericoResponse<>(null, "Se elimino con exito"), HttpStatus.OK);
	}
}
