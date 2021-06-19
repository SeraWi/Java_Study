package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeptDao {
	//싱글톤 패턴: 어러개의 인스턴스를 성성하지 못하도록 하는 코딩 스타일, 디자인 패턴
	
	//1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스 생성하지 못하도록 막기
	private DeptDao() {
		
	}
	//2. 클래스 내부 에서 인스턴스를 만들고, 외부에서 접근 못하도록 
	static private DeptDao dao = new DeptDao();
	
	//3. 메소드를 통해서 반환 하도록 처리, 외부에서 쓸 수 있는 방법
	public static DeptDao getInstance() {
		return dao;
	}
	
	
	
	
	//1. 전체 데이터 검색 기능 --> READ : SELECT
	// 반환타입은 List<Dept>
	// 매개변수 - Connection 객체: Statement
	
	
	
	
	ArrayList<Dept> getDeptList(Connection conn){
		ArrayList<Dept>list = null;
		
		//데이터 베이스의 Dept테이블 이용
		//select 결과를  ->list 에 저장
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			// 객체 생성
			stmt = conn.createStatement();
			//sql작성
			String sql = " select * from dept order by deptno";
			//결과 받아오기
			rs = stmt.executeQuery(sql); //테이블
			list = new ArrayList<>();
			
			//데이터를 dept객체로 생성 ->list에 저장 (list.add)1
			while(rs.next())
			{
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	
		
		return list;
	}


	//2. Dept 테이블에 데이터 저장하는 메소드
	// INSERT!!
	// 반영횟수로 반환
	
	// 사용자에게 정보 받아서 dept객체로 저장
	
	int insertDept(Connection conn, Dept dept) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		
		try {
			//Sql작성
			String sql = "insert into dept values(dept01_deptno_seq.nextval, ?, ?)";
			//객체 생성
			pstmt = conn.prepareStatement(sql);
			//세팅하기
			pstmt.setString(1,dept.getDname());
			pstmt.setString(2, dept.getLoc());
			
			//결과 받기
			result = pstmt.executeUpdate(); // 실행 횟수로 int 반환
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		
		return result;
	}

	
	// 3. Dept 테이블의 데이터 수정 메소드
	// 반영된 행의 개수 반환
	// 사용자로 부터 데이터를 받아서 처리 ->dept 객체
	
	int editDept(Connection conn, Dept dept) {
		int result = 0;
		
		// 전달 받은 dept객체의 데이터로 dept테이블에 저장 ->결과 값을 반환
		PreparedStatement pstmt = null;
		
		try {

			//sql 작성
			String sql = "update dept set dname =?, loc=? where deptno =?";
			//객체 생성
			pstmt = conn.prepareStatement(sql);
			//세팅
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			//실행
			result = pstmt.executeUpdate(); //실행 횟수로 int 반환
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
		
		return result;
	}

	// 4. dept 테이블의 데이터를 삭제
	// 삭제된 행의 개수를 반환
	// 사용자로부터 deptno를 받아서 처리한다.
	
	int deleteDept(Connection conn, int deptno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		
		try {
			String sql = "delete from dept where deptno =?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, deptno);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
	}

}
