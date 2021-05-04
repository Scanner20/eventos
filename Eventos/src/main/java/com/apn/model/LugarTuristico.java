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
@Table (name="LugarTuristico")

public class LugarTuristico implements Serializable {
	

	
	private static final long serialVersionUID = 1L;


	@Column(name = "id")
	private String Id;
	
	@Column(name = "nombre")
    @Id
	private String Nombre;
	
	@Column(name = "resenia")
	private String Resenia;
	
	@Column(name = "latitud")
	private String Latitud;
	
	@Column(name = "longitud")
	private String Longitud;

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

	public String getResenia() {
		return Resenia;
	}

	public void setResenia(String resenia) {
		Resenia = resenia;
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
	
	



}
