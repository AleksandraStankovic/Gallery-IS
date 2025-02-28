package data;


import data.sql.MySQLDataAccessFactory;

public abstract class DataAccessFactory {
	
	
	public abstract ProizvodDataAccess getProizvodDataAccess();
	public abstract RacunDataAccess getRacunDataAccess();
	public abstract KategorijaDataAccess getKategorijaDataAccess();
	public abstract ZaposleniDataAccess getZaposleniDataAccess();
	public abstract Racun_StavkaDataAccess getRacun_StavkaDataAccess();
	
	public static DataAccessFactory getFactory(DataAccessFactoryType type) {
		if (DataAccessFactoryType.MySQL.equals(type)) {
			return new MySQLDataAccessFactory();
		}
		throw new IllegalArgumentException();
	}
	
}



