import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String numsA = br.readLine();
        String[] arrA = numsA.split(" ");
        int[] A = Arrays.stream(arrA).mapToInt(Integer::parseInt).toArray();

        String numsB = br.readLine();
        String[] arrB = numsB.split(" ");
        int[] B = Arrays.stream(arrB).mapToInt(Integer::parseInt).toArray();
        int[] temp = B.clone();

        quickSortAsc(A,0,A.length - 1);
        quickSortDesc(temp,0,temp.length - 1);

        int res = 0;
        for (int i = 0; i < N; i++) {
            res += A[i] * temp[i];
        }

        System.out.println(res);
    }

    static void quickSortAsc(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int pivot = nums[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (nums[j] <= pivot)
                swap(nums, ++i, j);
        }

        swap(nums, ++i, end);
        quickSortAsc(nums, start, i - 1);
        quickSortAsc(nums, i + 1, end);
    }

    // 내림차순
    static void quickSortDesc(int[] nums, int start, int end) {
        if (start >= end)
            return;

        int pivot = nums[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (nums[j] >= pivot)
                swap(nums, ++i, j);
        }

        swap(nums, ++i, end);
        quickSortDesc(nums, start, i - 1);
        quickSortDesc(nums, i + 1, end);
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
