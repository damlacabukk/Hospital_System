package package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HospitalDb {

	public Connection getConnected() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","1234");
	}
	
	public ResultSet getHospitals() throws SQLException {
		Statement st = getConnected().createStatement();
		ResultSet rs = st.executeQuery("select * from hospital");
		return rs;
	}
	
	public void saveHospital(Hospital h) throws SQLException {
		String query = "insert into hospital values(?,?,?,?,?)";
		PreparedStatement ps = getConnected().prepareStatement(query);
		ps.setInt(1, h.gethId());
		ps.setString(2, h.getName());
		ps.setString(3, h.getDepartment());
		ps.setString(4, h.getLocation());
		ps.setString(5, h.getCategory());
		ps.executeUpdate();
	}
	
	public void deleteHospital(int hId) throws SQLException {
		String query = "delete from hospital where hId=?";
		PreparedStatement ps = getConnected().prepareStatement(query);
		ps.setInt(1, hId);
		ps.executeUpdate();
	}
}
