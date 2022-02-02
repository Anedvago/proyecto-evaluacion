package com.example.demo.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TIPOS_IDENTIFICACIONES")
public class TipoIdentificacion {

	@Id
	private long tipoIdentificacion;
	
	@Column(name = "ABREVIATURA")
	private String abreviatura;
	
	@Column(name ="DESCRIPCION")
	private String descripcion;

	public TipoIdentificacion() {
		
	}

	public TipoIdentificacion(long tipoIdentificacion, String abreviatura, String descripcion) {
		super();
		this.tipoIdentificacion = tipoIdentificacion;
		this.abreviatura = abreviatura;
		this.descripcion = descripcion;
	}

	public long getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(long tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	

}
