import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class TempMaxSub {
        static class Result {
            int l, r, sum;
            Result(int l, int r, int sum) {
                this.l = l;
                this.r = r;
                this.sum = sum;
            }
        }

        // 分治跨中间最大
        public static Result crossMax(int[] arr, int left, int mid, int right) {
            int leftSum = Integer.MIN_VALUE;
            int sum = 0;
            int lPos = mid;
            for(int i = mid; i >= left; i--){
                sum += arr[i];
                if(sum > leftSum){
                    leftSum = sum;
                    lPos = i;
                }
            }
            int rightSum = Integer.MIN_VALUE;
            sum = 0;
            int rPos = mid+1;
            for(int i = mid+1; i <= right; i++){
                sum += arr[i];
                if(sum > rightSum){
                    rightSum = sum;
                    rPos = i;
                }
            }
            return new Result(lPos, rPos, leftSum + rightSum);
        }

        // 分治主递归
        public static Result divideMax(int[] arr, int l, int r){
            if(l == r){
                return new Result(l, r, arr[l]);
            }
            int mid = (l + r)/2;
            Result leftRes = divideMax(arr, l, mid);
            Result rightRes = divideMax(arr, mid+1, r);
            Result crossRes = crossMax(arr, l, mid, r);

            if(leftRes.sum >= rightRes.sum && leftRes.sum >= crossRes.sum){
                return leftRes;
            }else if(rightRes.sum >= leftRes.sum && rightRes.sum >= crossRes.sum){
                return rightRes;
            }else{
                return crossRes;
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            List<Integer> list = new ArrayList<>();
            System.out.println("请输入温度数据，输入100结束：");
            while(true){
                int val = sc.nextInt();
                if(val == 100) break;
                list.add(val);
            }
            System.out.print("输入基准值：");
            int base = sc.nextInt();
            // 计算波动值 = 温度 - 基准
            int[] arr = new int[list.size()];
            for(int i=0;i<arr.length;i++){
                arr[i] = list.get(i) - base;
            }
            Result ans = divideMax(arr, 0, arr.length-1);
            System.out.println("最高区间累加温度："+ ans.sum);
            System.out.println("区间下标："+ ans.l + " ~ "+ ans.r);
            // 选做：输出区间每个原始温度
            System.out.print("区间内原始温度：");
            for(int i = ans.l; i <= ans.r; i++){
                System.out.print(list.get(i)+" ");
            }
            sc.close();
        }
    }

