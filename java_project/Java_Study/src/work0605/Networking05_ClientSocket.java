package work0605;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Networking05_ClientSocket {
	public static void main(String[] args) {
		//SocketServer의 IP와 Port번호로 연결 신청:Socket객체를 생성
		
		Socket socket;
		try {
			socket = new Socket("localhost",9999);
			
			if(socket != null) {
				System.out.println("클라이언트의 접속 요청: Socket 생성");
			}
			
			DataInputStream din = new DataInputStream(socket.getInputStream());
			String msg = din.readUTF();
			System.out.println(msg);
			
			din.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
