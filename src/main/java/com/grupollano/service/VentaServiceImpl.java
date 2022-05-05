package com.grupollano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupollano.model.entity.VentaEntity;
import com.grupollano.repo.entity.IVentaDao;

@Service
public class VentaServiceImpl implements IVentaService {
	
	@Autowired
	private IVentaDao iVentaDao;
	
	@Transactional(readOnly = true)
	public Page<VentaEntity> findAllPage(Pageable page) {
		return iVentaDao.findAll(page);
	}

	@Override
	public List<VentaEntity> findAll() {
		return iVentaDao.findAll();
	}


	@Override
	public void save(VentaEntity inventarioEntity) {
		iVentaDao.save(inventarioEntity);	
	}

	@Override
	public VentaEntity findOne(Long id) {
		return iVentaDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		iVentaDao.deleteById(id);
		
	}

}
