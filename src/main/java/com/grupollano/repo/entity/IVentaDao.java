package com.grupollano.repo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupollano.model.entity.InventarioEntity;

public interface IVentaDao extends JpaRepository<InventarioEntity, Long> {

}
