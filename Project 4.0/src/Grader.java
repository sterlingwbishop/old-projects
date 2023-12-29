import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Grader {
	public static final int ARGS = 3;
	public static final int FLAG = 0;
	public static final int INFILE = 1;
	public static final int OUTFILE = 2;
	
	public static void main (String[] args) {
		if (args.length != 3) {
			System.out.println("Usage: java -cp bin Grader {-o|-s} infile outfile");
			System.exit(1);
		}
		if (!args[FLAG].equals("-o") && !args[FLAG].equals("-s")) {
			System.out.println("Usage: java -cp bin Grader {-o|-s} infile outfile");
			System.exit(1);
		}
		Scanner in = null;
		PrintWriter out = null;
		try {
			in = new Scanner(new FileInputStream(arg[INFILE]));
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to access input file: " + args[INFILE]);
			System.exit(1);
		}
	}
}