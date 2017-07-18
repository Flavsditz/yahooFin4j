package org.fdiez.usecases;

import org.fdiez.datalayer.Stock;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StockUseCaseTest {

    @Test
    public void validTickerReturnStockQuoteForTicker() {
        QuoteUseCase useCase = new SingleStockUseCase();

        final String tslaTicker = "TSLA";
        Stock stockQuote = useCase.getQuote(tslaTicker);

        assertThat(stockQuote.getTicker(), is(tslaTicker));
    }
}
