package org.fdiez.usecases;

import org.junit.Test;

public class StockUseCaseTest {

    @Test(expected = IllegalArgumentException.class)
    public void invalidTickerThrowsException() {
        QuoteUseCase useCase = new StockUseCase();
        useCase.getQuote("ZZZZ");
    }
}
