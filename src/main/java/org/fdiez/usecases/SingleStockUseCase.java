package org.fdiez.usecases;

import org.fdiez.datalayer.Stock;
import org.fdiez.gateways.utils.QuotesProperty;
import org.fdiez.globals.Context;
import org.fdiez.parser.StockParser;

import java.util.HashMap;
import java.util.List;

public class SingleStockUseCase implements QuoteUseCase {

    private final StockParser stockParser;

    public SingleStockUseCase() {
        stockParser = new StockParser();
    }

    @Override
    public Stock getQuote(String ticker) {
        List<String> receivedData = Context.getInternetGatewayMapper().getSingleQuote(ticker);

        final HashMap<QuotesProperty, String> map = stockParser.parseQuote(receivedData);


        //TODO: extract to builder
        Stock.Builder builder = new Stock.Builder(map.get(QuotesProperty.SYMBOL));
        builder.withCurrency(map.get(QuotesProperty.CURRENCY))
                .withName(map.get(QuotesProperty.NAME))
                .withExchange(map.get(QuotesProperty.STOCK_EXCHANGE));

        return builder.build();
    }
}
