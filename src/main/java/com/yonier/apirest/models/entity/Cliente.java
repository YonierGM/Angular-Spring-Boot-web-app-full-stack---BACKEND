package com.yonier.apirest.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String apellido;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	private String Foto;
	
	@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Region region;
	
	
	

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getNombre() {
		return nombre;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}




	public String getApellido() {
		return apellido;
	}




	public void setApellido(String apellido) {
		this.apellido = apellido;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Date getCreateAt() {
		return createAt;
	}




	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}




	public String getFoto() {
		return Foto;
	}




	public void setFoto(String foto) {
		Foto = foto;
	}




	public Region getRegion() {
		return region;
	}




	public void setRegion(Region region) {
		this.region = region;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	private static final long serialVersionUID = 1L;
}
