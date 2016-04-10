import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Max Donchenko (https://github.com/goodwin64) on 10.04.2016.
 */
public class Numbers {
    public static void main(String[] args) {
        System.out.println(isPrime(4));
        System.out.println(isPrime(5));
        System.out.println(isPrime(6));
        System.out.println(isPrime(7));
        System.out.println(isPrime(20));
    }

    public static int[] getNumbersFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many numbers? ");
        int numbersCount = scanner.nextInt();
        int[] numbers = new int[numbersCount];

        for (int i = 0; i < numbersCount; i++) {
            System.out.printf("%d) ", i+1);
            try {
                numbers[i] = scanner.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
        }

        return numbers;
    }

    private static int gcd(int a, int b)	{
        a = Math.abs(a);
        b = Math.abs(b);
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int gcd(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = gcd(result, input[i]);
        }
        return result;
    }

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

    public static long lcm(int[] input) {
        int result = input[0];
        for (int i = 1; i < input.length; i++) {
            result = lcm(result, input[i]);
        }
        return result;
    }


    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
