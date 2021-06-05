package work0605;

import java.net.MalformedURLException;
import java.net.URL;

public class Networking02 {
	public static void main(String[] args) {
		String urlStr = "https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=105&oid=008&aid=0004597284";
	
		URL url;
		try {
			url = new URL(urlStr);
			System.out.println("Protocol: "+url.getProtocol());
			System.out.println("Host name:"+url.getHost());
			System.out.println("Port name: "+url.getPort());
			System.out.println("Default Port number: "+url.getDefaultPort());
			System.out.println("query: "+url.getQuery());
			System.out.println("Path: "+ url.getPath());
			System.out.println("File: "+ url.getFile());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
