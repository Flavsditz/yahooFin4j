package org.fdiez.usecases;

import org.fdiez.datalayer.StockQuote;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StockUseCaseTest {

    @Test
    public void validTickerReturnStockQuoteForTicker() {
        QuoteUseCase useCase = new StockUseCase();

        final String tslaTicker = "TSLA";
        StockQuote stockQuote = useCase.getQuote(tslaTicker);

        assertThat(stockQuote.getTicker(), is(tslaTicker));
    }
}
