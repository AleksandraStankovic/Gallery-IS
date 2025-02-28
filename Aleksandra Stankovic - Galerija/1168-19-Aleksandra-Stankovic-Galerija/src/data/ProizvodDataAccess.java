package data;
import java.util.List;

//ovo je interface za klasu Proizvod data acces, definisano je koje su operacije a onda ih kasnije implementiramo. 

//import org.unibl.etf.bp.uniis.entity.Fakultet;
import entity.Proizvod;//ovo je valjda dovoljno dobro za import, idk




public interface ProizvodDataAccess {
	
	List<Proizvod> Proizvodi();
	boolean dodajProizvod(Proizvod proizvod);
	boolean azurirajProizvod(Proizvod proizvod);
	boolean obrisiProizvod(int idProizvod);
	List<Proizvod> pretraga_proizvoda(String Ime); 

}


