package text;

public class Text2 {
    public static void main(String[] args) {
        int[]arr = {10,2,34,35,75,20};
        boolean result= contain(arr,34);
        System.out.print(result);
    }
    public static boolean contain(int[]arr,int number){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == number){
                return true;
            }
        }
        return false;
    }
}
