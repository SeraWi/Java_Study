package work0602_IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriter_06 {

	public static void main(String[] args) {
		
		
		try {
			//성능개선, 필터 스트림
			BufferedWriter out = new BufferedWriter(new FileWriter("String.txt"));
			System.out.println("쓰기 시작");
			out.write("손흥민 - 안녕하세요!");
			out.write("반값습니다.");
			out.newLine();
			out.write("2021.06.02");
			out.newLine();
			out.write("손흥민 작성");
			
			out.close();
			System.out.println("작성완료");
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
