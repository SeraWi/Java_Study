package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_dept_dml_create {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			//2. 데이터베이스에 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw ="tiger";
			
			conn = DriverManager.getConnection(jdbcUrl,user,pw);
			System.out.println("데이터베이스에 연결 성공");
			
			
			//트렌젝션 설정
			// default 는 자동 커밋
			conn.setAutoCommit(false);//true는 자동커밋
			
			
			//사용자에게 정보 받기
			System.out.println("부서 정보 입력을 시작합니다.");
			System.out.println("부서 이름을 입력해주세요.");
			String dname = sc.nextLine();
			System.out.println("부서 위치를 입력해주세요.");
			String loc =sc.nextLine();
			
			// 3. SQL 처리
			
			String sql = "insert into dept01 values(dept01_deptno_seq.nextval,?, ?)";
			pstmt  = conn.prepareStatement(sql);
			
			pstmt.setString(1,dname);
			pstmt.setString(2,loc);
			
			int result = pstmt.executeUpdate(); //반영된 갯수를 반환한다.
			
			if(result > 0) {
				System.out.println("입력되었습니다.");
			}else {
				System.out.println("입력 실패!");
			}
			//트렌젝션 완료(성공)
			conn.commit();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이브 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("데이테베이스 연결 실패");
			e.printStackTrace();
		}
		
	}
}
