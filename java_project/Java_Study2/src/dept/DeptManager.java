package dept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DeptManager {
	private DeptDao dao;
	private Scanner sc;
	
	public DeptManager(DeptDao dao) {
		this.dao = dao;
		sc = new Scanner(System.in);
					
	}
	
	
	//전체 리스트 출력 메소드
	//DeptDao에서 데이터 리스트를 받고 출력 처리
	
	void deptList() {
		//connection 객체 생성
		Connection conn = null;
		
		//연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="hr";
		String pw = "tiger";
		
		try {
			conn =DriverManager.getConnection(jdbcUrl,user, pw);
			List<Dept> list = dao.getDeptList(conn);
			
			System.out.println("부서 정보 리스트");
			System.out.println("--------------------------------------------");
			System.out.println("부서번호 \t 부서이름 \t 위치");
			System.out.println("--------------------------------------------");
			
			
			for(Dept dept : list) {
				System.out.printf("%d \t %s \t %s \n",
						dept.getDeptno(),dept.getDname(),dept.getLoc());
			};
			System.out.println("--------------------------------------------");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//데이터 입력
	//사용자에게 Scanner 클래스로 입력받아 저장 ->dao inserDept()메소드로 저장
	void inputData() {
		// connection 객체 생성
		Connection conn = null;
		
		//연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl,user, pw);
			
			System.out.println("부서 정보를 입력합니다.");
			System.out.println("부서이름 부서위치 형식으로 입력해주세요.");
			System.out.println("예시 ) dev seoul");
			String inputData = sc.nextLine();
			String [] deptdata= inputData.split(" ");
			
			Dept dept = new Dept(0, deptdata[0],deptdata[1]);
			
			int result = dao.insertDept(conn, dept);
			
			if(result > 0) {
				System.out.println("입력되었습니다.");
			}else {
				System.out.println("입력 실패!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	
	
}
