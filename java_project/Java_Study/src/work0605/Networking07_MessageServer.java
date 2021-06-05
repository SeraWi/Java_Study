package work0605;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Networking07_MessageServer {
	
	// 서버에서 클라이언트 접속 요청
	// 클라이언트가 요청 수락
	// 클라이언트가 먼저 메시지 남김
	// 서버측에 메시지 뜬다
	// 서버측에서 메시지 보냄
	// 서버측 메시지 클라이언트에게 보내짐
	
	
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s= null;
		DataInputStream din = null;
		DataOutputStream dout = null;
		
		try {
			ss = new ServerSocket(8888);
			System.out.println("서버실행");
			System.out.println("---------------------");
			s = ss.accept();
			System.out.println("Client 접속");
			System.out.println("----------------------");
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			Scanner sc  = new Scanner(System.in);
			
			String str1 = null; //받는 메시지
			String str2 = ""; //보내는 메시지
			
			while(!str2.equals("exit")){
				str1 = din.readUTF();
				System.out.println("Client Message : "+str1);
				
				str2 = sc.nextLine();
				dout.writeUTF(str2);
				dout.flush();
				
			}
		} catch (IOException e) {

			e.printStackTrace();
		}finally {
			Networking09_Util.close(dout);
			Networking09_Util.close(din);
			Networking09_Util.close(s);
			Networking09_Util.close(ss);
			
		}
		
	}
}
