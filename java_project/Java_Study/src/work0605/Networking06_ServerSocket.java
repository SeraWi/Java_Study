package work0605;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Networking06_ServerSocket {
	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("서버실행!");
			Socket socket = serverSocket.accept();//연결 요청 올때까지 대기
		
			if(socket != null) {
				System.out.println("서버 접속 완료");
			}
			
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			
			dout.writeUTF("Hi~!!Client Message");
			dout.flush();
			dout.close();
			socket.close();
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
