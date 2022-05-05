package com.grupollano.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupollano.model.entity.InventarioEntity;
import com.grupollano.repo.entity.IInventarioDao;

/**
 * 
 * @author oabaquero
 *
 */


@Service
public class IInventarioServiceImpl implements IInventarioServices{

	
	@Autowired
	private IInventarioDao iInventarioDao;
	@Override
	public List<InventarioEntity> findAll() {
		// TODO Auto-generated method stub
		return iInventarioDao.findAll();
	}

	@Override
	public void save(InventarioEntity inventarioEntity) {
		iInventarioDao.save(inventarioEntity);
		
	}

	@Override
	public Optional<InventarioEntity> findOne(Long id) {
		// TODO Auto-generated method stub
		return iInventarioDao.findById(id);
	}

	@Override
	public void delete(Long id) {
		iInventarioDao.deleteById(id);
		
	}

}
