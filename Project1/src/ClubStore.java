import java.util.*;
public class ClubStore{
    public static final int CURRENT_YEAR = 2022;
    public static final int BOTTLE_PRICE = 10;
    public static final int MUG_PRICE = 12;
    public static final int BAG_PRICE = 18;
    public static final int OCTOBER = 10;
    public static final int NOVEMBER = 11;
    public static final int DECEMBER = 12;
    /**
     * @return shippingCost: The price of shipping given the provided order amount.
     * returns 0 if subtotal is 0
     * @param subtotal The order ammount without shipping
     * @param hasValidCoupon A boolean that is set to true if the customer has entered code "PACK2022"
     * @param twoDayShipping A boolean that is true if the user has two day shipping
     */
    public static int getShippingCost(int subtotal, boolean twoDayShipping, boolean hasValidCoupon) {
        if (subtotal < 0){
            throw new IllegalArgumentException("Invalid subtotal");
        }
        int shippingCost;
        if (subtotal >= 25 || hasValidCoupon) {
            shippingCost = 0;
        }
        else {
            shippingCost = 3;
        }
        if (twoDayShipping) {
            shippingCost = 5;
        }
        if (subtotal == 0) {
            shippingCost = 0;
        }
        return shippingCost;
    }

    /**
     * @param month the user inputted month.
     * @param day the user inputted day.
     * @return Returns true, if the date is a valid date between October 
     * 15 and November 30, inclusive.
     * Returns false otherwise.
     */
    public static boolean isValidDate(int month, int day){
        boolean validDate = true;
        if (month <= 0 || day <= 0){
            validDate = false;
        }
        else if ((month < OCTOBER || ((month == OCTOBER) && (day < 15))) || ((month > NOVEMBER) || ((month == NOVEMBER) && (day > 30)))) {
           validDate = false;
        }
        return validDate;
    }

    /**
     * @return arrivalDate a String containing the day of the week (Sun, Mon, Tue, 
     * Wed, Thu, Fri, Sat), month, day, and year an order will arrive based on the orderMonth, 
     * orderDay, the numberOfShippingDays, and a year of 2022. For example, "Thu, 10/20/2022" or
     *"Mon, 12/5/2022"
     *Throw an IllegalArgumentException with the message, "Invalid date", if the 
     *orderMonth/orderDay is not a valid date between October 15 and November 30, inclusive. 
     * @param orderMonth user input integer
     * @param orderDay user input integer
     * @param numberOfShippingDays integer telling program how many days to advance by
     */
    public static String getArrivalDate(int orderMonth, int orderDay, int numberOfShippingDays) {
        String arrivalDate = "xyz";
        if ((orderMonth < OCTOBER || ((orderMonth == OCTOBER) && (orderDay < 15))) || ((orderMonth > NOVEMBER) || ((orderMonth == NOVEMBER) && (orderDay > 30)))) {
            throw new IllegalArgumentException("Invalid date");
         }
        if (!(numberOfShippingDays >= 1) || !(numberOfShippingDays <= 5)) {
            throw new IllegalArgumentException("Invalid days");
        }
        orderDay += numberOfShippingDays;
        if ((orderMonth == OCTOBER) && (orderDay > 31)) {
            orderMonth = NOVEMBER;
            orderDay = (orderDay - 31);
        }
        if ((orderMonth == NOVEMBER) && (orderDay > 30)) {
            orderMonth = DECEMBER;
            orderDay = (orderDay - 30);
        }

        int w = CURRENT_YEAR - (14 - orderMonth) / 12;
        int x = w + w / 4 - w / 100 + w / 400;
        int z = orderMonth +  12 * ((14 - orderMonth) / 12) - 2;
        int numDayOfWeek = (orderDay + x + (31 * z) / 12) % 7;
        String dayOfWeek = "xyz";
        switch (numDayOfWeek) {
            case (0):
            dayOfWeek = "Sun";
            break;

            case (1):
            dayOfWeek = "Mon";
            break;
            
            case (2):
            dayOfWeek = "Tue";
            break;

            case (3):
            dayOfWeek = "Wed";
            break;

            case (4):
            dayOfWeek = "Thu";
            break;

            case (5):
            dayOfWeek = "Fri";
            break;

            case (6):
            dayOfWeek = "Sat";
            break;

        }
    arrivalDate = (dayOfWeek + ", " + orderMonth + "/" + orderDay + "/" + CURRENT_YEAR);
        return arrivalDate;
    }
        

