package com.grupollano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupollano.model.entity.UsuariosEntity;
import com.grupollano.repo.entity.IUsuarioDao;

/**
 * 
 * @author oabaquero
 *
 */

@Service
public class UsuarioServiceImpl implements IUsuarioServices {
	
	@Autowired
	private IUsuarioDao iUsuarioDao;

	@Transactional(readOnly = true)
	public Page<UsuariosEntity> findAllPage(Pageable page) {		
		return iUsuarioDao.findAll(page);
	}
	
	@Override
	public List<UsuariosEntity> findAll() {
		return (List<UsuariosEntity>) iUsuarioDao.findAll();
	}

	@Override
	public void save(UsuariosEntity usuario) {
		iUsuarioDao.save(usuario);
		
	}

	@Override
	public UsuariosEntity findOne(Long id) {
		return iUsuarioDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		iUsuarioDao.deleteById(id);
		
	}

}
