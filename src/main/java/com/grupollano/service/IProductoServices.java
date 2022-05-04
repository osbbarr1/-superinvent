package com.grupollano.service;

import java.util.List;

import com.grupollano.model.entity.ProductoEntity;

/**
 * 
 * @author oabaquero
 *
 */


public interface IProductoServices {
	
	public List<ProductoEntity> findAll();
	
	public void save(ProductoEntity productoEntity);
	
	public ProductoEntity findOne(Long id);
	
	public void delete(Long id);

}
