package org.fdiez.usecases;

public class StockUseCase implements QuoteUseCase {

    @Override
    public void getQuote(String ticker) {
        throw new IllegalArgumentException();
    }
}
