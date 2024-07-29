import java.util.Scanner;

public class psy_2992 {
    public static int result; // 결과값을 저장하는 변수

    // 다음 순열을 찾는 함수
    public static int nextPermutation(int[] nums, int N, int digits) {
        int pivot = digits - 2;

        // 뒤에서부터 첫 번째 감소하는 요소를 찾음
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        if (pivot >= 0) {
            // 뒤에서부터 계산하여 처음으로 내림이 되는 경우 찾기 (두 수의 자리를 바꿨을 때 숫자가 커지는 첫 지점)
            for (int i = digits - 1; i > pivot; i--) {
                if (nums[i] > nums[pivot]) {
                    swap(nums, pivot, i); // 피벗과 i 위치의 요소를 교환
                    break;
                }
            }
        } else { // 전체가 내림차순인 경우
            return 0;
        }

        // 피벗 이후 부분을 반전시켜서 가장 작게 만들기
        reverse(nums, pivot + 1, digits - 1);

        result = 0;
        // 결과가 N보다 크거나, 결과가 0으로 시작하지 않는 경우에만 결과값 계산
        if (result > N || nums[0] != 0) {
            for (int i = 0; i < digits; i++) {
                result = result * 10 + nums[i];
            }
        }

        return result;
    }

    // 두 요소의 위치를 교환하는 함수
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 주어진 범위의 배열을 반전시키는 함수
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int digits = (int) Math.log10(Math.abs(N)) + 1; // 숫자의 자릿수 계산
        int[] nums = new int[digits];

        if (digits != 1) { // 자릿수가 1이 아닌 경우
            int n = N;
            for (int i = 0; i < digits; i++) { // 각 자릿수를 배열에 저장
                nums[i] = (int) (n / Math.pow(10, digits - (i + 1)));
                n = (int) (n - nums[i] * Math.pow(10, digits - (i + 1)));
            }
        }

        nextPermutation(nums, N, digits);
        System.out.println(result);
    }
}

