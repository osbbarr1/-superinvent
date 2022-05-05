package com.grupollano.service;

import java.util.List;
import java.util.Optional;

import com.grupollano.model.entity.InventarioEntity;

public interface IInventarioServices {

	public List<InventarioEntity> findAll();
	
	public void save(InventarioEntity inventarioEntity);
	
	public Optional<InventarioEntity> findOne(Long id);
	
	public void delete(Long id);
}
