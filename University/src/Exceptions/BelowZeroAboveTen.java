package Exceptions;

public class BelowZeroAboveTen extends Exception{
    private int rate;

    public BelowZeroAboveTen (String message, int value){
        super(message);
        rate = value;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}