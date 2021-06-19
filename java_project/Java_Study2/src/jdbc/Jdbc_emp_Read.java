package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc_emp_Read {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!");
			
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user ="hr";
			String pw = "tiger";
						
			conn = DriverManager.getConnection(jdbcUrl,user,pw);
			System.out.println("데이터베이스 연결 성공!");
			

			stmt = conn.createStatement();
			String sql = 
			"select e.empno, e.ename, e.job, e.sal, d.dname,d.loc from emp e, dept d where e.deptno = d.deptno";
			
			rs= stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t" // empno
						+ rs.getString(2)+"\t" // ename
						+ rs.getString(3)+"\t" // job
						+rs.getInt(4)+"\t"     // sal
						+ rs.getString(5)+"\t" // dname
						+rs.getString(6));      // loc
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로드 실패!");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
