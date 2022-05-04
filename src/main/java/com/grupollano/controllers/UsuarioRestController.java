package com.grupollano.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.hibernate.hql.internal.ast.tree.IsNullLogicOperatorNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupollano.model.entity.UsuariosEntity;
import com.grupollano.service.UsuarioServiceImpl;
import com.grupollano.util.GenericoResponse;


/**
 * 
 * @author oabaquero
 *
 */

@CrossOrigin
@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@GetMapping(path = { "/all/v1" }, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UsuariosEntity> getUsuarios() {
		return usuarioServiceImpl.findAll();
	}
	
	@GetMapping(path = {"/","/page/v1"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public Page<UsuariosEntity> usuarios(@RequestParam(name = "page", defaultValue = "0") int page){
		
		Pageable pageableRequest = PageRequest.of(page, 10);
		Page<UsuariosEntity> usuarios =  this.usuarioServiceImpl.findAllPage(pageableRequest);
		return usuarios;
		
		
	}
	
	@PostMapping(path = {"/save/v1"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<GenericoResponse> saveUsuario(@RequestBody UsuariosEntity usuarioEntity) {
		this.usuarioServiceImpl.save(usuarioEntity);
		return new ResponseEntity<>( new GenericoResponse<>(usuarioEntity, "Se Grabo exitosamente"), HttpStatus.OK);
	}
	
	@DeleteMapping(path = {"/remove/v1/{Id}"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<GenericoResponse> removeUsuario( @PathVariable("Id") Long Id) {
		try {
			UsuariosEntity retorna = new UsuariosEntity(); 
			retorna =  this.usuarioServiceImpl.findOne(Id) ;
			if(retorna == null) 
				return new ResponseEntity<>(new GenericoResponse<>(null, "No esiste el usuario a Eliminar "), HttpStatus.OK);		
			if(retorna.getUsuarioide().longValue() == Id)
			this.usuarioServiceImpl.delete(Id);
			
		} catch (Exception e) {
			System.out.print(e);
		}
		
		return new ResponseEntity<>(new GenericoResponse<>(null, "Se elimino con exito"), HttpStatus.OK);
	}
	

}
