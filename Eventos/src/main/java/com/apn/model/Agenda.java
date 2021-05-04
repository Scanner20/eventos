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

@Entity
@Table (name="Agenda")

public class Agenda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_agenda")
	private String Id_agenda;
	
	@Column(name = "tema")
    @Id
	private String Tema;
	
	@Column(name = "fecha")
	private Date Fecha;
	
	@Column(name = "NOMBRE")
	private String Nombre;
	
	@Column(name = "APELLIDO")
	private String Apellido;

	public String getId_agenda() {
		return Id_agenda;
	}

	public void setId_agenda(String id_agenda) {
		Id_agenda = id_agenda;
	}

	public String getTema() {
		return Tema;
	}

	public void setTema(String tema) {
		Tema = tema;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	



	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	



	

}
