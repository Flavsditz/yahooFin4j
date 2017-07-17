package org.fdiez.usecases;

import org.fdiez.datalayer.StockQuote;

public interface QuoteUseCase {
    StockQuote getQuote(String ticker);
}
