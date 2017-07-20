package org.fdiez.usecases;

import org.fdiez.datalayer.Stock;
import org.fdiez.gateways.DataGateway;
import org.fdiez.gateways.utils.QuotesProperty;
import org.fdiez.globals.Context;
import org.fdiez.usecases.utils.StockAssembler;
import org.fdiez.usecases.utils.StockParser;

import java.util.HashMap;
import java.util.List;


public class SingleStockUseCase implements QuoteUseCase {

    private final StockParser stockParser;
    private final DataGateway internetGatewayMapper;
    private final StockAssembler stockAssembler;

    public SingleStockUseCase(Context context) {
        this.internetGatewayMapper = context.getInternetGatewayMapper();
        this.stockParser = context.getStockParser();
        this.stockAssembler = context.getStockAssembler();
    }

    @Override
    public Stock getQuote(String ticker) {
        List<String> receivedData = internetGatewayMapper.getSingleQuote(ticker);

        final HashMap<QuotesProperty, String> map = stockParser.parseQuote(receivedData);

        return stockAssembler.assemble(map);
    }
}
