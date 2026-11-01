package text;

public class Text3 {
    public static void main(String[] args) {
    int[]arr = {1,2,3,4,5,6,7,8,9};
    int []copyArr = copeOfRange(arr,3,7);
        for (int i = 0; i < copyArr.length; i++) {
            System.out.print(copyArr[i]);
        }
    }
    public static int[] copeOfRange(int[]arr,int form,int to){
    int[]newArr = new int[to - form];
    int j = 0;
        for (int i = form; i <to; i++) {
            newArr[j] = arr[i];
            j++;
        }
        return newArr;
    }
}
