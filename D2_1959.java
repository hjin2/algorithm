import java.util.Scanner;
import java.io.FileInputStream;

public class D2_1959 {
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/examples/D2_1959.txt"));
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int asize = sc.nextInt();
			// System.out.println("asize " + asize);
			int bsize = sc.nextInt();
			// System.out.println("bsize " + bsize);
			int[] alist = new int[asize];
			int[] blist = new int[bsize];
			for (int i = 0; i < asize; i++) {
				alist[i] = sc.nextInt();
				// System.out.println("alist[" + i + "]" + " = " + alist[i]);
			}
			for (int i = 0; i < bsize; i++) {
				blist[i] = sc.nextInt();
				// System.out.println("blist[" + i + "]" + " = " + blist[i]);
			}
			int[] multilist = new int[Math.abs(asize - bsize) + 1]; // 큰 배열 사이즈- 작은 배열 사이즈 + 1 = 계산 경우의 수

			for (int i = 0; i < Math.abs(asize - bsize) + 1; i++) { // 계산 경우의 수
				for (int j = 0; j < Math.min(asize, bsize); j++) { // 작은 배열 사이즈만큼 무조건 돈다
					if (asize < bsize) { // 둘 중에 사이즈의 대소를 몰라서 if문으로 지정, b가 큰 배열인 경우
						multilist[i] += alist[j] * blist[j + i]; // alist[j] j 즉 작은배열 사이즈만큼 계속 돈다, blist[j+i] j에 i더해주어야함
					} else {
						multilist[i] += blist[j] * alist[j + i];
					}
				}
			}

			int max = multilist[0]; // 더한 수들 중에서 최댓값 찾기
			for (int i = 1; i < multilist.length; i++) {
				if (max < multilist[i]) {
					max = multilist[i];
				}
			}
			System.out.println("#" + test_case + " " + max);
		}

	}
}
