package data.sql;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Kategorija;
import data.KategorijaDataAccess;

public class KategorijaDataAccessImpl implements KategorijaDataAccess {

	@Override
	public List<Kategorija> Kategorije(String nazivKategorija) {
		List<Kategorija> retVal = new ArrayList<Kategorija>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT * from kategorija "
				+ "WHERE Naziv LIKE ?";
		
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			ps.setString(1,
					MySQLUtilities.getInstance().preparePattern(nazivKategorija));
			rs = ps.executeQuery();

			while (rs.next())
				retVal.add(new Kategorija(rs.getInt("IdKategorija"), rs.getString("Naziv")));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			MySQLUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}
}
