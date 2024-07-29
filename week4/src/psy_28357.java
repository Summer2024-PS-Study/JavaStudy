import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class psy_28357 {
    public static long[] students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");

        int N = Integer.parseInt(token[0]);
        long K = Long.parseLong(token[1]);
        students = new long[N];

        token = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(token[i]);
        }

        System.out.println(binSearch(0,100,K)); // 0점에서 100점 사이에서 선택
    }

    public static long binSearch(long start, long end, long key) {
        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long candies = candy(mid);
            if (candies >= key) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static long candy(long mid) {
        long result = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i]-mid > 0)
                result += students[i]-mid;
        }
        return result;
    }
}