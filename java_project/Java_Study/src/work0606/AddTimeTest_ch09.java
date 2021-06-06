package work0606;

public class AddTimeTest_ch09 {
	//1~100,000,000까지 더하기하는 
	//연산의 실행 시간을 측정하는 프로그램을 만들어봅시다.
	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		int sum = 0;
		for(int i= 0; i<=100000000; i++) {
			sum += i;
		}
		System.out.println(sum);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
