package org.fdiez.usecases;

import org.fdiez.datalayer.Stock;
import org.fdiez.globals.QueryInterval;

import java.time.LocalDate;
import java.util.List;

public interface HistoricalUseCase {
    List<Stock> getValues(String ticker, LocalDate intialDate, LocalDate endDate, QueryInterval interval);
}
