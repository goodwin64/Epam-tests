import java.util.Scanner;
import java.util.Random;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

public class Main {
	public static void main(String[] args) {
		int[] numbers = {
				-746, 16, 31, 891, 53,
				20, 0, -346, -12, 35,
				111, 451, -22, -95, 224
		}; // getNumbersFromConsole();

		taskB1(numbers);
		taskB2(numbers);
		taskB3(numbers);
		taskB4(numbers);
		taskB6(numbers);
		taskB7(numbers);
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

	private static int gcd(int[] input) {
		int result = input[0];
		for (int i = 1; i < input.length; i++) {
			result = gcd(result, input[i]);
		}
		return result;
	}

	private static int lcm(int a, int b) {
		return a * (b / gcd(a, b));
	}

	private static long lcm(int[] input) {
		int result = input[0];
		for (int i = 1; i < input.length; i++) {
			result = lcm(result, input[i]);
		}
		return result;
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

	public static void taskA6() {
		System.out.println("----- TASK 6 -----");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your surname: ");
		String devSurname = scan.next();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String currentDateTime = dateFormat.format(date);

		System.out.printf("Developer surname:\t%s\nTest passed:\t\t%s",
			devSurname, currentDateTime);
	}

	public static void taskB1(int[] numbers) {
		System.out.println("----- TASK B1 -----");
		System.out.println("Even numbers:");
		for (int number : numbers) {
			if (number % 2 == 0) {
				System.out.print(number + " ");
			}
		}
		System.out.println("\nOdd numbers:");
		for (int number : numbers) {
			if (Math.abs(number) % 2 == 1) {
				System.out.print(number + " ");
			}
		}
		System.out.println();
	}

	public static void taskB2(int[] numbers) {
		System.out.println("----- TASK B2 -----");
		if (numbers.length == 0) {
			return;
		}

		int min = numbers[0];
		int max = numbers[0];

		for (int num : numbers) {
			if (num < min) {
				min = num;
			} else if (num > max) {
				max = num;
			}
		}

		System.out.println("Max number: " + max);
		System.out.println("Min number: " + min);
	}

	public static void taskB3(int[] numbers) {
		System.out.println("----- TASK B3 -----");
		for (int num : numbers) {
			if (num % 3 == 0 || num % 9 == 0) {
				/*
				* Probably there is a typo in the book.
				* Because all the numbers that are multiples of 3, are multiples of 9.
				*/
				System.out.print(num + " ");
			}
		}
		System.out.println("are multiples of 3 or 9");
	}

	public static void taskB4(int[] numbers) {
		System.out.println("----- TASK B4 -----");
		for (int num : numbers) {
			if (num % 5 == 0 && num % 7 == 0) {
				System.out.print(num + " ");
			}
		}
		System.out.println("are multiples of 5 and 7");
	}

	public static void taskB6(int[] numbers) {
		System.out.println("----- TASK B6 -----");
		System.out.print("3-digits numbers ");
		for (int num : numbers) {
			if (num >= 100 && num <= 999
					|| num <= -100 && num >= -999) {
				String notation = String.valueOf(num);
				boolean onlyUniqueDigits = true;
				for (char c : notation.toCharArray()) {
					if (notation.indexOf(c) != notation.lastIndexOf(c)) {
						onlyUniqueDigits = false;
						break;
					}
				}
				if (onlyUniqueDigits) {
					System.out.print(num + " ");
				}
			}
		}
		System.out.println("contain only unique digits.");
	}

	public static void taskB7(int[] numbers) {
		System.out.println("----- TASK B7 -----");
		System.out.println("GCD: " + gcd(numbers));
		System.out.println("LCM: " + lcm(numbers));
	}
}
