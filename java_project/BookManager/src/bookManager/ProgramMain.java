package bookManager;

public class ProgramMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BookManager manager = new BookManager(BookDao.getInstance());
		
		manager.bookList();
		
	}

}
