package exercise;

import java.util.Arrays;
import java.util.Scanner;
public class DivideConquerDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入n");
        int n =sc.nextInt();
        int[]arr =new int[n];
        System.out.println("请输入n个整数");
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("请输入要查询的数字");
        int target = sc.nextInt();
        Arrays.sort(arr);
        System.out.print("排序后的数组：" + Arrays.toString(arr));
        int pos = binarySearch(arr,target);
        if(pos == -1){
            System.out.println("没有找到");
        }else{
            System.out.println("找到,a的位置："+pos);
        }sc.close();
    }
    public static int binarySearch(int[]a,int key) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
