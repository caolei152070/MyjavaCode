package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入n和K：");
        int n = sc.nextInt();
        int K = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("输入" + n + "个整数：");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        //小顶堆求前K大
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int x : nums) {
            minHeap.add(x);
            if (minHeap.size() > K) {
                minHeap.poll();
            }
        }
        List<Integer> topKList = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            topKList.add(minHeap.poll());
        }
        System.out.println("前K大数：" + topKList);
        //对前K个数排序
        int[] kArr = new int[K];
        for (int i = 0; i < K; i++) {
            kArr[i] = topKList.get(i);
        }
        Arrays.sort(kArr);
        System.out.println("前K个数排序后：" + Arrays.toString(kArr));
        sc.close();
    }
}
