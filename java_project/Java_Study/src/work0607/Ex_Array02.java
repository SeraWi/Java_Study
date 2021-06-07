package work0607;

public class Ex_Array02 {
	public static void main(String[] args) {
		//45개의 정수값을 저장하기 위한 배열 생성
		int[] ball = new int[45];
		//배열에 각 요소 1~45 의 값을 저장한다.
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i+1;
		}
		int temp =0;//두 값을 바꾸는데 사용할 임시변수
		int j =0; // 임의의 값을 얻어서 저장할 변수
		
		for(int i= 0; i<100; i++) {
			j = (int)(Math.random()*45);
			temp = ball[0];
			ball[0] = ball[j];
			ball[j] = temp;
		}
		
		for(int i = 0; i<6; i++) {
			System.out.print(ball[i]+" ");
		}
	}
}
