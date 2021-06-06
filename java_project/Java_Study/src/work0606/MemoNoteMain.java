package work0606;

import java.util.Scanner;

public class MemoNoteMain {
	public static void main(String[] args) {
		MemoNote memo = new MemoNote();
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("메모기능==============");
		System.out.println("1. 메모 읽기  2. 메모 쓰기");
		int select = Integer.parseInt(scanner.nextLine());
		
		switch(select) {
		case 1: 
			memo.memoRead();
			break;
		case 2:
			memo.makeDir();
			memo.memoWrite();
			break;
		}
	}
}
