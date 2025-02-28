package entity;

import java.io.Serializable;

import java.util.Objects;



@SuppressWarnings("serial")
public class Kategorija implements Serializable {

	private int idKategorija; 
	private String Naziv;
	
	

	
	public Kategorija() {
	}



	public Kategorija(int idKategorija, String naziv) {
		super();
		this.idKategorija = idKategorija;
		Naziv = naziv;
	}

	public int getIdKategorija() {
		return idKategorija;
	}


	public void setIdKategorija(int idKategorija) {
		this.idKategorija = idKategorija;
	}


	public String getNaziv() {
		return Naziv;
	}


	public void setNaziv(String naziv) {
		Naziv = naziv;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kategorija other = (Kategorija) obj;
		return idKategorija == other.idKategorija;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(idKategorija);
	}



	@Override
	public String toString() {
		return  Naziv;
	}
	
	
	
	
	
	
}
	
	
	

