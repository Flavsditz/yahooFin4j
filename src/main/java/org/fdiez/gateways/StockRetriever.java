package org.fdiez.gateways;

import org.fdiez.datalayer.Stock;
import org.fdiez.usecases.QuoteUseCase;
import org.fdiez.usecases.SingleStockUseCase;

public class StockRetriever {
    public static Stock get(String ticker) {
        QuoteUseCase useCase = new SingleStockUseCase();
        return useCase.getQuote(ticker);
    }

    public static void main(String[] args) {
        final Stock stock = get("TSLA");

        System.out.println("stock = " + stock);
    }
}
