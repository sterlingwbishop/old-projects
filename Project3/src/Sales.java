import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Sales {

    public static int getNumberOfLines(Scanner inFS) {
        int numberOfLines = 0;
        if (inFS == null) {
            throw new IllegalArgumentException("Null file");
        }
        while (inFS.hasNextLine()) {
            numberOfLines += 1;
            inFS.nextLine();
        }
        return numberOfLines;
    }

// Returns true, if successful
// Returns false, if a line of the input file 
//   (a) does not contain exactly three values as described above, 
//   (b) the quantity for an item is not an integer that is greater than or equal to 0, 
//   (c) or two or more items have the same id
// Throws an IllegalArgumentException with the message "Invalid array length" if 
//   (a) the lengths of itemIds, itemNames, and/or itemQuantities are not the same OR
//   (b) if the number of lines in the file is not the same as the length of the arrays,
//     which may be detected when reading the lines of the file
//
// NOTE: You must check for invalid parameters (arguments) in the order given above.
    public static boolean inputInventory(Scanner in, String[] itemIds, String[] itemNames, int[] itemQuantities) {
        int step = 0;
        String currentItemId;
        String currentItemName;
        int currentItemAmount;
        Scanner oneLine = null;

        if (in == null) {
            throw new IllegalArgumentException("Null file");
        }

        if ((itemIds == null) || (itemNames == null) || (itemQuantities == null)) {
            throw new IllegalArgumentException("Null array");
        }

        if ((itemIds.length != itemNames.length) || (itemIds.length != itemQuantities.length) || (itemNames.length != itemQuantities.length)) {
            throw new IllegalArgumentException("Invalid array length");
        }

        while (in.hasNextLine()) {
            String currentLine = in.nextLine();
            oneLine = new Scanner(currentLine).useDelimiter(",");

            if (!oneLine.hasNext()) {
                return false;
            }

            currentItemId = oneLine.next();

            for (int i = 0; i < step; ++i) {
                if (itemIds[i].equals(currentItemId)) {
                    return false;
                }
            }

            itemIds[step] = currentItemId;

            if (!oneLine.hasNext()) {
                return false;
            }

            currentItemName = oneLine.next();
            itemNames[step] = currentItemName;

            if (!oneLine.hasNextInt()) {
                return false;
            }

            currentItemAmount = oneLine.nextInt();

            if (currentItemAmount < 0) {
                return false;
            }

            itemQuantities[step] = currentItemAmount;

            if (oneLine.hasNext()) {
                return false;
            }
            step += 1;
        }

        if ((itemIds.length != itemNames.length) || (itemIds.length != itemQuantities.length) || (itemNames.length != itemQuantities.length)) {
            return false;
        }

        return true;
    }

    

    public static String getList(String[] itemIds, String[] itemNames, int[] itemQuantities) {
        
        if ((itemIds == null) || (itemNames == null) || (itemQuantities == null)) {
            throw new IllegalArgumentException("Null array");
        }

        if ((itemIds.length != itemNames.length) || (itemIds.length != itemQuantities.length) || (itemNames.length != itemQuantities.length)) {
            throw new IllegalArgumentException("Invalid array length");
        }

        int numberOfLines = itemIds.length;
        String returnValue = "";

        for (int i = 0; i < numberOfLines; ++i) {
            returnValue += (toString(itemIds[i], itemNames[i], itemQuantities[i])) + "\n";
        }
        return returnValue;
    }

    // If none of the items have a name that is or contains itemName, 
    //   the empty String ("") is returned.
    // NOTE: You must check for invalid parameters (arguments) in the order given above.
    public static String searchByName(String[] itemIds, String[] itemNames, int[] itemQuantities, String itemName) {
        
        if ((itemIds == null) || (itemNames == null) || (itemQuantities == null)) {
            throw new IllegalArgumentException("Null array");
        }

        if ((itemIds.length != itemNames.length) || (itemIds.length != itemQuantities.length) || (itemNames.length != itemQuantities.length)) {
            throw new IllegalArgumentException("Invalid array length");
        }

        int lineCount = itemIds.length;
        String returnValue = "";
        
        System.out.println("  ID            Name          Quantity");
        for (int i = 0; i < lineCount; ++i) {
            if (itemNames[i].contains(itemName)) {
                returnValue += (toString(itemIds[i], itemNames[i], itemQuantities[i]) + "\n");
            }
        }
        return returnValue;
    }

    public static String toString(String itemId, String itemName, int itemQuantity) {
        return String.format("%6s  %-25s %4d", itemId, itemName, itemQuantity);
    }

    
    public static String makePurchase(String[] itemIds, int[] itemQuantities, String itemId, int itemQuantity) {

        if ((itemIds == null) || (itemQuantities == null)) {
            throw new IllegalArgumentException("Null array");
        }

        if (itemIds.length != itemQuantities.length) {
            throw new IllegalArgumentException("Invalid array length");
        }

        if (itemQuantity < 0) {
            throw new IllegalArgumentException("Invalid quantity");
        }

        int lineCount = itemIds.length;
        int tempValue;
        for (int i = 0; i < lineCount; i++) {
            if (itemId == itemIds[i]) {
                tempValue = itemQuantities[i];
                tempValue -= itemQuantity;
                if (tempValue < 0) {
                    return "Insufficient quantity";
                }
                itemQuantities[i] -= itemQuantity;
                return "Successful purchase";
            }
        }
        throw new IllegalArgumentException("Invalid item");
    }

        // Outputs the inventory data to the file in CSV format as described above.
    // Throws an IllegalArgumentException with the message
    //   "Null array" if itemIds, itemNames, and/or itemQuantities are/is null
    //
    // NOTE: You must check for invalid parameters (arguments) in the order given above.
    public static void outputInventory(PrintWriter out, String[] itemIds, String[] itemNames, int[] itemQuantities) {
        if (out == null) {
            throw new IllegalArgumentException("Null file");
        }

        if ((itemIds.length != itemNames.length) || (itemIds.length != itemQuantities.length) || (itemNames.length != itemQuantities.length)) {
            throw new IllegalArgumentException("Invalid array length");
        }

        if ((itemIds == null) || (itemNames == null) || (itemQuantities == null)) {
            throw new IllegalArgumentException("Null array");
        }

        for (int i = 0; i < itemIds.length; ++i) {
            out.println(itemIds[i] + ", " + itemNames[i] + ", " + itemQuantities[i]);
        }

    }


    public static void main(String[]args) throws IOException {

        Scanner scnr = new Scanner(System.in);
        Scanner inFS = null;
        Scanner lineCounter = null;
        char option = 'z';
        boolean menuSelectionPhase = true;
        Path path = null;
        
        if (args.length != 2) {
            System.out.println("Usage: java Sales input output");
            System.exit(2);
        }

        FileInputStream userFileStream = null;
        FileOutputStream userOutputStream = null;
       

        try {
            System.out.println("Opening file" + args[0] + ".");
            userFileStream = new FileInputStream(args[0]);
            inFS = new Scanner (userFileStream);
            lineCounter = new Scanner (userFileStream);
        } catch (FileNotFoundException INF) {
            System.out.println("Unable to access input file: " + args[0]);
            System.exit(1);
         }

        PrintWriter outFS = null;

        try {
            userOutputStream = new FileOutputStream(args[1]);
            outFS = new PrintWriter(userOutputStream);
        } catch (FileNotFoundException ONF) {
            System.out.println("Cannot create output file");
            System.exit(3);
        }

        path = Path.of(args[1]);

        if (Files.exists(path) == true) {
            System.out.println(args[1] + " exists - OK to overwrite");
            System.out.print ("(y,n)?: ");
            String userOverwriteResponse = scnr.next();
            if (userOverwriteResponse.charAt(0) != ('y') && (userOverwriteResponse.charAt(0) != 'Y')) {
                System.exit(4);
            }
        }
        int lineCount = getNumberOfLines(lineCounter);
        lineCounter.close();
        String[] itemIdList = new String[lineCount];
        String[] itemNameList = new String[lineCount];
        int[] itemAmountList = new int[lineCount];

        inputInventory(inFS, itemIdList, itemNameList, itemAmountList);


        while (menuSelectionPhase) {

            option = menu(scnr);

            if (option == 'L') {
                System.out.println (getList(itemIdList, itemNameList, itemAmountList));
            }

            else if (option == 'S') {
                System.out.print("Item name (is/contains): ");
                String searchTerm = scnr.next();
                System.out.println();
                searchByName(itemIdList, itemNameList, itemAmountList, searchTerm);
            }

            else if (option == 'P') {
                System.out.println("TODO: Implement Purchase Item method");
            }

            else if (option == 'Q') {
                outputInventory(outFS, itemIdList, itemNameList, itemAmountList);
                System.exit(0);
            }

            else { 
                System.out.println("Invalid option");
            }

        }
    }

    public static char menu(Scanner scnr) {
        char userOption;
        System.out.println("Sales Program - Please choose an option.");            
        System.out.println();
        System.out.println("L - List items");
        System.out.println("S - Search by item name");
        System.out.println("P - Purchase item");
        System.out.println("Q - Quit");
        System.out.println();
        System.out.print("Option: ");
        userOption = scnr.next().charAt(0);
        Character.toUpperCase(userOption);
        return userOption; 
    }
}