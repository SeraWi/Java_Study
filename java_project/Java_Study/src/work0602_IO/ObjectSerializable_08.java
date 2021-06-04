package work0602_IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ObjectSerializable_08 {

	public static void main(String[] args) {
		
		try {
			ObjectOutputStream  out = new ObjectOutputStream(new FileOutputStream("Object.ser"));
			
			out.writeObject(new Circle(1,1,2.4));
			out.writeObject(new Circle(3,5,5.4));
			out.writeObject(new Circle(4,7,3.4));
			out.writeObject("Hello");
			
			ArrayList <Circle> list = new ArrayList<>();
			list.add(new Circle(1,1,2.4));
			list.add(new Circle(3,5,5.4));
			list.add(new Circle(4,7,3.4));
			list.add(new Circle(1,1,2.4));
			list.add(new Circle(1,1,2.4));
			out.writeObject(list);
			
			out.close();
			System.out.println("인스턴스 저장 완료");
			
			//인스턴스 복원
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("Object.ser"));
			
			//복원순서는 저장순서에 맞게 복원해야 한다.
			Circle c1 = (Circle) in. readObject();
			Circle c2 = (Circle) in. readObject();
			Circle c3 = (Circle) in. readObject();
			String str = (String) in. readObject();
			
			System.out.println("복원된 인스턴스의 데이터를 출력");
			
			c1.showData();
			c2.showData();
			c3.showData();
			System.out.println(str);
			
			ArrayList<Circle> list2 = (ArrayList<Circle>) in.readObject(); //복원
			for(Circle circle: list2) { //출력
				System.out.println(circle); // toString 반환
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
class Circle implements Serializable{
	
	//implements SErializable : 직렬화 대상임을 의미, 마킹
	int x;
	int y;
	//transient double r; 저장대상이 되지 않는다 -> 초기값으로 들어감
	double r;
	
	public Circle(int x, int y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}
	public void showData() {
		System.out.println("원점 ["+x+","+"]");
		System.out.println("반지름 : "+r);
		
	}
	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", r=" + r + "]";
	}
}





