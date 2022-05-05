package com.grupollano.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 

import com.grupollano.model.entity.InventarioEntity;


public interface IVentaService {

	public List<InventarioEntity> findAll();
	
	public Page<InventarioEntity> findAllPage(Pageable page);
	
	public void save(InventarioEntity inventarioEntity);
	
	public InventarioEntity findOne(Long id);
	
	public void delete(Long id);
	
}
