/*
10개의 수를 입력 받아, 평균값을 출력하는 프로그램을 작성하라.
(소수점 첫째 자리에서 반올림한 정수를 출력한다.)
 */

import java.util.Scanner;
import java.io.FileInputStream;

public class D1_2071 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/examples/D1_2071.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			// int가 아닌 float으로 합계를 둔 이유: 소수점 첫째 자리에서 반올림한 정수를 출력하는게 우리의 목표이다. 즉 소수점이 있는 실수로 나누어야된다.
			// 변수의 자료형이 float인 변수 sum에 데이터타입이 int인 상수 0을 대입, 이 때 int가 float으로 자동 형변환된다.
			// 생활코딩 형변환 내용 참고
			float sum = 0;
			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				sum = sum + num;
			}
			System.out.println("#" + test_case + " " + Math.round(sum/10)); // Math.round(): 실수의 소수점 첫번째 자리를 반올림하여 정수로 리턴
		}
	}

}
