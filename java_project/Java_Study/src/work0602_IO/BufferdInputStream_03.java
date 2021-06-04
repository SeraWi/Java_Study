package work0602_IO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferdInputStream_03 {
	public static void main(String[] args) {
		
		try {
			InputStream in = new FileInputStream("origin.pdf");
			OutputStream out = new FileOutputStream("copy3.pdf");
			
			//필터스트림 생성 -> 기본 스트림이 필요 // 성능 개선
			
			BufferedInputStream fin = new BufferedInputStream(in);
			BufferedOutputStream fout = new BufferedOutputStream(out);
			
			//카피한 데이터의 크기
			int copyByte = 0;
			
			//파일에서 읽어올 바이트 데이터
			int bData = -1; //초기화
			while(true) {//무한 반복, bData != -1로도 가능
				bData = fin.read();
				
				//탈출의 조건: 파일의 모든 데이터를 읽은 경우
				if(bData == -1) {
					break;
				}
				fout.write(bData);
				copyByte++;
			}
			//스트림 닫기
			in.close();
			out.close();
			System.out.println("복사완료!! 복사된 바이트 사이즈: "+copyByte+"byte입니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		} //다형성
		
	}
}
