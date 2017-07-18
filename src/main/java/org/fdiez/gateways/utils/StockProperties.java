package org.fdiez.gateways.utils;

import java.util.Arrays;
import java.util.List;

public class StockProperties {

    private static final List<QuotesProperty> quotesProperties = Arrays.asList(
            QuotesProperty.NAME,
            QuotesProperty.SYMBOL,
            QuotesProperty.CURRENCY,
            QuotesProperty.STOCK_EXCHANGE,
            QuotesProperty.ASK,
            QuotesProperty.ASK_REALTIME,
            QuotesProperty.ASK_SIZE,
            QuotesProperty.BID,
            QuotesProperty.BID_REALTIME,
            QuotesProperty.BID_SIZE,
            QuotesProperty.LAST_TRADE_PRICE_ONLY,
            QuotesProperty.LAST_TRADE_SIZE,
            QuotesProperty.LAST_TRADE_DATE,
            QuotesProperty.LAST_TRADE_TIME,
            QuotesProperty.OPEN,
            QuotesProperty.PREVIOUS_CLOSE,
            QuotesProperty.DAYS_LOW,
            QuotesProperty.DAYS_HIGH,
            QuotesProperty.VOLUME,
            QuotesProperty.AVERAGE_DAILY_VOLUME,
            QuotesProperty.YEAR_HIGH,
            QuotesProperty.YEAR_LOW,
            QuotesProperty.FIFTY_DAY_MOVING_AVERAGE,
            QuotesProperty.TWO_HUNDRED_DAY_MOVING_AVERAGE,
            QuotesProperty.SHARES_OUTSTANDING,
            QuotesProperty.SHARES_OWNED,
            QuotesProperty.MARKET_CAPITALIZATION,
            QuotesProperty.SHARES_FLOAT,
            QuotesProperty.DIVIDEND_PAY_DATE,
            QuotesProperty.EX_DIVIDEND_DATE,
            QuotesProperty.TRAILING_ANNUAL_DIVIDEND_YIELD,
            QuotesProperty.TRAILING_ANNUAL_DIVIDEND_YIELD_IN_PERCENT,
            QuotesProperty.DILUTED_EPS,
            QuotesProperty.EPS_ESTIMATE_CURRENT_YEAR,
            QuotesProperty.EPS_ESTIMATE_NEXT_QUARTER,
            QuotesProperty.EPS_ESTIMATE_NEXT_YEAR,
            QuotesProperty.PE_RATIO,
            QuotesProperty.PEG_RATIO,
            QuotesProperty.PRICE_BOOK,
            QuotesProperty.PRICE_SALES,
            QuotesProperty.BOOK_VALUE_PER_SHARE,
            QuotesProperty.REVENUE,
            QuotesProperty.EBITDA,
            QuotesProperty.ONE_YEAR_TARGET_PRICE,
            QuotesProperty.SHORT_RATIO);

    public static List<QuotesProperty> getDefaultProperties() {
        return quotesProperties;
    }

    public static int getPropertyIndex(QuotesProperty property) {
        return quotesProperties.indexOf(property);
    }

}
