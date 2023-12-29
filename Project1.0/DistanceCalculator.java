import java.util.*;

public class DistanceCalculator {
	public static double calculateVerticalDistance( double initalHeight, double reboundFraction) {
			double finalCalculation;
			finalCalculation = (initalHeight * ((1 + reboundFraction) / (1 - reboundFraction)));
			return finalCalculation;
			}
	public static double calculateHorizontalDistance(double angle, double initalVelocity, double initalHeight) {
			final double GRAVITATIONAL_ACCELERATION = 32.174;
			double finalCalculation;
			finalCalculation = ((initalVelocity * Math.cos(Math.toRadians(angle))) / GRAVITATIONAL_ACCELERATION) * ((initalVelocity * Math.sin(Math.toRadians(angle))) + (Math.sqrt(Math.pow(initalVelocity * Math.sin(Math.toRadians(angle)), 2)) + (2 * GRAVITATIONAL_ACCELERATION * initalHeight)));
			return finalCalculation;
			}
	public static void main (String[]args) {
		Scanner scnr = new Scanner (System.in);
		String calculateHorizontalDistance;
		String calculateVerticalDistance;
		double initalVelocity;
		double initalHeight;
		double angle;
		double reboundFraction;
		double finalCalculation;
		System.out.print("Distance calculation type (H-Horizontal, V-Vertical): ");
		String calculationType = scnr.next();
		//VERTICAL
		if (calculationType.startsWith("V") || calculationType.startsWith("v")) {
	
			System.out.print("Initial Height?: ");
			initalHeight = scnr.nextDouble();
			if (initalHeight < 0) {
				System.out.print("Invalid height");
				System.exit(1);
			}
			System.out.println();
			System.out.print("Rebound Fraction?: ");
			reboundFraction = scnr.nextDouble();
			if (reboundFraction <= 0 || reboundFraction >= 1) {
				System.out.print("Invalid fraction");
				System.exit(1);
			}
			System.out.println();
			finalCalculation = calculateVerticalDistance(initalHeight, reboundFraction);
			System.out.print("Distance: ");
			System.out.printf("%.2f", finalCalculation);
			System.out.print(" ft");
		}
		//HORIZONTAL
		else if (calculationType.startsWith("H") || calculationType.startsWith("h")){
			System.out.print("Initial Velocity?: ");
			initalVelocity = scnr.nextDouble();
			if (initalVelocity < 0) {
				System.out.print("Invalid velocity");
				System.exit(1);
			}
			System.out.println();
			System.out.print("Initial Height?: ");
			initalHeight = scnr.nextDouble();
			if (initalHeight < 0) {
				System.out.print("Invalid height");
				System.exit(1);
			}
			System.out.println();
			System.out.print("Angle?: ");
			angle = scnr.nextDouble();
		
			if (angle < 0 || angle > 90) {
				System.out.print("Invalid angle");
				System.exit(1);
			}
			System.out.println();
			finalCalculation = calculateHorizontalDistance(angle, initalVelocity, initalHeight);
			System.out.print("Distance: ");
			System.out.printf("%.2f", finalCalculation);
			System.out.print(" ft");
		}
		else {
			System.out.println("Invalid type");
			System.exit(1);
		}
	}
}