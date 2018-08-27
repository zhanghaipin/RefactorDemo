package rentalstore;

public class Movie {
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    public static final int CHILDRENS = 2;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }


    //Refactoring V2:move amountFor() method
    public double amountFor(int rentalDay)
    {
        double thisAmount=0.0;
        switch(getPriceCode())
        {
            case Movie.REGULAR:
                thisAmount += 2;
                if(rentalDay>2)
                    thisAmount += (rentalDay-2)*1.5;
                break;

            case Movie.NEW_RELEASE:
                thisAmount += rentalDay*3;
                break;

            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if(rentalDay>3)
                    thisAmount += (rentalDay-3)*1.5;
                break;
        }

        return thisAmount;
    }

    //Extract calculate from Customer to Rental class
    public int getFrequentRenterPoints(int rentalDay) {
        if((getPriceCode()==Movie.NEW_RELEASE)&&rentalDay>1)
        {
            return 2;
        }
        return 1;
    }
}
