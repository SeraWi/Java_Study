package work0531_Interface02;

public class PointTwo {
	private int xPos, yPos;
	PointTwo(int x, int y){
		xPos = x;
		yPos = y;
	}
	public String toString() {
		String posInfo ="[x pos:"+xPos+"y pos: "+ yPos+"]";
		return posInfo;
	}
}
