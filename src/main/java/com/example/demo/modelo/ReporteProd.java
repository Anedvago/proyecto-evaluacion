package com.example.demo.modelo;

public class ReporteProd {
	
	private String idProd;
	private long CantAlMes;
	private long mes;
	
	
	
	public ReporteProd() {
		
	}



	public ReporteProd(String idProd, long cantAlMes, long mes) {
		super();
		this.idProd = idProd;
		CantAlMes = cantAlMes;
		this.mes = mes;
	}



	public String getIdProd() {
		return idProd;
	}



	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}



	public long getCantAlMes() {
		return CantAlMes;
	}



	public void setCantAlMes(long cantAlMes) {
		CantAlMes = cantAlMes;
	}



	public long getMes() {
		return mes;
	}



	public void setMes(long mes) {
		this.mes = mes;
	}
	
	
	
	
	
}
