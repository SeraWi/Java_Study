package work0606;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MemoNote {
	//Memo dir 생성하기 MakeDir()
	//메모 쓰기 -> 파일로 저장하기 memoWrite(), BufferedWriter,FileWriter
	//메모 리스트 보기 memoList()
	//메모 읽기 memoRead()
	File saveDir;

	public void makeDir() {
		saveDir = new File("C:\\MyMemo");

		//디렉토리 없으면 생성하기
		if(!saveDir.exists()) {
			saveDir.mkdir();
			System.out.println("디렉토리를 생성했습니다.");
		}
	}

	public void memoWrite() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("메모를 작성합니다.");
		System.out.println("-----------------------");
		System.out.println("메모의 제목을 입력해주세요.");
		String memoTitle = scanner.nextLine();
		System.out.println("메모의 내용을 입력해주세요.");
		String memoContent = scanner.nextLine();

		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/mm/dd");

		String fileName = memoTitle + date.format(today)+".txt";

		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("C:\\MyMemo"+File.separator+fileName));
			out.write("MyMemo-------------------");
			out.newLine();
			out.write(memoTitle);
			out.newLine();
			out.write(memoContent);
			out.close();
			System.out.println("메모 작성을 완료합니다.");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void memoRead() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("파일리스트를 읽어오겠습니다.");
		System.out.println("메모리스트===============");
		
		File f = new File("C:\\MyMemo");
		String[] filenames = f.list();
		for( int i= 0; i< filenames.length; i++) {
			System.out.println(filenames[i]);
		}
		
		System.out.println("파일 제목을 입력하세요");
		String fileName = scanner.nextLine();
		System.out.println("파일 읽기===============");
		try {
			BufferedReader in = new BufferedReader(new FileReader("C:\\MyMemo"+File.separator+fileName));
			while(true) {
				String str = in.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
			System.out.println("=======================");
			in.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
