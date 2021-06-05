package work0605;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class Networking04 {
	public static void main(String[] args) {
		String urlStr = "https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=105&oid=008&aid=0004597284";
		
		try {
			URL url = new URL(urlStr);
			URLConnection hcon = url.openConnection();
			
			for(int i = 1; i <=8; i++) {
				System.out.print(hcon.getHeaderFieldKey(i));
				System.out.println(":"+ hcon.getHeaderField(i));
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
