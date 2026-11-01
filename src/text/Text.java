package text;

public class Text {
    public static void main(String[] args) {
        int number = 123;
        int temp = number;
        int count = 0;
        while (number != 0) {
            number = number / 10;
            count++;
        }
        System.out.println(count);

        int[] arr = new int[count];
        int index =arr.length;
        while (temp != 0) {
            int ge = temp%10;
            temp = temp/10;
            arr[index]= ge;
            index--;
        }
    }
}