package work0605;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MultichatServer {
	HashMap clients;

	MultichatServer(){
		clients = new HashMap();
		Collections.synchronizedMap(clients);
	}

	public void start() {
		ServerSocket ss = null;
		Socket s = null;

		try {
			ss = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다.");

			while(true) {
				s = ss.accept();
				System.out.println("["+ s.getInetAddress()+":"+s.getPort()+"]"+"에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(s);
				thread.start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
		while(it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MultichatServer().start();

	}



	class ServerReceiver extends Thread{
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		ServerReceiver(Socket socket){
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void run() {
			String name = "";

			try {
				name = in.readUTF();
				sendToAll("#"+name+" 님이 들어오셨습니다.");

				clients.put(name, out);
				System.out.println("현재 서버접속자 수는 "+clients.size()+"입니다.");

				while(in != null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				sendToAll("#"+name+"님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("["+socket.getInetAddress()+":"+socket.getPort()+"]"+"에서 접속을 종료하였습니다.");
				System.out.println("현재 서버접속자 수는"+ clients.size()+"입니다.");
			}
		}
	}
}