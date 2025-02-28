package entity;
import java.math.BigDecimal;
import java.util.Objects;
import java.io.Serializable;


@SuppressWarnings("serial")
public class Racun_Stavka implements Serializable {

	private Racun racun; 
	private Proizvod proizvod; 
	private int Kolicina; 
	private BigDecimal Cijena; 
	
	public Racun_Stavka() {
	}

	public Racun_Stavka(Racun racun, Proizvod proizvod, int kolicina, BigDecimal cijena) {
		super();
		this.racun = racun;
		this.proizvod = proizvod;
		Kolicina = kolicina;
		Cijena = cijena;
	}

	@Override
	public int hashCode() {
		return Objects.hash(proizvod, racun);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Racun_Stavka other = (Racun_Stavka) obj;
		return Objects.equals(proizvod, other.proizvod) && Objects.equals(racun, other.racun);
	}

	@Override
	public String toString() {
		return "Racun_Stavka [racun=" + racun + ", proizvod=" + proizvod + ", Kolicina=" + Kolicina + ", Cijena="
				+ Cijena + "]";
	}

	public Racun getRacun() {
		return racun;
	}

	public void setRacun(Racun racun) {
		this.racun = racun;
	}

	public Proizvod getProizvod() {
		return proizvod;
	}

	public void setProizvod(Proizvod proizvod) {
		this.proizvod = proizvod;
	}

	public int getKolicina() {
		return Kolicina;
	}

	public void setKolicina(int kolicina) {
		Kolicina = kolicina;
	}

	public BigDecimal getCijena() {
		return Cijena;
	}

	public void setCijena(BigDecimal cijena) {
		Cijena = cijena;
	}
	
	
	
	
	
	
}