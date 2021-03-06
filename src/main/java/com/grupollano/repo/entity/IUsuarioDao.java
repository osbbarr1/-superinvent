package com.grupollano.repo.entity;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.grupollano.model.entity.UsuariosEntity;

/**
 * 
 * @author oabaquero
 *
 */

public interface IUsuarioDao extends PagingAndSortingRepository<UsuariosEntity, Long>{

}
