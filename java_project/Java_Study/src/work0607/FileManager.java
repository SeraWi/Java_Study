package work0607;

import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;

public class FileManager {
	Scanner scanner;
	File saveDir;
	File[] newList;

	public FileManager() {
		scanner = new Scanner(System.in);
		saveDir = new File("C:\\javamemo");
	}

	public void viewMemoList() {
		if(!saveDir.exists()) {
			System.out.println("저장 폴더가 존재하지 않아 폴더를 생성합니다.");
			saveDir.mkdir();
		}else {
			newList = saveDir.listFiles();
			//디렉토리의 파일목록(디렉토리포함)을 File배열로 반환
			System.out.println("파일 경로 리스트---------------");
			if(newList.length >0) {
				int cnt = 0;
				for(File file: newList) {
					if(file.isDirectory()) {
						//.isDirectory: 경로에 있는 객체가 디렉토리면 true 리턴
						System.out.println("[DIR]");
					}else if(file.isFile()) {
						System.out.println("[FILE]");
					}
					System.out.println("["+ ++cnt +"] c:\\javamemo"+file.getName());
				}
			}else {
				System.out.println("저장 폴더에 파일이 존재하지 않습니다. ");
			}
			System.out.println("---------------------------------");
		}
	}


	public void moveFile() {
		viewMemoList();

		BufferedWriter out = null;
		System.out.println("이동하고자 하는 파일의 번호를 입력해주세요.");
		String fileNo = scanner.nextLine();
		String child = newList[Integer.parseInt(fileNo)-1].getName();
		File oldFile = new File(saveDir, child);


		System.out.println("이동하고자 하는 폴더 경로를 입력해주세요.");
		String newDirPath = scanner.nextLine();

		File newDir = new File(newDirPath);

		FileTransferThread fileTransferThread = new FileTransferThread(oldFile,newDir,child);
		fileTransferThread.start();
	}
	
	public static void main(String[] args) {

		FileManager memoNote = new FileManager();
		while(true) {
			System.out.println("JAVA File Manager----------");
			System.out.println("1. 파일 목록 보기 2. 파일 이동하기  3. 종료");
			System.out.println("---------------------------");
			System.out.println("원하시는 기능의 번호를 입력하세요.");

			int select = Integer.parseInt(memoNote.scanner.nextLine());
			switch(select) {
			case 1:
				memoNote.viewMemoList();
				break;
			case 2:
				memoNote.moveFile();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}

class FileTransferThread extends Thread{
	File oldFile;
	File newDir;
	String child;
	public FileTransferThread(File oldFile, File newDir, String child) {
		this.oldFile = oldFile;
		this.newDir = newDir;
		this.child = child;
	}
	@Override
	public void run() {
		if(!newDir.exists()) {
			newDir.mkdir();
		}
		File newFile = new File(newDir,child);
		oldFile.renameTo(newFile);
		System.out.println("파일이 이동되었습니다.");
		System.out.println("파일 이동 완료");
	}


}