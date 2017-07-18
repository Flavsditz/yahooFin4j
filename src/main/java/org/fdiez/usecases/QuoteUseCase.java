package org.fdiez.usecases;

import org.fdiez.datalayer.Stock;

public interface QuoteUseCase {
    Stock getQuote(String ticker);
}
