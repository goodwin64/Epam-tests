import java.util.Random;

public class Password {
	private int password = new Random().nextInt(10);

	public boolean guess(int number) {
		if (number == password) {
			return true;
		}
		return false;
	}
}
