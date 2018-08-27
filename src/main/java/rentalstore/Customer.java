package rentalstore;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg){
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement(){
        Enumeration rentals = this.rentals.elements();
        String result = "Rental Record for " + getName() + "\n";
        while(rentals.hasMoreElements()){
            Rental each = (Rental) rentals.nextElement();

            //Refactoring V1:Extract Method replace switch case
            //thisAmount = amountFor(each);

            //Refactoring V2:move amountFor() method
            //thisAmount = each.amountFor();

            //Refactoring V3:Replace thisAmount with query method

            //add frequent renter points
            //Refactoring V4:Extract calculate from Customer to Rental class
            //frequentRenterPoints=each.getFrequentRenterPoints();

            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getMovie().amountFor(each.getDayRented())) + "\n";
            //totalAmount += each.amountFor();
        }

        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    //replace temporary variable as method
    private int getTotalFrequentRenterPoints() {
        int points = 0;
        Enumeration rentalss = rentals.elements();
        while(rentalss.hasMoreElements())
        {
            Rental each = (Rental) rentalss.nextElement();
            points += each.getMovie().getFrequentRenterPoints(each.getDayRented());
        }

        return points;
    }

    private double getTotalCharge()
    {
        double result = 0;
        Enumeration rentalss = rentals.elements();
        while(rentalss.hasMoreElements())
        {
            Rental each = (Rental) rentalss.nextElement();
            result += each.getMovie().amountFor(each.getDayRented());
        }
        return result;
    }
}
