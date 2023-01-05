import java.util.Scanner;
import java.io.FileInputStream;

public class D2_1204 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/examples/D2_1204.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int noUse = sc.nextInt(); // 1, 2, 3 테스트케이스 번호 입력
			int[] oneTohund = new int[101]; // 1~100점
			for (int std = 0; std < 1000; std++) { // 1000명의 학생
				int num = sc.nextInt();
				oneTohund[num] += 1; // 배열값에 해당 점수를 받은 학생수 입력
			}
			int max = 0;	// 최빈수
			int count = 0;	// 1~100점
			int maxidx = 0; // 최빈수인 점수
			for (int i : oneTohund) { // 1~100점까지 돌면서
				if (max <= i) {		// 점수를 받은 사람 명수가 max보다 크거나 "같으면"
					max = i; // 최빈수 i로 업데이트
					maxidx = count; // 최빈수의 인덱스는 몇번인지 -> 즉 최빈수는 무슨 수인지를 maxidx에 저장
				}
				count++; // 점수 올리기 즉 몇번째 배열인지 확인하기 위함
			}
			System.out.println("#" + test_case + " " + maxidx);
		}

	}

}
