package org.fdiez.usecases;

import org.fdiez.datalayer.Stock;
import org.fdiez.globals.Context;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StockUseCaseTest {

    private Context context;

    @BeforeClass
    public void setUpBeforeClass() {
        context = Mockito.mock(Context.class);
//        Mockito.when(context.getInternetGatewayMapper()).then()
    }

    @Test
    public void validTickerReturnStockQuoteForTicker() {
        SingleUseCase useCase = new SingleStockUseCase(context);

        final String tslaTicker = "TSLA";
        Stock stockQuote = useCase.getValue(tslaTicker);

        assertThat(stockQuote.getTicker(), is(tslaTicker));
    }
}
