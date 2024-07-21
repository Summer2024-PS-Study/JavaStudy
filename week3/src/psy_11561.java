import java.util.Scanner;

public class psy_11561 {
    public static long start = 0;
    public static long end = 141421356; // 밟을 수 있는 최대 횟수 지정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] N = new long[T];

        // 징검다리 수 저장
        for (int i = 0; i < T; i++) {
            N[i] = sc.nextLong();
        }

        for (int i = 0; i < T; i++) {
            System.out.println(binSearch(N[i], start, end));
        }
    }

    // 밟은 횟수를 기준으로 이진 탐색 진행
    private static long binSearch(long N, long start, long end) {
        long mid = (start + end) / 2;

        // 등차수열의 합 법칙으로 최대로 밟을 수 있는 횟수 찾기
        while (start <= end) {
            mid = (start + end) / 2;
            if ((mid * (mid + 1) / 2) <= N) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}

