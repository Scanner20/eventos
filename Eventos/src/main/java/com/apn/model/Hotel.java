package com.apn.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name="Hotel")

public class Hotel implements Serializable {
	

	
	private static final long serialVersionUID = 1L;

	
	@Column(name = "codigo")
	private String Codigo;
	
	@Column(name = "id")
	private String Id;
	
	@Column(name = "nombre")
    @Id
	private String Nombre;
	
	@Column(name = "direccion")
	private String Direccion;
	
	@Column(name = "estrellas")
	private String Estrellas;
	
	@Column(name = "phone")
	private String Phone;
	
	@Column(name = "web")
	private String Web;
	
	@Column(name = "latitud")
	private String Latitud;
	
	@Column(name = "longitud")
	private String Longitud;
	
	@Column(name = "imagen")
	private String Imagen;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getEstrellas() {
		return Estrellas;
	}

	public void setEstrellas(String estrellas) {
		Estrellas = estrellas;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getWeb() {
		return Web;
	}

	public void setWeb(String web) {
		Web = web;
	}

	public String getLatitud() {
		return Latitud;
	}

	public void setLatitud(String latitud) {
		Latitud = latitud;
	}

	public String getLongitud() {
		return Longitud;
	}

	public void setLongitud(String longitud) {
		Longitud = longitud;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}
	



	



}
