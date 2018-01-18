package conf;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;

public class Exam {

	public void init() {
		InputStream in = this.getClass().getResourceAsStream("/conf/dbconf.properties");
		Properties prop = new Properties();
		//key랑 value를 가지고 있는데 설정안해주면 value에는 빈문자열 들어가염
		try {
			prop.load(in);
			Iterator<Object> it = prop.keySet().iterator();
			//key를 가지고 있는 리스트 형식(리스트는 아님). key를 뽑아줌. 뭐가 들어올지 모르니까 object
			Class.forName(prop.getProperty("driver"));
			String url = prop.getProperty("url");
			String id = prop.getProperty("id");
			String pwd = prop.getProperty("pwd");
			Connection con = DriverManager.getConnection(url,id,pwd);
			System.out.println("연결성공");
			String sql="select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				System.out.println(rs.getString("customerName"));
			}
			/*while(it.hasNext()) {
				String key = (String) it.next();
				System.out.println(key+" = "+prop.getProperty(key));
			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Exam e = new Exam();
		e.init();
	}
}
