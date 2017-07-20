package org.fdiez.gateways;

import org.fdiez.datalayer.Stock;
import org.fdiez.globals.QueryInterval;

import java.time.LocalDate;
import java.util.List;

public class StockDailyRetriever extends StockRetriever {


    public StockDailyRetriever(String ticker) {
        super(ticker);
    }

    public static void main(String[] args) {
        StockRetriever stockRetriever = new StockDailyRetriever("TSLA");
        final Stock stock = stockRetriever.getLatest();

        System.out.println("stock = " + stock);
    }

    @Override
    List<Stock> getFromUntil(LocalDate initialDate, LocalDate endDate) {
        return makeHistoricalQuery(initialDate, endDate, QueryInterval.DAILY);
    }
}
