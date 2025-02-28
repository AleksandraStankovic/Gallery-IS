package data.sql;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Zaposleni;
import data.ZaposleniDataAccess;

public class ZaposleniDataAccessImpl implements ZaposleniDataAccess {

	@Override
	public List<Zaposleni> Zaposleni() {
		List<Zaposleni> retVal = new ArrayList<Zaposleni>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String query = "SELECT * from Zaposleni ";
		
		try {
			conn = ConnectionPool.getInstance().checkOut();
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();

			while (rs.next())
				retVal.add(new Zaposleni(rs.getInt("IdZaposleni"), rs.getString("Ime"),rs.getString("Prezime")
						,rs.getString("brojTelefona")));
			System.out.println(retVal);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().checkIn(conn);
			MySQLUtilities.getInstance().close(ps, rs);
		}
		return retVal;
	}
}
