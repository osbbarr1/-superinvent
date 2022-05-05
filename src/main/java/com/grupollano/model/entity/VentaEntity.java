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
@Table(name = "ven_venta", schema = "public")
public class VentaEntity implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ven_ide", nullable=false)
	private Long venide;
	
	@NotNull
	@Column(name="ven_factura", nullable=false)
	private Long venfactura;
	
	@NotNull
	@Column(name="ven_cantidad", nullable=false)
	private Long vencantidad;
	
	 @NotNull
	 @Column(name="ven_vlrunitario", nullable=false)
	 private Long venvlrunitario ;  
	 
	 @Temporal(TemporalType.TIMESTAMP)
     @Column(name="ven_fecventa")
     private Date  venfecventa ;
	 
	 @ManyToOne
	 @JoinColumn(name = "usuario_ide", referencedColumnName = "usuario_ide", nullable = true)
	 private UsuariosEntity usuario_ide;
	 
	 @ManyToOne
	 @JoinColumn(name = "pro_ide", referencedColumnName = "pro_ide", nullable = true)
	 private ProductoEntity pro_ide;

	public Long getVenide() {
		return venide;
	}

	public void setVenide(Long venide) {
		this.venide = venide;
	}

	public Long getVenfactura() {
		return venfactura;
	}

	public void setVenfactura(Long venfactura) {
		this.venfactura = venfactura;
	}

	public Long getVencantidad() {
		return vencantidad;
	}

	public void setVencantidad(Long vencantidad) {
		this.vencantidad = vencantidad;
	}

	public Long getVenvlrunitario() {
		return venvlrunitario;
	}

	public void setVenvlrunitario(Long venvlrunitario) {
		this.venvlrunitario = venvlrunitario;
	}

	public Date getVenfecventa() {
		return venfecventa;
	}

	public void setVenfecventa(Date venfecventa) {
		this.venfecventa = venfecventa;
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
