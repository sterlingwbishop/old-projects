import java.util.Random;

public class WhackaMole {
    public static final int ROWS = 5;

    public static final int COLS = 5;
    
    public static final String[][] SYMBOL_NAMES = {{"cat", "dog", "tiger", "frog", "cat"}, 
                                                   {"tiger", "lion", "dog", "tiger", "frog"},
                                                   {"lion", "frog", "mole",  "dog", "cat"},
                                                   {"frog", "dog", "tiger", "cat", "lion"},
                                                   {"cat", "frog", "lion", "dog", "tiger"}};
                                                    
    
    public static final int[][] SYMBOL_POINTS = {{10, 15, 30, 20, 10},
                                                 {30, 40, 15, 30, 20},
                                                 {40, 20, 50, 15, 10},
                                                 {20, 15, 30, 10, 40},
                                                 {10, 20, 40, 15, 30}};
    private boolean testing;
    private int totalScore = 0;
    private int numberOfMisses = 0;
    private Grid grid;
    private Random rand;
    private int nextRow = 0;
    private int nextCol = 0;

    /*
     * Handles the internal logic of the game
     * @author Sterling Bishop
     * @param testing determines if the program will launch in testing mode
     */

    public WhackaMole(boolean testing) {
        Symbol temp;
        this.testing = testing;
        grid = new Grid(ROWS, COLS);
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                temp = new Symbol(SYMBOL_NAMES[i][j], SYMBOL_POINTS[i][j]);
                grid.setSymbol(i, j, temp);
            }
        }
        
        rand = new Random();

        if (testing == true) {
            nextRow = 0;
            nextCol = 0;
        }

        else {
            nextCol = rand.nextInt(4);
            nextRow = rand.nextInt(4);
        }

    }

     /*
     * @author Sterling Bishop
     * @return totalScore the current number of points
     */

    public int getTotalScore() {
        return totalScore;
    }

    /*
     * @author Sterling Bishop
     * @return number of misses the current number of misses
     */

    public int getNumberOfMisses() {
        return numberOfMisses;
    }

    /*
     * @author Sterling Bishop
     * @return nextRow the current value of nextRow
     */

    public int getNextRow() {
        return nextRow;
    }

    /*
     * @author Sterling Bishop
     * @return nextCol the current value of next Col
     */

    public int getNextCol() {
        return nextCol;
    }

    /*
     * @author Sterling Bishop
     * @param row the row at which the Symbol is stored
     * @param col the column at which the Symbol is stored
     * @return requestedSymbol.getName() the name of the symbol at the requested location
     */

    public String getSymbolName(int row, int col) {

        if ((row < 0)||(row > 4)) {
            throw new IllegalArgumentException("Invalid row");
        }
        if ((col < 0)||(col > 4)) {
            throw new IllegalArgumentException("Invalid col");
        }

        Symbol requestedSymbol = grid.getSymbol(row, col);
        return requestedSymbol.getName();
    }

    /*
     * @author Sterling Bishop
     * @param row the row at which the Symbol is stored
     * @param col the column at which the Symbol is stored
     * @return the point value of the Symbol at the requested location
     */

    public int getSymbolPoints(int row, int col) {
        
        if ((row < 0)||(row > 4)) {
            throw new IllegalArgumentException("Invalid row");
        }
        if ((col < 0)||(col > 4)) {
            throw new IllegalArgumentException("Invalid col");
        }

        Symbol requestedSymbol = grid.getSymbol(row, col);
        return requestedSymbol.getPoints();
    }

    /*
     * @author Sterling Bishop
     * @param row the row at which the Symbol is stored
     * @param col the column at which the Symbol is stored
     * @return true if the Symbol at the requested location has been clicked on
     */

    public boolean hasBeenClickedOn(int row, int col) {

        if ((row < 0)||(row > 4)) {
            throw new IllegalArgumentException("Invalid row");
        }
        if ((col < 0)||(col > 4)) {
            throw new IllegalArgumentException("Invalid col");
        }

        Symbol requestedSymbol = grid.getSymbol(row, col);
        return requestedSymbol.hasBeenClickedOn();

    }

    /*
     * @author Sterling Bishop
     * @return true if all Symbols have been clicked on
     */

    public boolean allSymbolsClickedOn() {
        boolean returnValue = false;
        Symbol tempSymbol;
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                tempSymbol = grid.getSymbol(i, j);
                if (tempSymbol.hasBeenClickedOn() == true) {
                    returnValue = true;
                }
                else {
                    return false;
                }
            }
        }
        return returnValue;
    }

    /*
     * Updates the Row and Column values differently based on if the program is in testing mode
     * @author Sterling Bishop
     */

    private void updateNextRowAndCol() {
        if (allSymbolsClickedOn()) {
            nextCol = -1;
            nextRow = -1;
        }

        else if (testing) {
            if (grid.getSymbol(nextRow, nextCol).hasBeenClickedOn()) {
                while(grid.getSymbol(nextRow, nextCol).hasBeenClickedOn()) {
                    if (nextCol == (COLS -1)) {
                        if (nextRow == (ROWS-1)) {
                            break;
                        }
                        nextRow += 1;
                        nextCol = 0;
                    }
                    else {
                        nextCol += 1;
                    }
                }
            }
            else if (!grid.getSymbol(nextRow, nextCol).hasBeenClickedOn()) {
                
                if (nextCol == (COLS - 1)) {
                    if (nextRow == (ROWS - 1)) {
                    }
                    else {
                        nextRow += 1;
                        nextCol = 0;
                    }
                }
                else {
                    nextCol += 1;
                }
            }

        }

        else {
            nextCol = rand.nextInt(4);
            nextRow = rand.nextInt(4);
        }
    }

    /*
     * Changes the hasBeenClickedOn value of the object at the designated location to true
     * @author Sterling Bishop
     * @param row is the row of the symbol that is being clicked
     * @param col is the column of the symbol that is being clicked
     */

    public void clickOnSymbol(int row, int col) {
        if ((row < 0)||(row > 4)) {
            throw new IllegalArgumentException("Invalid row");
        }
        if ((col < 0)||(col > 4)) {
            throw new IllegalArgumentException("Invalid col");
        }

        Symbol currSymbol = grid.getSymbol(row, col);
        if (currSymbol.hasBeenClickedOn() == false) {
            currSymbol.setHasBeenClickedOn(true);
            totalScore += currSymbol.getPoints();
            updateNextRowAndCol();
        }
    }

    /*
     * Increases the number of misses when the user misses
     * @author Sterling Bishop
     */

    public void addMiss() {
        numberOfMisses += 1;
        updateNextRowAndCol();
    }

    /*
     * @author Sterling Bishop
     * @return grid the grid on which the symbols will be placed
     */

    public Grid getGrid() {
        return grid;
    }

}
