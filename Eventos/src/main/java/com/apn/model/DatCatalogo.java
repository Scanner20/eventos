package com.apn.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table (name="DATCATALOGO")

public class DatCatalogo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "COD_CATALOGO")
    @Id
    private String codCatalogo;
	
	@Column(name = "COD_TIPOUSUARIO")
	private String codigoTipoUsuario;
	
	@Column(name = "FEC_INI_DATCAT")
	private Date fecIniDataCat;
	
	@Column(name = "FEC_FIN_DATCAT")
	private Date fecFinDataCat;
	
	@Column(name = "DES_DATCATALOGO")
	private String desDatcatalaogo;
	
	@Column(name = "DES_CORTA")
	private String desCorta;
	
	@Column(name = "COD_ESTADO")
	private String codEstado;
	
	@Column(name = "COD_USUREGIS")
	private String codUsuregis;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CATALOGO_GRUPO", joinColumns = @JoinColumn(name = "COD_GRUPO"))
	private List<DatGrupoCat> datGrupoCat;
	
	
	public List<DatGrupoCat> getDatGrupoCat() {
		return datGrupoCat;
	}

	public void setDatGrupoCat(List<DatGrupoCat> datGrupoCat) {
		this.datGrupoCat = datGrupoCat;
	}

	public String getCodCatalogo() {
		return codCatalogo;
	}
	
	public void setCodCatalogo(String codCatalogo) {
		this.codCatalogo = codCatalogo;
	}
	
	public String getCodigoTipoUsuario() {
		return codigoTipoUsuario;
	}

	public void setCodigoTipoUsuario(String codigoTipoUsuario) {
		this.codigoTipoUsuario = codigoTipoUsuario;
	}

	public Date getFecIniDataCat() {
		return fecIniDataCat;
	}

	public void setFecIniDataCat(Date fecIniDataCat) {
		this.fecIniDataCat = fecIniDataCat;
	}

	public Date getFecFinDataCat() {
		return fecFinDataCat;
	}

	public void setFecFinDataCat(Date fecFinDataCat) {
		this.fecFinDataCat = fecFinDataCat;
	}

	public String getDesDatcatalaogo() {
		return desDatcatalaogo;
	}

	public void setDesDatcatalaogo(String desDatcatalaogo) {
		this.desDatcatalaogo = desDatcatalaogo;
	}

	public String getDesCorta() {
		return desCorta;
	}

	public void setDesCorta(String desCorta) {
		this.desCorta = desCorta;
	}

	public String getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public String getCodUsuregis() {
		return codUsuregis;
	}

	public void setCodUsuregis(String codUsuregis) {
		this.codUsuregis = codUsuregis;
	}
		
}
