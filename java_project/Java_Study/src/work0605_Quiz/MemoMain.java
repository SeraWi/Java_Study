package work0605_Quiz;

public class MemoMain {
	public static void main(String[] args) {
		MemoNote memoNote = new MemoNote();
		
		while(true) {
			System.out.println("Java Memp==================");
			System.out.println("1.메모 목록 보기 2.메모 등록 3. 메모 보기 4. 종료");
			System.out.println("원하시는 기능의 번호를 입력하세요.");
			
			
			int select = Integer.parseInt(memoNote.scanner.nextLine());
			switch(select) {
			case 1:
				memoNote.viewMemoList();
				break;
			case 2:
				memoNote.writeMemo();
				break;
			case 3: 
				memoNote.viewMemo();
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
