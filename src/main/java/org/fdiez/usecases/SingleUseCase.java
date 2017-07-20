package org.fdiez.usecases;

import org.fdiez.datalayer.Stock;

public interface SingleUseCase {
    Stock getValue(String ticker);
}
