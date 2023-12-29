import java.util.*;
public class PatternMaker {
/**
*@param rows the number of rows the user inputs between 1 and 10
*@param columns the number of columns the user inputs between 1 and 10
*@return Returns a string containing a Square pattern with the given number of rows and columns formatted
*as described above. NOTE: Each line of the pattern should end with a newline character.
*@throws Throws an IllegalArgumentException with the message, "Invalid rows", if rows < 1 or rows > 10
*@throws Throws an IllegalArgumentException with the message, "Invalid columns", if cols < 1 or cols > 10
**/
	public static String getSquares(int rows, int columns) {
		int i;
		int j;
		String square = " ";
		for (i = 0; i < columns; i++) {
				square = square + "_ ";
			}
		for (j = 0; j < rows; j++){
			square += " ";
			square = square + "\n|";
			for (i = 0; i < columns; i++) {
				square = square + "_|";
			}
		}
		return square;
	}
/**
*@param rows the number of rows the user inputs between 1 and 10
*@return returns a string containing a Triangle pattern with the given number of rows formatted
*as described above.
*@throws Throws an IllegalArgumentException with the message, "Invalid rows", if rows < 1 or rows > 10
*NOTE: Each line of the pattern should end with a newline character.
**/
	public static String getTriangles(int rows) {
		int i;
		String triangle ="";
		for  (i = 0; i < rows; i++) {
			triangle = triangle + " ";
			triangle = triangle + "/\\\n";
			triangle = triangle + "/__\\\n";
		}
		return triangle;
	}
/**
@param rows the number of rows input by the user between 1 and 10
*@return a string containing a Diamond pattern with the given number of rows formatted 
*as described in the project. 
*@throws Throws an IllegalArgumentException with the message, "Invalid rows", if rows < 1 or rows > 10
*NOTE: Each line of the pattern should end with a newline character.
**/
	public static String getDiamonds(int rows) {
		return null;
	}
/** 
*@return Returns the menu selection of the user in the 
*form of a single character
**/
	public static char getMenu() {
		Scanner scnr = new Scanner (System.in);
		System.out.println("Pattern maker - Please choose an option.");
		System.out.println();
		System.out.println("S - Square");
		System.out.println("T - Triangle");
		System.out.println("D - Diamond");
		System.out.println("Q - Quit");
		System.out.println();
		System.out.print("Option: ");
		char menuSelect = scnr.next().charAt(0);
		return menuSelect;
	}
	public static void main (String[]args) {
		Scanner scnr = new Scanner (System.in);
		int exitValue = 0;
		int rows;
		int columns;
		while (exitValue == 0) {
			char menuSelect;
			menuSelect = getMenu();
			if ((menuSelect == 'S') || (menuSelect == 's')) {
				System.out.print("Rows: ");
				rows = scnr.nextInt();
				if ((rows>10) || (rows<1)) {
					System.out.println("Invalid rows");
				}
				else {
					System.out.print("Columns: ");
					columns = scnr.nextInt();
					if ((columns>10) || (columns<1)) {
						System.out.println("Invalid columns");
					}
					else {
						System.out.println(getSquares(rows, columns));
					}
				}
			}
			else if ((menuSelect == 'T') || (menuSelect == 't')) {
				System.out.print("Rows: ");
				rows = scnr.nextInt();
				if ((rows>10) || (rows<1)) {
					System.out.println("Invalid rows");
				}
				else {
					System.out.println(getTriangles(rows));
				}
			}
			else if ((menuSelect == 'D') || (menuSelect == 'd')) {
				System.out.print("Rows: ");
				rows = scnr.nextInt();
				if ((rows>10) || (rows<1)) {
					System.out.println("Invalid rows");
				}
				else {
					System.out.println(getDiamonds(rows));
				}
			}
			else if ((menuSelect == 'Q') || (menuSelect == 'q')) {
				System.out.println("Goodbye!");
				System.exit(1);
			}
			else {
				System.out.println("Invalid option");
			}
		}
	}
}