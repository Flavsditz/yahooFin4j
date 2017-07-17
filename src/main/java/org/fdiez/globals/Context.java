package org.fdiez.globals;

import org.fdiez.gateways.InternetGateway;

public class Context {
    private static InternetGateway internetGatewayMapper = new InternetGateway();

    public static InternetGateway getInternetGatewayMapper() {
        return internetGatewayMapper;
    }
}
