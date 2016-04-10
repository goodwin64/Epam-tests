import java.util.Scanner;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		taskA3();
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
}
