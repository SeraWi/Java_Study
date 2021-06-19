package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * JDBC : 자바애플리케이션에서 표준화된 데이터베이스 접근 제공
 * 이론적으로는 개발된 애플리케이션에서 DB 변경시 JDBC 드라이버만 교체하면 됨
 * 
 * Statment 객체 이용 ->READ : SELECT
 */
public class JdbcTest {
	public static void main(String[] args) {
		
		// 연결 객체 : 연결 정보를 가진다.
		Connection conn = null;
		// SQL 실행할 메소드 제공(2가지 있다)
		Statement stmt = null;
		//executeQuery() 반환타입 ->select의 결과 (테이블)를 담는 객체 -> ResultSet
		ResultSet rs = null;
		// PreparedStatment객체
		PreparedStatement pstmt = null;
		
		
		try {
			// 1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			
			// 2. 연결 ->연결객체 : Connection :연결 정보를 가진다.
			String jdbcUrl =  "jdbc:oracle:thin:@localhost:1521:xe";
			String user  ="hr";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결 성공!!");
			
			//3. SQL 처리 
			// Statment 객체 -> SQL 문 처리
			
			//객체 먼저 만들고
			stmt = conn.createStatement(); 
			//SQL 문 작성
			String sqlSelect = "select *from dept order by dname";
			
			//데이블의 데이터 읽어오는 방법 ->ResultSet 객체 필요
			rs = stmt.executeQuery(sqlSelect); //결과가 테이블
			
			//rs.next() ->다음행의 존재 유무 확인, boolean 타입 반환
			// READ : SELECT
			while(rs.next()) {
				int deptno = rs.getInt("deptno"); //컬럼명
				System.out.print(deptno + "\t");
				String dname = rs.getString("dname");
				System.out.print(dname + "\t");
				String loc = rs.getString("loc");
				System.out.println(loc + "\t");
				
			}
//-------------------------------------------------------------------------------------
			// 2번째 방법
			// preparedStatemnet 객체 -> Statement 객체 성능 개선
			
			System.out.println("PreparedStatement 사용");
			System.out.println("----------------------------");
			
			//Sql먼저 등록
			String sqlSelect2 = "select * from dept where deptno = ?";
			
			//객체 생성 해서 sql전달
			pstmt = conn.prepareStatement(sqlSelect2);
			// ?변수에 데이터 바인딩
			pstmt.setInt(1, 10); //첫번째 ? =1 , deptno = 10
			
			
			rs = pstmt.executeQuery(); // 실행하고 결과 가져온다.
			while(rs.next()) {
				int deptno = rs.getInt("deptno"); //컬럼명
				System.out.print(deptno + "\t");
				String dname = rs.getString("dname");
				System.out.print(dname +"\t");
				String loc = rs.getString("loc");
				System.out.println(loc +"\t");
			}
			
			
			
			
			
		} catch (ClassNotFoundException e) { // Driver load 에러
			// TODO Auto-generated catch block
			System.out.println("드라이버 클래스를 찾지 못함!");
			e.printStackTrace();
		} catch (SQLException e) { // Connection 에러
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("데이터 베이스 연결 실패");
		} finally {
			if(conn != null) {
				try {
					conn.close();
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
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}
}
