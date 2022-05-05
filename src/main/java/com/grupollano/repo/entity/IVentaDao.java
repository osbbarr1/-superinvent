package com.grupollano.repo.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupollano.model.entity.VentaEntity;

public interface IVentaDao extends JpaRepository<VentaEntity, Long> {

}
