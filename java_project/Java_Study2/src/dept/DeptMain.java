package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DeptMain {
	public static void main(String[] args) {
		
		Connection conn = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			
			// 2.연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";
			
			conn = DriverManager.getConnection(jdbcUrl,user,pw);
			System.out.println("데이터 베이스 연결 성공");
			
			DeptDao dao = DeptDao.getInstance();
//-------------------------------------------------------------------
			// READ : SELECT
			
			List<Dept>list = dao.getDeptList(conn);
			
			for(Dept dept : list) {
				System.out.println(dept);
			
			}
//-----------------------------------------------------------------------
			//CREATE : INSERT
			System.out.println("부서 입력을 시작합니다.");
			System.out.println("부서번부 부서이름 부서위치 순으로 입력해주세요");
			System.out.println("예) 50 dev seoul");
			String deptData = sc.nextLine();
			
			//" "기준으로 잘라서 dept객체로 만들기
			String [] deptDatas = deptData.split(" ");
			Dept dept = new Dept(Integer.parseInt(deptDatas[0]), deptDatas[1],deptDatas[2]);
			
			//dao 메소드 호출
			int result = dao.insertDept(conn, dept);
			if(result > 0) {
				System.out.println("입력 성공");
			}else {
				System.out.println("입력 실패!");
			}
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
