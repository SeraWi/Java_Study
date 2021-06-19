package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBC_dept_dml_update {
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
		System.out.println("부서 데이터의 수정을 시작합니다.");
		System.out.println("10 dev seoul 형식으로 데이터를 입력해주세요.");
		String input = sc.nextLine();
		
		//" "기준으로 자르기 -> 배열로 만들기
		String [] inputs = input.split(" ");
		
		
		// sql작성
		String sql = "update dept01 set dname =?, loc= ? where deptno=?";
		//객체 만들기
		pstmt  = conn.prepareStatement(sql);
		//세팅하기
		pstmt.setString(1,inputs[1]);
		pstmt.setString(2,inputs[2]);
		pstmt.setInt(3, Integer.parseInt(inputs[0]));
		
		//실행
		int result = pstmt.executeUpdate(); 
		if(result > 0) {
			System.out.println("수정되었습니다.");
		}else {
			System.out.println("찾으시는 부서가 존재하지 않습니다.");
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
