package org.fdiez.usecases;

import org.fdiez.datalayer.Stock;
import org.fdiez.gateways.DataGateway;
import org.fdiez.globals.Context;
import org.fdiez.globals.QueryInterval;
import org.fdiez.usecases.utils.StockAssembler;
import org.fdiez.usecases.utils.StockParser;

import java.time.LocalDate;
import java.util.List;

public class HistoricalStockUseCase implements HistoricalUseCase {

    private final StockParser stockParser;
    private final DataGateway internetGatewayMapper;
    private final StockAssembler stockAssembler;

    public HistoricalStockUseCase(Context context) {
        this.internetGatewayMapper = context.getInternetGatewayMapper();
        this.stockParser = context.getStockParser();
        this.stockAssembler = context.getStockAssembler();
    }

    @Override
    public List<Stock> getValues(String ticker, LocalDate intialDate, LocalDate endDate, QueryInterval interval) {
        internetGatewayMapper.getHistoricalQuote();

        return null;
    }
}
