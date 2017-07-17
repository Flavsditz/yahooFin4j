package org.fdiez.usecases;

import org.fdiez.datalayer.StockQuote;
import org.fdiez.globals.Context;

public class StockUseCase implements QuoteUseCase {

    @Override
    public StockQuote getQuote(String ticker) {
        return Context.getInternetGatewayMapper().getSingleQuote(ticker);
    }
}
