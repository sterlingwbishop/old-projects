public class Symbol {
    private String name;
    private int points;
    private boolean hasBeenClickedOn;

    /*
     * Handles the objects that the user will click on. The "Moles"
     * @author Sterling Bishop
     * @param name is the name given to the symbol
     * @param points is the number of points that symbol is worth
     */

    public Symbol(String name, int points) {
        if (name == null) {
            throw new IllegalArgumentException("Null name");
        }

        if (points < 1) {
            throw new IllegalArgumentException("Invalid points");
        }

        this.name = name;
        this.points = points;

        this.hasBeenClickedOn = false;
    }

    /*
     * @author Sterling Bishop
     * @return the name of the symbol
     */

    public String getName() {
        return name;
    }

    /*
     * @author Sterling Bishop
     * @return the number of points the symbol is worth
     */

    public int getPoints() {
        return points;
    }

    /*
     * @author Sterling Bishop
     * @return a boolean that tells if a symbol has been clicked on or not
     */

    public boolean hasBeenClickedOn() {
        return hasBeenClickedOn;
    }

    /*
     * @author Sterling Bishop
     * @param hasBeenClickedOn the desired setting for the clicked boolean
     */

    public void setHasBeenClickedOn(boolean hasBeenClickedOn) {
        this.hasBeenClickedOn = hasBeenClickedOn;
    }

    /*
     * @author Sterling Bishop
     * @param o is the Symbol that we are checking
     * @return true if the o matches Symbol other
     */

    public boolean equals (Object o) {
        if (o instanceof Symbol) {
            Symbol other = (Symbol) o;
            if ((other.name.equals(this.name)) && (other.points == this.points) && (other.hasBeenClickedOn == this.hasBeenClickedOn)) {
                return true;
            }
            }
        else {
            return false;
        }
        return false;
    }

    /*
     * @author Sterling Bishop
     * @return toString returns a symbol in the format "cat 24 false"
     */

    public String toString() {
        return (name + " " + points + " " + hasBeenClickedOn);
    }
}
