public class Example {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int add(int number1, int number2) {
        return (number1 + number2);
    }

    public int[] moveZero(int[] arr) {
        int last = arr.length - 1;
        for (int index = 0; index < (arr.length); index++) {
            if (arr[last] == 0) {
                last--;
            }
            if (arr[index] == 0 && index < last) {
                int swap = arr[index];
                arr[index] = arr[last];
                arr[last] = swap;
                last--;
            }
            if (index > last) {
                break;
            }
        }
        return arr;
    }
}