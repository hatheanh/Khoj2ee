package chucnangqlkho;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class KhoDAO {
	private String url;
	private String user;
	private String pass;
	Connection con = null;

	public KhoDAO(String _url, String _user, String _pass) {
		url = _url;
		user = _user;
		pass = _pass;
	}

	public void  openConnection() throws SQLException {
		if (con == null || con.isClosed()) {
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	}

	public void closeConnec() throws SQLException {
		if (con != null || !con.isClosed()) {
			con.close();
		}
	}

	public boolean insertKho(Kho kho) throws SQLException {
		openConnection();
		String sql = "insert into kho1 (id,tenkho,diadiem) value (?,?,?)";
		PreparedStatement prstatement = con.prepareStatement(sql);
		prstatement.setInt(1, kho.getId());
		prstatement.setString(2, kho.getTenkho());
		//prstatement.setString(4, kho.getTenhang());
		prstatement.setString(3, kho.getDiadiem());
		boolean insertrow = prstatement.executeUpdate() != 0;
		prstatement.close();
		con.close();
		return insertrow;
	}

	public List<Kho> getAllKho() throws SQLException {
		String sql = "select * from kho1";
		
		List list = new ArrayList<>();
		openConnection();
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while (rs.next()) {
			int id = rs.getInt("id");
			String tenkho = rs.getString(2);
			//String tenhang = rs.getString(3);
			String diadiem = rs.getString(3);
			Kho kho = new Kho(id,tenkho,diadiem);
			list.add(kho);
		}
		rs.close();
		statement.close();
		con.close();
		return list;
	}

	public boolean updateK(Kho k) throws SQLException {
		String sql = "update kho1 set tenkho=?,diadiem=? where id=? ";
		openConnection();
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setInt(3, k.getId());
		pr.setString(1,k.getTenkho());
		pr.setString(2, k.getDiadiem());
		//pr.setString(3, k.getTenhang());
		
		boolean updateok = pr.executeUpdate() > 0;
		pr.close();
		con.close();
		return updateok;
	}

	public boolean deleteKho(Kho kho) throws SQLException {
		String sql = "delete from kho1 where id=?";
		openConnection();
		PreparedStatement pr = con.prepareStatement(sql);
		pr.setInt(1, kho.getId());
		boolean deleteok = pr.execute();
		pr.close();
		con.close();
		return deleteok;

	}
	public  Kho getKho(int id) throws SQLException {
		openConnection();
		Kho kho=null;
		String sql="select * from kho1 where id=?";
		PreparedStatement pr =con.prepareStatement(sql);
		pr.setInt(1,id);
		ResultSet rs=pr.executeQuery();
		while(rs.next()) {
			String tenkho=rs.getString(2);
			//String tenhang=rs.getString(3);
			String diadiem=rs.getString(3);
			kho=new Kho(id,tenkho,diadiem);
		}
		System.out.println(kho.getId());
		return kho;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
