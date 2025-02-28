	package data.sql;




import data.DataAccessFactory;
import data.ProizvodDataAccess;
import data.KategorijaDataAccess;
import data.RacunDataAccess;
import data.ZaposleniDataAccess;
import data.Racun_StavkaDataAccess;

public class MySQLDataAccessFactory extends DataAccessFactory {

	@Override
	public ProizvodDataAccess getProizvodDataAccess() {
		return new ProizvodDataAccessImpl();
	}
	
	@Override
	public RacunDataAccess getRacunDataAccess() {
		return new RacunDataAccessImpl();
	}
	
	@Override
	public KategorijaDataAccess getKategorijaDataAccess() {
		return new KategorijaDataAccessImpl();
	}
	
	@Override
	public ZaposleniDataAccess getZaposleniDataAccess() {
		return new ZaposleniDataAccessImpl();
	}
	
	@Override
	public Racun_StavkaDataAccess getRacun_StavkaDataAccess() {
		return new Racun_StavkaDataAccessImpl();
	}
	
}

