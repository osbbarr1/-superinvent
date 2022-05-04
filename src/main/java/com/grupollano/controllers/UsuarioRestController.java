package com.grupollano.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grupollano.model.entity.UsuariosEntity;
import com.grupollano.service.UsuarioServiceImpl;

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
	public List<UsuariosEntity> getFiguras() {
		return usuarioServiceImpl.findAll();

	}
	
	@GetMapping(path = {"/","/page/v1"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public Page<UsuariosEntity> usuarios(@RequestParam(name = "page", defaultValue = "0") int page){
		
		Pageable pageableRequest = PageRequest.of(page, 10);
		Page<UsuariosEntity> usuarios =  this.usuarioServiceImpl.findAllPage(pageableRequest);
		return usuarios;
		
		
	}
	
	@PostMapping(path = {"/save/v1"}, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<UsuariosEntity> saveUsuario(@RequestBody UsuariosEntity usuarioEntity) {
		this.usuarioServiceImpl.save(usuarioEntity);
		return new ResponseEntity<UsuariosEntity>(usuarioEntity, HttpStatus.OK);
	}
	

}
