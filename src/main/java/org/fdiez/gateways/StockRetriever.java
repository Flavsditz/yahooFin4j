package org.fdiez.gateways;

import org.fdiez.datalayer.Stock;
import org.fdiez.globals.Context;
import org.fdiez.globals.QueryInterval;
import org.fdiez.usecases.HistoricalStockUseCase;
import org.fdiez.usecases.HistoricalUseCase;
import org.fdiez.usecases.SingleStockUseCase;
import org.fdiez.usecases.SingleUseCase;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public abstract class StockRetriever {
    final String ticker;

    public StockRetriever(String ticker) {
        this.ticker = ticker;
    }

    public Stock getLatest() {
        SingleUseCase useCase = new SingleStockUseCase(Context.getInstance());
        return useCase.getValue(ticker);
    }

    public List<Stock> getTTM() {
        return getLast(Period.ofMonths(12));
    }

    public List<Stock> getLast(Period period) {
        LocalDate endDate = LocalDate.now();
        LocalDate initialDate = endDate.minus(period);
        return getFromUntil(initialDate, endDate);
    }

    public List<Stock> getFromUntilNow(LocalDate initialDate) {
        LocalDate endDate = LocalDate.now();
        return getFromUntil(initialDate, endDate);
    }

    abstract List<Stock> getFromUntil(LocalDate initialDate, LocalDate endDate);

    List<Stock> makeHistoricalQuery(LocalDate initialDate, LocalDate endDate, QueryInterval interval) {
        HistoricalUseCase useCase = new HistoricalStockUseCase(Context.getInstance());
        return useCase.getValues(ticker, initialDate, endDate, interval);
    }
}
