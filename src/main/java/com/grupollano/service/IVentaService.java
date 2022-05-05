package com.grupollano.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable; 

import com.grupollano.model.entity.VentaEntity;


public interface IVentaService {

	public List<VentaEntity> findAll();
	
	public Page<VentaEntity> findAllPage(Pageable page);
	
	public void save(VentaEntity inventarioEntity);
	
	public VentaEntity findOne(Long id);
	
	public void delete(Long id);
	
}
