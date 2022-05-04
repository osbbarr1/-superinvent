package com.grupollano.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.grupollano.model.entity.ProductoEntity;
import com.grupollano.repo.entity.IProductoDao;

/**
 * 
 * @author oabaquero
 *
 */


@Service
public class ProductoServiceImpl implements IProductoServices{

	@Autowired
	private IProductoDao iProductoDao;
	
	@Transactional(readOnly = true)
	public Page<ProductoEntity> findAllPage(Pageable page) {		
		return iProductoDao.findAll(page);
	}
	
	
	@Override
	public List<ProductoEntity> findAll() {
		return (List<ProductoEntity>) iProductoDao.findAll();
	}

	@Override
	public void save(ProductoEntity productoEntity) {
		iProductoDao.save(productoEntity);		
	}

	@Override
	public ProductoEntity findOne(Long id) {
		return iProductoDao.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		iProductoDao.deleteById(id);
	}

}
