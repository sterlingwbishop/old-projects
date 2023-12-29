public class Grid {
    private int rows;
    private int cols;
    private Symbol[][] symbols = null;

    /*
     * Handles the grid in which Symbols will be stored
     * @author Sterling Bishop
     * @param rows the number of rows the grid has
     * @param cols the number of columns the grid has
     */

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;

        if ((rows < 1) || (cols < 1)) {
            throw new IllegalArgumentException("Invalid rows/cols");
        }

        symbols = new Symbol[rows][cols];
    }

    /*
     * @author Sterling Bishop
     * @return rows the number of rows in the grid
     */

    public int getRows() {
        return rows;
    }

    /*
     * @author Sterling Bishop
     * @return cols the number of columns in the grid
     */

    public int getCols() {
        return cols;
    }

    /*
     * @author Sterling Bishop
     * @param row the desired row to store the symbol in
     * @param col the desired column to store the symbol in
     * @param symbol is the symbol that is being stored
     */

    public void setSymbol(int row, int col, Symbol symbol){
        if (symbol == null) {
            throw new IllegalArgumentException("Null symbol");
        }

        if ((row < 0)||(row >= rows)) {
            throw new IllegalArgumentException("Invalid row");
        }
        
        if ((col < 0)||(col >= cols)) {
            throw new IllegalArgumentException("Invalid col");
        }

        symbols[row][col] = symbol;
    }

    /*
     * @author Sterling Bishop
     * @param row row in which the symbol is stored
     * @param col column in which the symbol is stored
     * @return returns the symbol stored in the given location
     */

    public Symbol getSymbol(int row, int col) {
        if ((row < 0)||(row >= rows)) {
            throw new IllegalArgumentException("Invalid row");
        }
        
        if ((col < 0)||(col >= cols)) {
            throw new IllegalArgumentException("Invalid col");
        }

        return symbols[row][col];
    }

    /*
     * @author Sterling Bishop
     * @return to String returns names as a Comma Serperated List, with the same 
     * number of names per row as the grid
     */

    public String toString() {
        String returnString = "";
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                returnString += symbols[i][j].getName();
                if (j < cols - 1) {
                    returnString += " ";
                }
                if (j == cols - 1) {
                    returnString += "\n";
                }
            }

        }
        return returnString;
    }

}