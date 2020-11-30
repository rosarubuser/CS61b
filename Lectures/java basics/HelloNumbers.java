public class HelloNumbers {
    public static void main (String[] args) {
        int sum = 0;
        for (int i = 1; i < 11; i += 1) {
            System.out.print(sum + " ");
            sum += i;
        }
    }
}