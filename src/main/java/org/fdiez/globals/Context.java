package org.fdiez.globals;

import org.fdiez.gateways.DataGateway;
import org.fdiez.usecases.utils.StockAssembler;
import org.fdiez.usecases.utils.StockParser;

public class Context {
    private static DataGateway internetGatewayMapper = new DataGateway();
    private static Context instance;

    private Context() {
    }

    public static synchronized Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }

        return instance;
    }

    public DataGateway getInternetGatewayMapper() {
        return internetGatewayMapper;
    }

    public StockParser getStockParser() {
        return new StockParser();
    }

    public StockAssembler getStockAssembler() {
        return new StockAssembler();
    }
}
