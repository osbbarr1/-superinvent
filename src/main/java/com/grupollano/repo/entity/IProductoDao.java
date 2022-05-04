package com.grupollano.repo.entity;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.grupollano.model.entity.ProductoEntity;

/**
 * 
 * @author oabaquero
 *
 */

public interface IProductoDao  extends PagingAndSortingRepository<ProductoEntity, Long>{

}
