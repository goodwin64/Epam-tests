import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		taskA5(args);
	}

	public static void taskA1() {
		System.out.println("----- TASK 1 -----");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name and press <Enter>:");
		String name = scan.next();
		System.out.printf("Hi, %s! Glad to see you.\n", name);
	}

	public static void taskA2(String[] args) {
		System.out.println("----- TASK 2 -----");
		for (int i = args.length - 1; i >= 0; i--) {
			System.out.print(args[i] + "  ");
		}
		System.out.println();
	}

	public static void taskA3() {
		System.out.println("----- TASK 3 -----");
		Scanner scan = new Scanner(System.in);
		int countWithNewLine, countInSameLine;
		Random random = new Random();
		
		System.out.print("Count of random numbers each in a new line: ");
		countWithNewLine = scan.nextInt();
		
		System.out.print("Count of random numbers each in the same line: ");
		countInSameLine = scan.nextInt();

		for (int i = 0; i < countWithNewLine; i++) {
			System.out.println(random.nextInt());
		}
		for (int i = 0; i < countInSameLine; i++) {
			System.out.print(random.nextInt() + " ");
		}
		System.out.println();
	}

	public static void taskA4() {
		System.out.println("----- TASK 4 -----");
		int attempts = 3;
		int currentNumber;
		Scanner scan = new Scanner(System.in);
		Password pass = new Password();

		System.out.printf("You have %d attempts. Guess 1-digit password (0..9):\n", attempts);
		for (int i = 1; i <= attempts; i++) {
			System.out.printf("Enter number %d: ", i);
			currentNumber = scan.nextInt();
			if (pass.guess(currentNumber)) {
				System.out.println("You guessed the number. Congratulations!");
				System.out.printf("The number was %d.\n", currentNumber);
				return;
			}
		}
		System.out.println("You didn't guess the number. Perhaps you will be lucky next time.");
	}

	public static void taskA5(String[] args) {
		System.out.println("----- TASK 5 -----");
		double sum = 0;
		double product = 1;
		double currentNumber;

		for (String arg : args) {
			currentNumber = Double.parseDouble(arg.replaceAll(",", "."));
			sum += currentNumber;
			product *= currentNumber;
		}

		System.out.println("Sum = " + sum);
		System.out.println("Product = " + product);
	}
}
