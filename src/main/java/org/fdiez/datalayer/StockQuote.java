package org.fdiez.datalayer;

public class StockQuote {
    private final String ticker;

    public StockQuote(String ticker) {
        this.ticker = ticker;
    }

    public String getTicker() {
        return ticker;
    }
}
