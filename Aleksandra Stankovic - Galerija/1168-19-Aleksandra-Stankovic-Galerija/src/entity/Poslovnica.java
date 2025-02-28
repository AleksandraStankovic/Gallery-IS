package entity;

import java.io.Serializable;

import java.util.Objects;



@SuppressWarnings("serial")
public class Poslovnica implements Serializable {
	
	private int idPoslovnica; 
	private String Adresa; 
	private String brojTelefona;
	
	public Poslovnica() { //svugdje ide ovo konstruktor sa praznim tijelom
	}
	
	public Poslovnica(int idPoslovnica, String adresa, String brojTelefona) {
		super();
		this.idPoslovnica = idPoslovnica;
		Adresa = adresa;
		this.brojTelefona = brojTelefona;
	}

	public int getIdPoslovnica() {
		return idPoslovnica;
	}

	public void setIdPoslovnica(int idPoslovnica) {
		this.idPoslovnica = idPoslovnica;
	}

	public String getAdresa() {
		return Adresa;
	}

	public void setAdresa(String adresa) {
		Adresa = adresa;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPoslovnica);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poslovnica other = (Poslovnica) obj;
		return idPoslovnica == other.idPoslovnica;
	}

	@Override
	public String toString() {
		return "Poslovnica idPoslovnica=" + idPoslovnica + ", Adresa=" + Adresa + ", brojTelefona=" + brojTelefona
				+ "\n";
	} 
	
	
	
	

}