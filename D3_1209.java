import java.util.Scanner;
import java.io.FileInputStream;

public class D3_1209 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/examples/D2_1209.txt"));
		Scanner sc = new Scanner(System.in);
		int T;

		for (int test_case = 1; test_case <= 10; test_case++) {
			T = sc.nextInt(); // 의미없는 입력 : 이미 test_case에서 1~10으로 다 설정해놨기때문에
			{
				int[][] arr = new int[100][100];

				int rowsum = 0; // 행의 합
				int colsum = 0; // 열의 합
				int leftcrosssum = 0; // 왼쪽 대각선 합
				int rightcrosssum = 0; // 오른쪽 대각선 합
				int max = 0; // 최종 합

				for (int i = 0; i < 100; i++) {
					for (int j = 0; j < 100; j++) {
						arr[i][j] = sc.nextInt(); // 배열에 값 입력
					}
				}

				for (int i = 0; i < 100; i++) {
					leftcrosssum += arr[i][i]; // 왼쪽 대각선 합
					rightcrosssum += arr[i][99 - i];// 오른쪽 대각선 합
					rowsum = 0; // 다음줄로 넘어가면 행의 합 다시 0으로 초기화
					colsum = 0; // 다음줄로 넘어가면 열의 합 다시 0으로 초기화
					for (int j = 0; j < 100; j++) {
						rowsum += arr[i][j]; // arr[0][0] + arr[0][1] + arr[0][2] + ...
						colsum += arr[j][i]; // arr[0][0] + arr[1][0] + arr[2][0] + ...
					}
					int rowcolcompare = Math.max(rowsum, colsum); // 첫번째 가로줄과 첫번째 세로줄 비교해서 둘 중의 큰 수 저장
																  // 두번째 가로줄과 두번째 세로줄 비교해서 둘 중의 큰 수 저장 ...
					max = Math.max(rowcolcompare, max); // 이때까지 가장 큰 수인 max와 위에서 비교한 수, 둘을 비교하여 큰 수를 max에 저장
				}

				int crossMax = Math.max(leftcrosssum, rightcrosssum); // 대각선 크기 비교
				int result = Math.max(max, crossMax); // 최대값과 대각선 크기 중에서 큰 수
				System.out.println("#" + test_case + " " + result);
			}

		}

	}
}
