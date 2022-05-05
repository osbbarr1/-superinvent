package com.grupollano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupollano.model.entity.InventarioEntity;
import com.grupollano.repo.entity.IVentaDao;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IVentaDao iVentaDao;
	
	@Transactional(readOnly = true)
	public Page<InventarioEntity> findAllPage(Pageable page) {
		return iVentaDao.findAll(page);
	}

	@Override
	public List<InventarioEntity> findAll() {
		return iVentaDao.findAll();
	}


	@Override
	public void save(InventarioEntity inventarioEntity) {
		iVentaDao.save(inventarioEntity);	
	}

	@Override
	public InventarioEntity findOne(Long id) {
		return iVentaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		iVentaDao.deleteById(id);
		
	}

}
