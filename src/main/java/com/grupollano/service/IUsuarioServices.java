package com.grupollano.service;

import java.util.List;

import com.grupollano.model.entity.UsuariosEntity;

/**
 * 
 * @author oabaquero
 *
 */


public interface IUsuarioServices {

	public List<UsuariosEntity> findAll();
	
	public void save(UsuariosEntity usuario);
	
	public UsuariosEntity findOne(Long id);
	
	public void delete(Long id);
}
