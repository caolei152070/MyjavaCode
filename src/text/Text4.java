package text;

import java.util.Random;
import java.util.Scanner;

public class Text4 {
    public static void main(String[] args) {
        char[]chs = new char[52];
        String result ="";
        for (int i = 0; i < chs.length; i++) {
            if (i <= 25) {
                chs[i] = (char) (97 + i);
            } else {
                chs[i] = (char) (65 + i - 25);
            }
        }
           Random r =new Random();
           int randomIndex = r.nextInt(chs.length);


        for (int i = 0; i < 4; i++) {
            int remdonIndex = r.nextInt(chs.length);
            result = result +chs[randomIndex];
        }
        System.out.println(result);
    }
}
