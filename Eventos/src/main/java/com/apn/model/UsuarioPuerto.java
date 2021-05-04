package com.apn.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="USUARIOPUERTO")

public class UsuarioPuerto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name = "COD_USUARIO")
  
    private String codUsuario;
	
	@Column(name = "COD_PUERTO")
	private String codigoPuerto;
	
	@Column(name = "COD_ESTADO")
	private String codigoEstado;
	
	@Column(name = "FEC_REGISTRO")
	private Date fecRegistro;
	
	@Column(name = "COD_USUREGIS")
	private String codUsuregis;
	
	@Column(name = "FEC_MODIF")
	private Date FecModif;
	
	@Column(name = "COD_USUMODIF")
	
	private String codUsumodif;
	
	public String getCodUsuario() {
		
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getCodigoPuerto() {
		return codigoPuerto;
	}

	public void setCodigoPuerto(String codigoPuerto) {
		this.codigoPuerto = codigoPuerto;
	}

	public String getCodigoEstado() {
		return codigoEstado;
	}

	public void setCodigoEstado(String codigoEstado) {
		this.codigoEstado = codigoEstado;
	}

	public Date getFecRegistro() {
		return fecRegistro;
	}

	public void setFecRegistro(Date fecRegistro) {
		this.fecRegistro = fecRegistro;
	}

	public String getCodUsuregis() {
		return codUsuregis;
	}

	public void setCodUsuregis(String codUsuregis) {
		this.codUsuregis = codUsuregis;
	}

	public Date getFecModif() {
		return FecModif;
	}

	public void setFecModif(Date fecModif) {
		FecModif = fecModif;
	}

	public String getCodUsumodif() {
		return codUsumodif;
	}

	public void setCodUsumodif(String codUsumodif) {
		this.codUsumodif = codUsumodif;
	}
}
