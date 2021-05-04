package com.apn.model;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import com.apn.model.DatCatalogo;

@Entity
@Table (name="DATGRUPOCAT")

public class DatGrupoCat {
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_GRUPO")
    @Id
	private String codigoGrupo;
	
	@Column(name = "COD_CATALOGO")
	private String codigoCatalogo;
	
	@Column(name = "COD_DATCATALOGO")
	private String codigoDatCatalogo;
	
	@Column(name = "FEC_INI_DATCAT")
	private Date fechaInDatCat;
	
	@Column(name = "FEC_INI_DATGRUCAT")
	private Date fechaIniDatGrucat;
	
	@Column(name = "FEC_FIN_DATGRUCAT")
	private Date fecheIniFinDatGrupoCat;
	
	@Column(name = "COD_ESTADO")
	private String codEstado;
	
	@Column(name = "FEC_REGISTRO")
	private Date fechaRegistro;
	
	@Column(name = "COD_USUREGIS")
	private String codUsuRegis;
	
	@Column(name = "FEC_MODIF")
	
	private Date fechaModif;
	
	@Column(name = "COD_CATALOGO_DEST")
	private String codCatalogoDest;
	
	

	public String getCodigoGrupo() {
		return codigoGrupo;
	}

	public void setCodigoGrupo(String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
	
	public String getCodigoCatalogo() {
		return codigoCatalogo;
	}

	public void setCodigoCatalogo(String codigoCatalogo) {
		this.codigoCatalogo = codigoCatalogo;
	}

	public String getCodigoDatCatalogo() {
		return codigoDatCatalogo;
	}

	public void setCodigoDatCatalogo(String codigoDatCatalogo) {
		this.codigoDatCatalogo = codigoDatCatalogo;
	}

	public Date getFechaInDatCat() {
		return fechaInDatCat;
	}

	public void setFechaInDatCat(Date fechaInDatCat) {
		this.fechaInDatCat = fechaInDatCat;
	}

	public Date getFechaIniDatGrucat() {
		return fechaIniDatGrucat;
	}

	public void setFechaIniDatGrucat(Date fechaIniDatGrucat) {
		this.fechaIniDatGrucat = fechaIniDatGrucat;
	}

	public Date getFecheIniFinDatGrupoCat() {
		return fecheIniFinDatGrupoCat;
	}

	public void setFecheIniFinDatGrupoCat(Date fecheIniFinDatGrupoCat) {
		this.fecheIniFinDatGrupoCat = fecheIniFinDatGrupoCat;
	}

	public String getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getCodUsuRegis() {
		return codUsuRegis;
	}

	public void setCodUsuRegis(String codUsuRegis) {
		this.codUsuRegis = codUsuRegis;
	}

	public Date getFechaModif() {
		return fechaModif;
	}

	public void setFechaModif(Date fechaModif) {
		this.fechaModif = fechaModif;
	}

	public String getCodCatalogoDest() {
		return codCatalogoDest;
	}

	public void setCodCatalogoDest(String codCatalogoDest) {
		this.codCatalogoDest = codCatalogoDest;
	}
	
}
	