package data.sql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.Racun_StavkaDataAccess;
import entity.Racun_Stavka;

public class Racun_StavkaDataAccessImpl implements Racun_StavkaDataAccess {

	@Override
	public boolean dodaj_stavku(Racun_Stavka stavka) {
		
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;
		
		
		System.out.println(stavka.getCijena());
		String query = "INSERT INTO racun_stavka VALUES "
				+ "(?, ?, ?, ?) ";

		
		try {
			
			
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			
			
			ps.setInt(1, stavka.getRacun().getIdRacun());
			ps.setInt(2, stavka.getProizvod().getIdProizvod());
			ps.setInt(3,stavka.getKolicina());
			System.out.println("Ovdje je greska");
			ps.setBigDecimal(4, stavka.getCijena());
			System.out.println("Ovdje je greska");
			
			
			
			
			retVal = ps.executeUpdate() == 1;
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			MySQLUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			MySQLUtilities.getInstance().close(ps);
		}
		
		
		
		return retVal;
		
		

	}

}
