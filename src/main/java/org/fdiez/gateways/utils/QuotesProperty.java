package org.fdiez.gateways.utils;

public enum QuotesProperty {
    AFTER_HOURS_CHANGE_REALTIME("c8", false),
    ANNUALIZED_GAIN("g3", false),
    ASK("a", true),
    ASK_REALTIME("b2", false),
    ASK_SIZE("a5", true),
    AVERAGE_DAILY_VOLUME("a2", true),
    BID("b", true),
    BID_REALTIME("b3", false),
    BID_SIZE("b6", true),
    BOOK_VALUE_PER_SHARE("b4", true),
    CHANGE("c1", false),
    CHANGE_CHANGE_IN_PERCENT("c", false),
    CHANGE_FROM_FIFTYDAY_MOVING_AVERAGE("m7", false),
    CHANGE_FROM_TWO_HUNDREDDAY_MOVING_AVERAGE("m5", false),
    CHANGE_FROM_YEAR_HIGH("k4", false),
    CHANGE_FROM_YEAR_LOW("j5", false),
    CHANGE_IN_PERCENT("p2", false),
    CHANGE_IN_PERCENT_REALTIME("k2", false),
    CHANGE_REALTIME("c6", false),
    COMMISSION("c3", false),
    CURRENCY("c4", false),
    DAYS_HIGH("h", true),
    DAYS_LOW("g", true),
    DAYS_RANGE("m", false),
    DAYS_RANGE_REALTIME("m2", false),
    DAYS_VALUE_CHANGE("w1", false),
    DAYS_VALUE_CHANGE_REALTIME("w4", false),
    DIVIDEND_PAY_DATE("r1", true),
    TRAILING_ANNUAL_DIVIDEND_YIELD("d", true),
    TRAILING_ANNUAL_DIVIDEND_YIELD_IN_PERCENT("y", true),
    DILUTED_EPS("e", true),
    EBITDA("j4", true),
    EPS_ESTIMATE_CURRENT_YEAR("e7", true),
    EPS_ESTIMATE_NEXT_QUARTER("e9", true),
    EPS_ESTIMATE_NEXT_YEAR("e8", true),
    EX_DIVIDEND_DATE("q", true),
    FIFTY_DAY_MOVING_AVERAGE("m3", true),
    SHARES_FLOAT("f6", true),
    HIGH_LIMIT("l2", false),
    HOLDINGS_GAIN("g4", false),
    HOLDINGS_GAIN_PERCENT("g1", false),
    HOLDINGS_GAIN_PERCENT_REALTIME("g5", false),
    HOLDINGS_GAIN_REALTIME("g6", false),
    HOLDINGS_VALUE("v1", false),
    HOLDINGS_VALUE_REALTIME("v7", false),
    LAST_TRADE_DATE("d1", false),
    LAST_TRADE_PRICE_ONLY("l1", false),
    LAST_TRADE_REALTIME_WITH_TIME("k1", false),
    LAST_TRADE_SIZE("k3", true),
    LAST_TRADE_TIME("t1", false),
    LAST_TRADE_WITH_TIME("l", false),
    LOW_LIMIT("l3", false),
    MARKET_CAPITALIZATION("j1", true),
    MARKET_CAP_REALTIME("j3", false),
    MORE_INFO("i", false),
    NAME("n", false),
    NOTES("n4", false),
    ONE_YEAR_TARGET_PRICE("t8", true),
    OPEN("o", true),
    ORDER_BOOK_REALTIME("i5", false),
    PEG_RATIO("r5", true),
    PE_RATIO("r", true),
    PE_RATIO_REALTIME("r2", false),
    PERCENT_CHANGE_FROM_FIFTY_DAY_MOVING_AVERAGE("m8", false),
    PERCENT_CHANGE_FROM_TWO_HUNDRED_DAY_MOVING_AVERAGE("m6", false),
    CHANGE_IN_PERCENT_FROM_YEAR_HIGH("k5", false),
    PERCENT_CHANGE_FROM_YEAR_LOW("j6", false),
    PREVIOUS_CLOSE("p", true),
    PRICE_BOOK("p6", true),
    PRICE_EPS_ESTIMATE_CURRENT_YEAR("r6", false),
    PRICE_EPS_ESTIMATE_NEXT_YEAR("r7", false),
    PRICE_PAID("p1", false),
    PRICE_SALES("p5", true),
    REVENUE("s6", true),
    SHARES_OWNED("s1", true),
    SHARES_OUTSTANDING("j2", true),
    SHORT_RATIO("s7", true),
    STOCK_EXCHANGE("x", false),
    SYMBOL("s", false),
    TICKER_TREND("t7", false),
    TRADE_DATE("d2", false),
    TRADE_LINKS("t6", false),
    TRADE_LINKS_ADDITIONAL("f", false),
    TWO_HUNDRED_DAY_MOVING_AVERAGE("m4", true),
    VOLUME("v", true),
    YEAR_HIGH("k", true),
    YEAR_LOW("j", true),
    YEAR_RANGE("w", false);

    private final String tag;
    private final boolean padded;

    QuotesProperty(String tag, boolean padded) {
        this.tag = tag;
        this.padded = padded;
    }

    public String getTag() {
        return this.tag;
    }

    public boolean isPadded() {
        return padded;
    }
}

