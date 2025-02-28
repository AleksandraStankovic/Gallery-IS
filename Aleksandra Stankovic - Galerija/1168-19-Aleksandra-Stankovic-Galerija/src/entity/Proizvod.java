package entity;

import java.io.Serializable;
import java.util.Objects;


@SuppressWarnings("serial")

public class Proizvod implements Serializable {

	private int idProizvod; 
	private Kategorija kategorija; 
	private String Ime; 
	private float Cijena; 
	

	
	public Proizvod() {
	}
	
	
	
	public Proizvod(int idProizvod, Kategorija kategorija,String ime, float cijena) {
		super();
		this.idProizvod = idProizvod;
		this.kategorija = kategorija;
		Ime = ime;
		Cijena = cijena;
		
	}

	 
	public int getIdProizvod() {
		return idProizvod;
	}

	public void setIdProizvod(int idProizvod) {
		this.idProizvod = idProizvod;
	}

	public String getIme() {
		return Ime;
	}

	public void setIme(String ime) {
		Ime = ime;
	}

	public float getCijena() {
		return Cijena;
	}

	public void setCijena(float cijena) {
		Cijena = cijena;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}



	@Override
	public int hashCode() {
		return Objects.hash(idProizvod);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proizvod other = (Proizvod) obj;
		return idProizvod == other.idProizvod;
	}



	@Override
	public String toString() {
		return  Ime + " " + kategorija.getNaziv();
	}

	
	
}







