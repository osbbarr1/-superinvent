package com.grupollano.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * 
 * @author oabaquero
 *
 */


@Entity
@Table(name = "pro_productos", schema = "public")
public class ProductoEntity implements Serializable{
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="pro_ide", nullable=false)
	 private Long proide ; 
	 
	 @NotNull
	 @Column(name="pro_vlrunitario", nullable=false)
	 private Long provlrunitario ;  
	 
	 
	 @NotNull
	 @Size(min=1, max=100)
     @Column(name="pro_nombre", nullable= false, length=100)
     private String pronombre ;
	 
	 @Temporal(TemporalType.TIMESTAMP)
     @Column(name="pro_feccrea")
     private Date  profeccrea ;
	 
	 @Temporal(TemporalType.TIMESTAMP)
     @Column(name="pro_fecactualiza")
     private Date  profecactualiza ;
	 
	 @ManyToOne
	 @JoinColumn(name = "usuario_ide", referencedColumnName = "usuario_ide", nullable = true)
	 private UsuariosEntity usuario_ide;

	public Long getProide() {
		return proide;
	}

	public void setProide(Long proide) {
		this.proide = proide;
	}

	public Long getProvlrunitario() {
		return provlrunitario;
	}

	public void setProvlrunitario(Long provlrunitario) {
		this.provlrunitario = provlrunitario;
	}

	public String getPronombre() {
		return pronombre;
	}

	public void setPronombre(String pronombre) {
		this.pronombre = pronombre;
	}

	public Date getProfeccrea() {
		return profeccrea;
	}

	public void setProfeccrea(Date profeccrea) {
		this.profeccrea = profeccrea;
	}

	public Date getProfecactualiza() {
		return profecactualiza;
	}

	public void setProfecactualiza(Date profecactualiza) {
		this.profecactualiza = profecactualiza;
	}

	public UsuariosEntity getUsuario_ide() {
		return usuario_ide;
	}

	public void setUsuario_ide(UsuariosEntity usuario_ide) {
		this.usuario_ide = usuario_ide;
	}
	 
	 
	 
	 
}
