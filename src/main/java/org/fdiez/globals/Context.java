package org.fdiez.globals;

import org.fdiez.gateways.DataGateway;

public class Context {
    private static DataGateway internetGatewayMapper = new DataGateway();

    public static DataGateway getInternetGatewayMapper() {
        return internetGatewayMapper;
    }
}
