package bookManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BookManager {
	
	private BookDao dao;
	private Scanner sc;
	
	BookManager(BookDao dao){
		this.dao = dao;
		sc = new Scanner(System.in);
	}
	
	// 1. ArrayList로 받은 도서 리스트 출력하기
	
	void bookList() {
		//Connection
		Connection conn = null;
		
		//연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user ="hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl,user, pw);
			List<Book> list = dao.getBookList(conn);
			
			
			System.out.println("도서 리스트");
			System.out.println("----------------------------------------");
			System.out.println("도서 아이디 \t 도서이름 \t\t 출판사\t 도서가격 \t");
			System.out.println("----------------------------------------");
			
			for(Book book: list) {
				System.out.printf("%d\t %s\t\t  %s \t %d\n",
						book.getBookid(),book.getBookname(),book.getPublisher(),book.getPrice());
			}
			System.out.println("----------------------------------------");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
