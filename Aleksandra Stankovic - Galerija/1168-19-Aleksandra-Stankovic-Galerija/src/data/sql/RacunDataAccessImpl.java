package data.sql;


import entity.Racun;
import entity.Zaposleni;
import data.RacunDataAccess;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;



public class RacunDataAccessImpl implements RacunDataAccess{
	
	@Override
	public List <Racun> Racuni()
	{
List <Racun> retVal = new ArrayList <Racun>();
		
		Connection conn=null; 
		Statement s= null; 
		ResultSet rs=null; 
		
		String query = "SELECT * FROM racun NATURAL JOIN zaposleni";
		
		
try {
			
			conn = ConnectionPool.getInstance().checkOut();
			s = conn.createStatement();
			rs=s.executeQuery(query);
			
		
			while (rs.next())
				retVal.add(new Racun(rs.getInt(2), rs.getTimestamp(3), new Zaposleni (rs.getInt(1), rs.getString(4), rs.getString(5), rs.getString(6)) ));
				
		
			
		} catch (SQLException e) {
			e.printStackTrace();
			MySQLUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			MySQLUtilities.getInstance().close(s, rs);
		}
		
		
		
		return retVal; 
		
	}
	
	@Override
	public boolean dodajRacun(Racun racun)
	{
		
		boolean retVal = true;
		Connection conn = null;
		PreparedStatement ps = null;
		
		String query = "CALL kreiraj_racun(?)";
		
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, racun.getZaposleni().getIdZaposleni());
			

			retVal = ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			MySQLUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			MySQLUtilities.getInstance().close(ps);
		}
		
		
		
		return retVal; 
	}
	
	
	@Override
	public boolean obrisiRacun(Racun racun) {
		
		
		boolean retVal = true;
		Connection conn = null;
		PreparedStatement ps = null;
		
		String query = "CALL obrisi_racun(?)";
		
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1,racun.getIdRacun());
		
			
			retVal = ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			MySQLUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			MySQLUtilities.getInstance().close(ps);
		}
		
		return retVal; 
	}
	
	
	@Override
	public boolean azurirajRacun(Racun racun) {
		
		
		boolean retVal = true;
		Connection conn = null;
		PreparedStatement ps = null;
		
		String query = "CALL azuriraj_racun(?,?)";
		
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1,racun.getIdRacun());
			ps.setInt(2, racun.getZaposleni().getIdZaposleni());
		
			
			retVal = ps.executeUpdate() == 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
			MySQLUtilities.getInstance().showSQLException(e);
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			MySQLUtilities.getInstance().close(ps);
		}
		
		return retVal; 
	}
	
	}
	


