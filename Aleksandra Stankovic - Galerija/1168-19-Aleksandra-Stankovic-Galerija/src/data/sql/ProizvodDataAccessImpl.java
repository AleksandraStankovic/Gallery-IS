package data.sql;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.Kategorija;
import entity.Proizvod;
import java.sql.Statement;
import data.ProizvodDataAccess;


public class ProizvodDataAccessImpl implements ProizvodDataAccess {

	
	
	@Override
	public boolean dodajProizvod(Proizvod proizvod) { 
		
		
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;
		
		String query = "INSERT INTO proizvod VALUES "
				+ "(?, ?, ?, ?) ";
		
		try {
			
			
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, proizvod.getIdProizvod());
			ps.setInt(2, proizvod.getKategorija().getIdKategorija());
			ps.setString(3, proizvod.getIme());
			ps.setFloat(4, proizvod.getCijena());
			
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
	
	
	
	
	@Override 
	public boolean obrisiProizvod(int idProizvod) {
		boolean retVal = false;
		Connection conn = null;
		PreparedStatement ps = null;

		String query = "DELETE FROM proizvod "
				+ "WHERE IdProizvod=? ";
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setInt(1, idProizvod);

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
	public List <Proizvod> pretraga_proizvoda(String Ime)
	{
		List <Proizvod> retVal = new ArrayList <Proizvod>();
		
		Connection conn=null; 
		Statement s= null; 
		PreparedStatement ps = null;
		ResultSet rs=null; 
		
		String query = "SELECT * FROM pregled_proizvoda" 
		+ "WHERE Ime LIKE ?";
		
		try {
			
			conn = ConnectionPool.getInstance().checkOut();
			s = conn.createStatement();
			ps = conn.prepareStatement(query);
			ps.setString(1,
					MySQLUtilities.getInstance().preparePattern(Ime));
			rs = ps.executeQuery();
		
			
		
			
			while (rs.next())
				retVal.add(new Proizvod(rs.getInt(2), new Kategorija (rs.getInt(1), rs.getString(5)),rs.getString(3),rs.getFloat(4)));
			
			
			
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
	public List <Proizvod> Proizvodi()
	{
		List <Proizvod> retVal = new ArrayList <Proizvod>();
		
		Connection conn=null; 
		Statement s= null; 
		ResultSet rs=null; 
		
		String query = "SELECT * FROM proizvod NATURAL JOIN kategorija";
		
		try {
			
			conn = ConnectionPool.getInstance().checkOut();
			s = conn.createStatement();
			rs=s.executeQuery(query);
			
		
			
			
			while (rs.next())
				retVal.add(new Proizvod(rs.getInt(2), new Kategorija (rs.getInt(1), rs.getString(5)),rs.getString(3),rs.getFloat(4)));
			
			
			
			
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
	public boolean azurirajProizvod(Proizvod proizvod) {
		
		boolean retVal = true;
		Connection conn = null;
		PreparedStatement ps = null;
		
		String query = "CALL azuriraj_proizvod(?,?,?, ?)";
		
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			
			ps.setInt(1,proizvod.getIdProizvod());
			ps.setInt(2, proizvod.getKategorija().getIdKategorija());
			ps.setString(3, proizvod.getIme());
			ps.setFloat(4, proizvod.getCijena());
			
		
			
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
	




