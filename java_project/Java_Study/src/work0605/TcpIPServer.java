package work0605;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpIPServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket socket = null;

		try {
			//서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다
			ss = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다.");

			socket = ss.accept();

			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);

			sender.start();
			receiver.start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
class Sender extends Thread{
	Socket socket;
	DataOutputStream out;
	String name;

	Sender(Socket socket){
		try {
			out = new DataOutputStream(socket.getOutputStream());
			name = "["+socket.getInetAddress()+":"+socket.getPort()+"]";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(out != null) {
			try {
				out.writeUTF(name+scanner.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

class Receiver extends Thread{
	Socket socket;
	DataInputStream in;

	Receiver(Socket socket){
		this.socket = socket;

		try {
			in = new DataInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run() {
		while(in!=null) {
			try {
				System.out.println(in.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}