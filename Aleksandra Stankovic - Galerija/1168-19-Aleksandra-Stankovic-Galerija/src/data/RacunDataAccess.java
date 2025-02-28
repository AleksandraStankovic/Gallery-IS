package data;

import java.util.List;
import entity.Racun;


public interface RacunDataAccess {
	
	List <Racun> Racuni();
	boolean dodajRacun(Racun racun);
	boolean obrisiRacun(Racun racun);
	boolean azurirajRacun(Racun racun);
	
}
