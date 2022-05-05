package com.grupollano.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "usuarios", schema = "public")
public class UsuariosEntity implements Serializable {

	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="usuario_ide", nullable=false)
	 private Long usuarioide ; 
	 
	 @NotNull
	 @Size(min=1, max=100)
     @Column(name="usuario_nombre", nullable= false, length=100)
     private String usuarionombre ;
	 
	 @Column(name = "username")
	 private String username;
	 
	 public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@NotNull
	 @Size(min=1, max=100)
     @Column(name="usuario_pass", nullable= false, length=100)
     private String usuariopass ;
	 
	 @NotNull
     @Size( min = 1, max = 1 )
     @Column(name="usuario_estado", nullable=false, length=1)
	 private String usuarioestado;
	 
	 @Temporal(TemporalType.TIMESTAMP)
     @Column(name="usuario_vigenciainicial")
     private Date  usuariovigenciainicial ;
	 
	 @Temporal(TemporalType.TIMESTAMP)
     @Column(name="usuario_vigenciafinal")
     private Date  usuariovigenciafinal ;

	 
	

	public Long getUsuarioide() {
		return usuarioide;
	}

	public void setUsuarioide(Long usuarioide) {
		this.usuarioide = usuarioide;
	}

	public String getUsuarionombre() {
		return usuarionombre;
	}

	public void setUsuarionombre(String usuarionombre) {
		this.usuarionombre = usuarionombre;
	}

	public String getUsuariopass() {
		return usuariopass;
	}

	public void setUsuariopass(String usuariopass) {
		this.usuariopass = usuariopass;
	}

	public String getUsuarioestado() {
		return usuarioestado;
	}

	public void setUsuarioestado(String usuarioestado) {
		this.usuarioestado = usuarioestado;
	}

	public Date getUsuariovigenciainicial() {
		return usuariovigenciainicial;
	}

	public void setUsuariovigenciainicial(Date usuariovigenciainicial) {
		this.usuariovigenciainicial = usuariovigenciainicial;
	}

	public Date getUsuariovigenciafinal() {
		return usuariovigenciafinal;
	}

	public void setUsuariovigenciafinal(Date usuariovigenciafinal) {
		this.usuariovigenciafinal = usuariovigenciafinal;
	}

}
