import java.util.Scanner;
import java.io.FileInputStream;
/*
 * 741 987 369
 * 852 654 258
 * 963 321 147
 * 처음에는 741,852,963순으로 반복문 입력받아야되나 하는 생각 -> 틀림
 * 한줄이 741,987,369 이니까 이렇게 세 등분으로 반복문 돌려야 함 741 987 369입력받고 852 654 258 입력받는 순으로
 * 변수 N을 활용하지 못해서 처음에 어려움을 겪음
 */
public class D2_1961 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/examples/D2_1961.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println("#" + test_case + " ");
			for (int i = 0; i < N ; i++) {
				for(int j = N-1; j>=0 ; j--) {
					System.out.print(arr[j][i]);
				}
				System.out.print(" ");
				for(int j = N-1; j >=0 ; j--) {
					System.out.print(arr[N-1-i][j]);
				}
				System.out.print(" ");
				for(int j = 0; j < N; j++) {
					System.out.print(arr[j][N-1-i]);
				}
				System.out.println();
			}

		}

	}
}
