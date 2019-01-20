package pythagorean;

import java.io.InputStream;
import java.util.Scanner;

/**
 * A scanner that forces the user to enter valid values
 * 
 * @author japnaa
 */
public class InputPrompter {
	private Scanner scanner;
	private Object resultCache;

	InputPrompter(InputStream inputStream) {
		scanner = new Scanner(inputStream);
	}

	public int nextInt(String message) {
		System.out.print(message);
		return nextInt();
	}

	public int nextInt() {
		ForeverTryer.untilPass(() -> {
			resultCache = scanner.nextInt();
		}, () -> {
			System.out.println("Invalid! Please enter an int.");
			scanner.nextLine();
		});
		return (int) resultCache;
	}

	public double nextPositiveDouble(String message) {
		System.out.println(message);
		return nextPositiveDouble();
	}

	public double nextPositiveDouble() {
		double value = nextDouble();
		while (value < 0) {
			System.out.println("Invalid!");
			value = nextDouble();
		}
		return value;
	}

	public double nextDouble(String message) {
		System.out.print(message);
		return nextDouble();
	}

	public double nextDouble() {
		ForeverTryer.untilPass(() -> {
			resultCache = scanner.nextDouble();
		}, () -> {
			System.out.println("Invalid! Please enter a double.");
			scanner.nextLine();
		});
		return (double) resultCache;
	}

	public boolean nextYesNo(String message) {
		System.out.print(message);
		return nextYesNo();
	}

	public boolean nextYesNo() {
		while (true) {
			String line = scanner.nextLine();
			
			try {
				return yesNoStringToBool(line);
			} catch (InputError err) {
				System.out.println("Invalid!");
			}
		}
	}

	private boolean yesNoStringToBool(String line) throws InputError {
		String cleanLine = line.trim().toLowerCase();
		
		switch (cleanLine) {
		case "yes":
		case "ye":
		case "y":
			return true;
		case "no":
		case "n":
			return false;
		default:
			throw new InputError("Invalid");
		}
	}

	public void close() {
		scanner.close();
	}
}
