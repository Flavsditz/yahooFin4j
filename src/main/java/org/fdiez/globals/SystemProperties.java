package org.fdiez.globals;

public interface SystemProperties {
    String QUOTES_BASE_URL = "http://download.finance.yahoo.com/d/quotes.csv";
    String HISTORICAL_QUOTES_BASE_URL = "https://query1.finance.yahoo.com/v7/finance/download/";
    String SCRAPE_URL = "https://finance.yahoo.com/quote/%5EGSPC/options";
    String CRUMB_URL = "https://query1.finance.yahoo.com/v1/test/getcrumb";

    int CONNECTION_TIMEOUT = 10000;
}
