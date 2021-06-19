package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_dept_dml_delete {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
		//1. 드라이버 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로드 성공");
		
		// 2. 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";

		conn= DriverManager.getConnection(jdbcUrl, user, pw);
		System.out.println("데이터베이스 연결 성공!!");
		
		// 트렌젝션 설정
		conn.setAutoCommit(false);
		
		//3. sql처리
		// 사용자에게 정보를 받아 데이터를 삭제
		System.out.println("부서 정보의 삭제를 시작합니다.");
		System.out.println("부서 번호를 입력해주세요");
		String deptno = sc.nextLine();
		
		//sql 작성
		String sql = "delete dept01 where deptno = ?";
		//객체 생성
		pstmt = conn.prepareStatement(sql);
		//세팅하기
		pstmt.setInt(1, Integer.parseInt(deptno));
		
		int result = pstmt.executeUpdate();
		
		if(result>0) {
			System.out.println(result + "행이 삭제되었습니다.");
		}else {
			System.out.println("조건에 맞는 데이터가 없습니다.");
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
