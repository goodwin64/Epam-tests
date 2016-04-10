import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		taskA1();
	}

	public static void taskA1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your name and press <Enter>:");
		String name = scan.next();
		System.out.printf("Hi, %s! Glad to see you.", name);
	}
}