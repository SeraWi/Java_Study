package work0605_Quiz;

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
	Scanner scanner;
	File saveDir;
	File[] newList;

	//생성장
	public MemoNote() {
		scanner = new Scanner(System.in);
		saveDir = new File("c:\\javamemo");
	}

	public void viewMemoList() {
		if(!saveDir.exists()) {
			System.out.println("저장 폴더가 존재하지 않아 폴더를 생성합니다.");
			saveDir.mkdir();
		}else {
			newList = saveDir.listFiles();

			System.out.println("메모리스트=============");
			if(newList.length > 0) {//리스트에 파일 하나 이상
				int cnt = 0;
				for( File file : newList) {
					if(file.isDirectory()) {

					}else if(file.isFile()) {

					}
					System.out.println("["+ ++cnt +"]");
				}
			}else {// newList.length = 0;
				System.out.println("저장 폴더에 파일이 존재하지 않습니다.");
			}
			System.out.println("======================");
		}

	}
	public void writeMemo() {
		BufferedWriter out = null;


		try {
			System.out.println("제목을 입력해주세요");
			String subject = scanner.nextLine();

			System.out.println();

			System.out.println("메모내용을 입력해주세요.");
			String memo = scanner.nextLine();

			Date now = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-hh-mm-dd");

			String writeDate = format.format(now);
			System.out.println(writeDate);

			String newFileName = writeDate +"_"+subject;
			out = new BufferedWriter(new FileWriter(new File(saveDir,newFileName+".txt")));

			System.out.println(subject);
			System.out.println(memo);
			out.write(subject);
			out.newLine();
			out.newLine();
			out.write(writeDate);
			out.newLine();
			out.newLine();
			out.write(memo);
			out.close();
			System.out.println("Memo 입력 완료,");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void viewMemo() {
		viewMemoList();
		System.out.println("파일의 번호를 입력해주세요.");

		int select = Integer.parseInt(scanner.nextLine());
		String fileName = newList[select-1].getName();
		File viewFile = new File(saveDir,fileName);

		BufferedReader in = null;
		String str = null;
		System.out.println("파일 읽기===============");
		try {
			in = new BufferedReader(new FileReader(viewFile));
			while(true) {
				str = in.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
			System.out.println("======================");
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
