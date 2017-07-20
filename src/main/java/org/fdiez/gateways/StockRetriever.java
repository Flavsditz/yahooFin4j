package org.fdiez.gateways;

import org.fdiez.datalayer.Stock;
import org.fdiez.globals.Context;
import org.fdiez.usecases.QuoteUseCase;
import org.fdiez.usecases.SingleStockUseCase;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class StockRetriever {
    public static Stock get(String ticker) {
        QuoteUseCase useCase = new SingleStockUseCase(Context.getInstance());
        return useCase.getQuote(ticker);
    }

    public static List<Stock> getTTM(String ticker) {
        return null;
    }

    public static List<Stock> getLast(String ticker, Period period) {

        return null;
    }

    public static List<Stock> getFromNowUntil(String ticker, LocalDate initialDate) {
        return null;
    }

    public static List<Stock> getFromUntil(String ticker, LocalDate initialDate, LocalDate endDate) {
        return null;
    }





    public static void main(String[] args) {
        final Stock stock = get("TSLA");

        System.out.println("stock = " + stock);
    }
}
