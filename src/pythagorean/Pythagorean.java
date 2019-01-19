package pythagorean;

import java.util.Scanner;

public class Pythagorean {
	private static InputPrompter scanner;

	public static void main(String args[]) {
		scanner = new InputPrompter(System.in);
		doOneCalculation();
		scanner.close();
	}

	/**
	 * Reqests for input once and responds if possible
	 * 
	 * @return was the input valid?
	 */
	private static void doOneCalculation() {
		boolean knowHypotenuse = scanner.nextYesNo("Do you know the hypotenuse? (Yes/no) ");

		if (knowHypotenuse) {
			calcKnowHypotenuse();
		} else {
			calcDontKnowHypotenuse();
		}
	}

	private static void calcDontKnowHypotenuse() {
		double leg1 = scanner.nextPositiveDouble("Enter the length of one leg.");
		double leg2 = scanner.nextPositiveDouble("Enter the length of the other leg.");

		double hyp = (Math.sqrt(Math.pow(leg1, 2) + Math.pow(leg2, 2)));

		System.out.print("The length of the hypotenuse is " + hyp);
	}

	private static void calcKnowHypotenuse() {
		double leg1 = scanner.nextPositiveDouble("Enter the length of the leg.");
		double hyp = getPositiveDoubleLargerThan(leg1, "Enter the length of the hypotenuse.");

		double leg2 = (Math.sqrt(Math.pow(hyp, 2) - Math.pow(leg1, 2)));

		System.out.print("The length of the other leg is is " + leg2);
	}

	// this isn't in the InputPrompter class because it's too specific
	private static double getPositiveDoubleLargerThan(double min, String message) {
		while (true) {
			double val = scanner.nextPositiveDouble(message);

			if (val <= min) {
				System.out.println("Invalid!");
			} else {
				return val;
			}
		}
	}

}
