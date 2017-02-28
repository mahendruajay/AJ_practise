package com.playground.Miscellaneous;

public class TaxValue {
    private double bracket;
    private double rate;

    public TaxValue(double bracket, double rate) {
        this.bracket = bracket;
        this.rate = rate;
    }

    public double getBracket() {
        return bracket;
    }

    public void setBracket(double bracket) {
        this.bracket = bracket;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

}
