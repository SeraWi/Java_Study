package bookManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BookDao {
	//싱글톤 패턴
	
	//생성자 ->외부에서 접근 불가 private
	private BookDao(){
		
	}
	
	static private BookDao dao = new BookDao();  //인스턴스 생성, 외부 접근 불가 private
	
	//메소드 통해서 반환, 외부에서 쓸 수 있다.
	public static BookDao getInstance() {
		return dao;
	}
	
	
	// 1.전체 도서 리스트 

	ArrayList<Book> getBookList(Connection conn){
		ArrayList<Book> list = null;
		
		//DB에 book 테이블 select결과를 list로 저장
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			
			
			String sql = "select * from book order by bookid";
			
			//결과 받아오기
			rs = stmt.executeQuery(sql);
			list = new ArrayList<>();
			
			// DB데이터를 Book객체로 ->list에 저장
			while(rs.next()) {
				list.add(new Book(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getInt(4)));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if( rs != null) {
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
	
	
	// 2. 도서 입력하기
}
