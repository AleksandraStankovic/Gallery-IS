package entity;
import java.sql.Timestamp;
import java.util.Objects;
import java.io.Serializable;
import java.math.BigDecimal;

@SuppressWarnings("serial")
public class Racun implements Serializable {
	
	private int idRacun; 
	private Timestamp Vrijeme; 
	private Zaposleni zaposleni; 
	private BigDecimal Cijena;
	
	
	public BigDecimal getCijena() {
		return Cijena;
	}


	public void setCijena(BigDecimal cijena) {
		Cijena = cijena;
	}


	public Racun(){
		
	}


	public Racun(int idRacun, Timestamp vrijeme, Zaposleni zaposleni, BigDecimal cijena) {
		super();
		this.idRacun = idRacun;
		Vrijeme = vrijeme;
		this.zaposleni = zaposleni;
		Cijena = cijena;
	}


	public Racun(int idRacun, Timestamp vrijeme, Zaposleni zaposleni) {
		super();
		this.idRacun = idRacun;
		Vrijeme = vrijeme;
		this.zaposleni = zaposleni;
	}


	public int getIdRacun() {
		return idRacun;
	}


	public void setIdRacun(int idRacun) {
		this.idRacun = idRacun;
	}


	public Timestamp getVrijeme() {
		return Vrijeme;
	}


	public void setVrijeme(Timestamp vrijeme) {
		Vrijeme = vrijeme;
	}


	public Zaposleni getZaposleni() {
		return zaposleni;
	}


	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	

	@Override
	public String toString() {
		return "idRacun=" + idRacun ;
	}


	@Override
	public int hashCode() {
		return Objects.hash(idRacun);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Racun other = (Racun) obj;
		return idRacun == other.idRacun;
	}
	
	
	
	
	
}