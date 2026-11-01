package text;

import java.util.Random;

public class Text5 {
    public static void main(String[] args) {
        int[]arr = {8,588,1000,5000,5888};
        int[]newArr = new int[arr.length];
        Random r =new Random();
        for (int i = 0; i < 5; ) {
            int randomIndex = r.nextInt(arr.length);
            int prize = arr[randomIndex];
            boolean flag = contain(newArr,prize);
            if(!flag){
                newArr[i] =prize;
                i++;
            }
            for (int j = 0; j < newArr.length; j++) {
                System.out.println(newArr[j]);
            }

        }
    }
    public static boolean contain(int[]arr,int prize){
        for (int i = 0; i < arr.length;i++){
            if(arr[i] ==prize){
                return true;

            }
        }
        return false;
    }
}
