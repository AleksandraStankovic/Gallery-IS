package entity;

import java.io.Serializable;

import java.util.Objects;



@SuppressWarnings("serial")
public class Zaposleni implements Serializable {
	
	private int idZaposleni; 
	private String Ime; 
	private String Prezime; 
	private String brojTelefona;
	
	
	public Zaposleni() {
	}


	public Zaposleni(int idZaposleni, String ime, String prezime, String brojTelefona) {
		super();
		this.idZaposleni = idZaposleni;
		Ime = ime;
		Prezime = prezime;
		this.brojTelefona = brojTelefona;
	}


	public int getIdZaposleni() {
		return idZaposleni;
	}


	public void setIdZaposleni(int idZaposleni) {
		this.idZaposleni = idZaposleni;
	}


	public String getIme() {
		return Ime;
	}


	public void setIme(String ime) {
		Ime = ime;
	}


	public String getPrezime() {
		return Prezime;
	}


	public void setPrezime(String prezime) {
		Prezime = prezime;
	}


	public String getBrojTelefona() {
		return brojTelefona;
	}


	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idZaposleni);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Zaposleni other = (Zaposleni) obj;
		return idZaposleni == other.idZaposleni;
	}


	@Override
	public String toString() {
		return Ime +" "+ Prezime;
	}
	
	
	
	
}