package rentalstore;

public class Rental {
    private Movie movie;
    private int dayRented;

    public Rental(Movie movie, int dayRented) {
        this.movie = movie;
        this.dayRented = dayRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDayRented() {
        return dayRented;
    }

    //Refactoring V2:move amountFor() method
    public double amountFor()
    {
        double thisAmount=0.0;
        switch(getMovie().getPriceCode())
        {
            case Movie.REGULAR:
                thisAmount += 2;
                if(getDayRented()>2)
                    thisAmount += (getDayRented()-2)*1.5;
                break;

            case Movie.NEW_RELEASE:
                thisAmount += getDayRented()*3;
                break;

            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if(getDayRented()>3)
                    thisAmount += (getDayRented()-3)*1.5;
                break;
        }

        return thisAmount;
    }
}
