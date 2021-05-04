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
@Table (name="Expositor")

public class Configuracion implements Serializable {
	

	
	private static final long serialVersionUID = 1L;

	
	@Column(name = "codigo")
	private String Codigo;
	
	@Column(name = "id_expositor")
    @Id
	private String idExpositor;
	
	@Column(name = "nombre")
	private String Nombre;
	
	@Column(name = "apellido")
	private String Apellido;
	
	@Column(name = "cargo")
	private String Cargo;
	
	@Column(name = "empresa")
	private String Empresa;
	
	@Column(name = "resenia")
	private String Resenia;
	
	@Column(name = "imagen")
	private String Imagen;
	
	@Column(name = "TEMA")
	private String Tema;
	
	
	public String getIdExpositor() {
		return idExpositor;
	}

	public void setIdExpositor(String idExpositor) {
		this.idExpositor = idExpositor;
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

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public String getResenia() {
		return Resenia;
	}

	public void setResenia(String resenia) {
		Resenia = resenia;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getTema() {
		return Tema;
	}

	public void setTema(String tema) {
		Tema = tema;
	}


	



}
