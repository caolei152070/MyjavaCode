package text;

import jdk.nashorn.internal.parser.JSONParser;

public class Text1 {
    public static void main(String[] args) {
    int sum = getsum(10,20,30);
    System.out.print(sum);
    }
    public static int getsum(int sum1,int sum2,int sum3){
        int result = sum1+sum2+sum3;
        return result;
    }
}
