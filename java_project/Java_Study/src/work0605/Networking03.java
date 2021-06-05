package work0605;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Networking03 {
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.google.com/");
			
			//URLConnection: url.openConnection()
			
			URLConnection con = url.openConnection();
			InputStream in = con.getInputStream();
			
			int i = 0; //받을 데이터
			while(true) {
				i= in.read();
				if(i == -1) {
					break;
				}
				System.out.print((char)i);
			}
					
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
}
