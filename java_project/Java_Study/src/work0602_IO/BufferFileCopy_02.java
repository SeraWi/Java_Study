package work0602_IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferFileCopy_02 {
	public static void main(String[] args) {
		try {
			InputStream in = new FileInputStream("origin.pdf");
			OutputStream out = new FileOutputStream("copy2.pdf");
			
			int copyByte = 0;
			
			//파일에서 읽어올 바이트 데이터 배열
			byte[] buf = new byte[1024];
			
			//읽어온 데이터 배열의 개수
			int readLen = 0;
			
			while(true) {
				readLen = in.read(buf);
				
				//탈출의 조건: 파일의 모든 데이터를 읽은 경우
				if(readLen == -1) {
					break;
				}
				
				//출력: 파일에 데이터를 쓴다!
				out.write(buf,0,readLen);
				copyByte +=readLen;
			}
			in.close();
			out.close();
			System.out.println("복사 완료! 복사된 데이터 사이즈: "+ copyByte+ " byte 입니다.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