    /**
     * @return subtotal the raw price of the selected items without shipping
     * @param numberOfBottles the desired amount of purchased bottles
     * @param numberOfMugs the desired amount of purchased mugs
     * @param numberOfBags the desired amount of purchased bags
     */
    public static int getSubtotal(int numberOfBottles, int numberOfMugs, int numberOfBags) {
        if (numberOfBottles < 0 || numberOfBags < 0 || numberOfMugs < 0){
            throw new IllegalArgumentException("Invalid number");
        }
        int subtotal = 0;
        int finalBottlePrice = numberOfBottles * BOTTLE_PRICE;
        int finalMugPrice = numberOfMugs * MUG_PRICE;
        int finalBagPrice = numberOfBags * BAG_PRICE;
        subtotal = finalBottlePrice + finalMugPrice + finalBagPrice;
        return subtotal;
    }

    public static void main (String [] args){
        Scanner scnr = new Scanner(System.in);
        int shipDays = 0;
        int userMonth = 0;
        int userDay = 0;
        int numberOfBottles = 0;
        int numberOfMugs = 0;
        int numberOfBags = 0;
        char rawShippingType = 'x';
        char shippingType = 'x';
        char rawCouponStatus = 'x';
        char couponStatus = 'x';
        boolean validCoupon = false;
        boolean twoDayShipping = false;
        int finalSubtotal = 0;
        int finalShippingCost = 0;
        String coupon = "PACK2022";

        System.out.println ("                    Welcome to our Club Store!"); 
        System.out.println ("All orders must be placed between October 15 and November 30, 2022.");
        System.out.println ("When prompted, please enter today's date and the number of each");
        System.out.println ("item you would like to purchase. Please enter S to choose Standard");
        System.out.println ("(five-day) shipping or T to choose Two-day shipping. Orders of");
        System.out.println ("$25.00 or more receive free Standard shipping. Entering the correct");
        System.out.println ("coupon code also entitles you to free Standard shipping! A receipt");
        System.out.println ("and the arrival date of your order will be displayed.");
        System.out.println ("");
        System.out.print ("Month Day (e.g., 11 9): ");
        userMonth = scnr.nextInt();
        userDay = scnr.nextInt();
        if (isValidDate(userMonth, userDay) == false) {
            System.out.print("Invalid date.");
            System.exit(0);
        }
        String finalArrivalDate = "xyz";
        System.out.print("Number of Water Bottles($10.00 each): ");
        numberOfBottles = scnr.nextInt();
        System.out.print("Number of Coffee Mugs($12.00 each): ");
        numberOfMugs = scnr.nextInt();
        System.out.print("Number of Tote Bags($18.00 each): ");
        numberOfBags = scnr.nextInt();
        finalSubtotal = getSubtotal(numberOfBottles, numberOfMugs, numberOfBags);
        if (finalSubtotal != 0) {
            System.out.print("Shipping (S-tandard, T-wo Day): ");
            rawShippingType = scnr.next().charAt(0);
            shippingType = Character.toUpperCase(rawShippingType);

            if ((shippingType != 'T') && (shippingType != 'S')) {
                System.out.println("Invalid shiping");
                System.exit(0);
            }
            else if (shippingType == 'T') {
                twoDayShipping = true;
                shipDays = 2;
            }
            else if (shippingType == 'S') {
                shipDays = 5;
                System.out.print("Coupon (y,n): ");
                rawCouponStatus = scnr.next().charAt(0);
                couponStatus = Character.toUpperCase(rawCouponStatus);
                if (couponStatus == 'Y') {
                    System.out.print("Coupon Code: ");
                    String userCode = scnr.next();
                    if (userCode.equals(coupon)) {
                        validCoupon = true;
                    }
                    else {
                        System.out.println("Invalid code");
                    }
                }

            }
        }
        finalArrivalDate = getArrivalDate(userMonth, userDay, shipDays);
        finalShippingCost = getShippingCost(finalSubtotal, twoDayShipping, validCoupon);
        System.out.println();
        System.out.println("Subtotal: " + finalSubtotal);
        System.out.println("Shipping: " + finalShippingCost);
        System.out.println("Total: " + (finalSubtotal + finalShippingCost));
        System.out.println("Arrival Date: " + finalArrivalDate);
        
    }
}