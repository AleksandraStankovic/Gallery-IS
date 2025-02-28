package data;

import java.util.List;

import entity.Kategorija;

public interface KategorijaDataAccess {
	List<Kategorija> Kategorije(String nazivKategorije);

}
