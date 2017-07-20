package org.fdiez.gateways;

import org.fdiez.datalayer.Stock;
import org.fdiez.globals.QueryInterval;

import java.time.LocalDate;
import java.util.List;

public class StockWeeklyRetriever extends StockRetriever {
    public StockWeeklyRetriever(String ticker) {
        super(ticker);
    }

    @Override
    List<Stock> getFromUntil(LocalDate initialDate, LocalDate endDate) {
        return makeHistoricalQuery(initialDate, endDate, QueryInterval.WEEKLY);
    }
}
