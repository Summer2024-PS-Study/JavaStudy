import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class psy_19949 {
    private static final int N = 10;
    private static int[] gradeArr = new int[N];
    private static int[] answerArr = new int[N];
    private static int result = 0;

    public static void Count() {
        int count = 0;
        // 답 비교
        for (int i = 0; i < N; i++) {
            if (gradeArr[i] == answerArr[i]) {
                count++;
            }
        }
        // 5점 이상인 경우 세기
        if (count >= 5)
            result++;
    }

    public static void DFS(int depth) {
        // 10문제의 답을 선택하는 모든 경우의 수를 거쳤다면 DFS 종료
        if (depth == N) {
            Count();
            return;
        }

        // 중복으로 답을 텍하는 경우가 없게 하기
        for (int i = 1; i <= 5; i++) {
            if (depth >= 2 && answerArr[depth-1] == i && answerArr[depth-2] == i) {
                continue;
            }
            answerArr[depth] = i;
            DFS(depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");

        for (int i = 0; i < 10; i++) {
            gradeArr[i] = Integer.parseInt(token[i]);
        }

        DFS(0);
        System.out.println(result);
    }
}