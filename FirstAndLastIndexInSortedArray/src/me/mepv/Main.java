package me.mepv;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 9, 5, 5, 5, 5, 7, 9};
        int target = 5;
        System.out.println(Arrays.toString(firstAndLast(arr, target)));
    }

    private static int[] firstAndLast(int[] arr, int target) {
        int[] sortedArr = Arrays.stream(arr).sorted().toArray();
        int[] resultError = {-1, -1};
        int[] resultArr = new int[2];
        resultArr[0] = findStart(sortedArr, target);
        resultArr[1] = findEnd(sortedArr, target);
        if (arr.length == 0 || arr[0] > target || arr[arr.length - 1] < target) return resultError;
        return resultArr;
    }

    private static int findStart(int[] arr, int target) {
        if (arr[0] == target) return 0;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target && arr[mid - 1] < target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private static int findEnd(int[] arr, int target) {
        if (arr[arr.length - 1] == target) return arr.length - 1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target && arr[mid + 1] > target) return mid;
            else if (arr[mid] > target) return mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}
