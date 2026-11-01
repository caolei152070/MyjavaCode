package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchDemo {
    //二分查找，返回下标，-1代表没找到
    public static int binarySearch(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入n：");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("输入" + n + "个无序整数：");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("输入要查找的整数a：");
        int a = sc.nextInt();
        Arrays.sort(arr);
        System.out.println("排序后数组：" + Arrays.toString(arr));
        int pos = binarySearch(arr, a);
        if (pos == -1) {
            System.out.println("没有找到该数字");
        } else {
            System.out.println("找到，位置(下标从0开始)：" + pos);
        }
        sc.close();
    }
}
