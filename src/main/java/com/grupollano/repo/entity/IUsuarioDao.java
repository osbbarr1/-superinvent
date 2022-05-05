package com.grupollano.repo.entity;

import org.springframework.data.repository.CrudRepository;

import com.grupollano.model.entity.UsuariosEntity;

/**
 * 
 * @author oabaquero
 *
 */

public interface IUsuarioDao extends CrudRepository<UsuariosEntity, Long>{
	public UsuariosEntity findByUsername(String username);
}
