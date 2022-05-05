package com.grupollano.repo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupollano.model.entity.InventarioEntity;

public interface IInventarioDao extends JpaRepository<InventarioEntity, Long>{

}
