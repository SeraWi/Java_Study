package work0605;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Networking01 {
	public static void main(String[] args) {
		
		String urlstr = "www.naver.com";
		
		try {
			InetAddress ip = InetAddress.getByName(urlstr);
			System.out.println("호스트의 이름 :" + ip.getHostName());//호스트의 이름 :www.naver.com
			System.out.println("IP address: " +ip.getHostAddress());//IP address: 223.130.195.200
			
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		}
	}
}
