package com.grupollano.controllers;

import java.util.List;

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

import com.grupollano.model.entity.VentaEntity;
import com.grupollano.service.VentaServiceImpl;
import com.grupollano.util.GenericoResponse;

/**
 * 
 * @author oabaquero
 *
 *
 */

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/venta")
public class VentaController {

	@Autowired
	private VentaServiceImpl ventaServiceImpl;
	
	@GetMapping(path = "/all/v1", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VentaEntity> getVentas() {
		return ventaServiceImpl.findAll();
	}
	

	@PostMapping(path = {"/save/v1"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<GenericoResponse> saveVenta(@RequestBody VentaEntity ventaEntity) {
		this.ventaServiceImpl.save(ventaEntity);
		return new ResponseEntity<>( new GenericoResponse<>(ventaEntity, "Se Grabo exitosamente"), HttpStatus.OK);
	}
	
	
	@DeleteMapping(path = {"/remove/v1/{Id}"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<GenericoResponse> removeVenta( @PathVariable("Id") Long Id) {
		try {
			VentaEntity retorna = new VentaEntity(); 
			retorna =  this.ventaServiceImpl.findOne(Id) ;
			if(retorna == null) 
				return new ResponseEntity<>(new GenericoResponse<>(null, "No esiste el producto a Eliminar "), HttpStatus.OK);		
			if(retorna.getVenide().longValue() == Id)
			this.ventaServiceImpl.delete(Id);
			
		} catch (Exception e) {
			System.out.print(e);
		}
		
		return new ResponseEntity<>(new GenericoResponse<>(null, "Se elimino con exito"), HttpStatus.OK);
	}
	
}
