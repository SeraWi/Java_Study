package work0605;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpIPClient {

	public static void main(String[] args) {
		
		//소켓 생성하여 연결 요청한다. 
		try {
			String serverIp ="127.0.0.1";
			Socket socket = new Socket(serverIp, 7777);
			
			System.out.println("서버에 연결되었습니다.");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
