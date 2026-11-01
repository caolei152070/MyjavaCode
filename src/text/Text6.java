package text;

import java.util.Random;

public class Text6 {
    public static void main(String[] args) {
        int[]arr ={5,20,30,90,100};
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = r.nextInt(arr.length);
            int temp =arr[i];
            arr[i]=arr[randomIndex];
            arr[randomIndex] =temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
