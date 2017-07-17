package org.fdiez.gateways;

import org.fdiez.datalayer.StockQuote;

public class InternetGateway {

    public StockQuote getSingleQuote(String ticker) {
        return new StockQuote(ticker);
    }
}
