package work0531_Interface;

interface Movable{
	void move(int x, int y);
}
interface Attackable{
	void attack(int x, int y);
}
interface Fightable extends Movable, Attackable{
	
}

class Unit{
	int currentHP;
	int x;
	int y;
}
class Fighter extends Unit implements Fightable{

	@Override
	public void move(int x, int y) {
		System.out.println( x+ y);
	}

	@Override
	public void attack(int x, int y) {
		System.out.println(x * y);
	}
}


public class FighterTest {
	public static void main(String[] args) {
		Fighter f= new Fighter();
		
		if(f instanceof Unit) {
			System.out.println("f는 Unit클래스의 자손입니다.");
		}
		if(f instanceof Fightable) {
			System.out.println("f는 Fightable 인터페이스를 구현했습니다.");
		}
		if(f instanceof Attackable) {
			System.out.println("f는 Attackable 인터페이스를 구현했습니다.");
		}
		if(f instanceof Movable) {
			System.out.println("f는 Movable 인터페이스를 구현했습니다.");
		}
		if(f instanceof Object) {
			System.out.println("f는 Object 클래스의 자손입니다. ");
		}
	}
}






