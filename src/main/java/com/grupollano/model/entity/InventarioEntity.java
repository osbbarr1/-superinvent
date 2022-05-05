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
@Table(name = "inv_inventarios", schema = "public")
public class InventarioEntity  implements Serializable{
	
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="inv_ide", nullable=false)
	 private Long invide ; 
	 
	 @NotNull
	 @Column(name="inv_cantidad", nullable=false)
	 private Long invcantidad;
	 
	 @NotNull
	 @Column(name="inv_vlrunitario", nullable=false)
	 private Long invvlrunitario ;  
	
	 @Temporal(TemporalType.TIMESTAMP)
     @Column(name="inv_fecventa")
     private Date  invfecventa ;
	 
	 @ManyToOne
	 @JoinColumn(name = "usuario_ide", referencedColumnName = "usuario_ide", nullable = true)
	 private UsuariosEntity usuario_ide;
	 
	 @ManyToOne
	 @JoinColumn(name = "pro_ide", referencedColumnName = "pro_ide", nullable = true)
	 private ProductoEntity pro_ide;

	public Long getInvide() {
		return invide;
	}

	public void setInvide(Long invide) {
		this.invide = invide;
	}

	public Long getInvcantidad() {
		return invcantidad;
	}

	public void setInvcantidad(Long invcantidad) {
		this.invcantidad = invcantidad;
	}

	public Long getInvvlrunitario() {
		return invvlrunitario;
	}

	public void setInvvlrunitario(Long invvlrunitario) {
		this.invvlrunitario = invvlrunitario;
	}

	public Date getInvfecventa() {
		return invfecventa;
	}

	public void setInvfecventa(Date invfecventa) {
		this.invfecventa = invfecventa;
	}

	public UsuariosEntity getUsuario_ide() {
		return usuario_ide;
	}

	public void setUsuario_ide(UsuariosEntity usuario_ide) {
		this.usuario_ide = usuario_ide;
	}

	public ProductoEntity getPro_ide() {
		return pro_ide;
	}

	public void setPro_ide(ProductoEntity pro_ide) {
		this.pro_ide = pro_ide;
	}
	 
	 
	 
	 

}
