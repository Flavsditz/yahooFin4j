package org.fdiez.usecases.utils;

import org.fdiez.datalayer.Dividend;
import org.fdiez.datalayer.Quote;
import org.fdiez.datalayer.Statistics;
import org.fdiez.datalayer.Stock;
import org.fdiez.gateways.utils.QuotesProperty;

import java.util.HashMap;

import static org.fdiez.globals.FormatUtils.*;

public class StockAssembler {
    public Stock assemble(HashMap<QuotesProperty, String> map) {
        Quote quote = buildQuote(map);
        Dividend dividend = buildDividend(map);
        Statistics statistics = buildStatistics(map);


        Stock.Builder builder = new Stock.Builder(map.get(QuotesProperty.SYMBOL));
        builder.withCurrency(map.get(QuotesProperty.CURRENCY))
                .withName(map.get(QuotesProperty.NAME))
                .withExchange(map.get(QuotesProperty.STOCK_EXCHANGE))
                .withQuote(quote)
                .withDividends(dividend)
                .withStatistics(statistics);

        return builder.build();
    }

    private Quote buildQuote(HashMap<QuotesProperty, String> map) {

        Quote.Builder builder = new Quote.Builder();

        builder.withPrice(parseBigDecimal(map.get(QuotesProperty.LAST_TRADE_PRICE_ONLY)))
                .withLastTradeSize(parseLong(map.get(QuotesProperty.LAST_TRADE_SIZE)))
                .withAsk(parseRealTimeBigDecimal(map.get(QuotesProperty.ASK_REALTIME), map.get(QuotesProperty.ASK)))
                .withAskSize(parseLong(map.get(QuotesProperty.ASK_SIZE)))
                .withBid(parseRealTimeBigDecimal(map.get(QuotesProperty.BID_REALTIME), map.get(QuotesProperty.BID)))
                .withBidSize(parseLong(map.get(QuotesProperty.BID_SIZE)))
                .withOpen(parseBigDecimal(map.get(QuotesProperty.OPEN)))
                .withPreviousClose(parseBigDecimal(map.get(QuotesProperty.PREVIOUS_CLOSE)))
                .withDayHigh(parseBigDecimal(map.get(QuotesProperty.DAYS_HIGH)))
                .withDayLow(parseBigDecimal(map.get(QuotesProperty.DAYS_LOW)))
                .withLastTradeDateStr(map.get(QuotesProperty.LAST_TRADE_DATE))
                .withLastTradeTimeStr(map.get(QuotesProperty.LAST_TRADE_TIME))
                .withYearHigh(parseBigDecimal(map.get(QuotesProperty.YEAR_HIGH)))
                .withYearLow(parseBigDecimal(map.get(QuotesProperty.YEAR_LOW)))
                .withPriceAvg50(parseBigDecimal(map.get(QuotesProperty.FIFTY_DAY_MOVING_AVERAGE)))
                .withPriceAvg200(parseBigDecimal(map.get(QuotesProperty.TWO_HUNDRED_DAY_MOVING_AVERAGE)))
                .withVolume(parseLong(map.get(QuotesProperty.VOLUME)))
                .withAvgVolume(parseLong(map.get(QuotesProperty.AVERAGE_DAILY_VOLUME)));

        //TODO: how to better represent these?
        //        builder.withTimeZone(ExchangeTimeZone.getStockTimeZone(symbol))
        //        .withLastTradeTime(parseDateTime(map.getLatest(QuotesProperty.LAST_TRADE_DATE), map.getLatest(QuotesProperty.LAST_TRADE_TIME), quote.getTimeZone()));


        return builder.build();
    }

    private Dividend buildDividend(HashMap<QuotesProperty, String> map) {

        Dividend.Builder builder = new Dividend.Builder();

        builder.withPayDate(parseDateInAmericanFormat(map.get(QuotesProperty.DIVIDEND_PAY_DATE)))
                .withExDate(parseDateInAmericanFormat(map.get(QuotesProperty.EX_DIVIDEND_DATE)))
                .withAnnualYield(parseBigDecimal(map.get(QuotesProperty.TRAILING_ANNUAL_DIVIDEND_YIELD)))
                .withAnnualYieldPercent(parseBigDecimal(map.get(QuotesProperty.TRAILING_ANNUAL_DIVIDEND_YIELD_IN_PERCENT)));

        return builder.build();
    }

    private Statistics buildStatistics(HashMap<QuotesProperty, String> map) {
        Statistics.Builder builder = new Statistics.Builder();

        builder.withMarketCap(parseBigDecimal(map.get(QuotesProperty.MARKET_CAPITALIZATION)))
                .withSharesFloat(parseLong(map.get(QuotesProperty.SHARES_FLOAT)))
                .withSharesOutstanding(parseLong(map.get(QuotesProperty.SHARES_OUTSTANDING)))
                .withSharesOwned(parseLong(map.get(QuotesProperty.SHARES_OWNED)))

                .withEps(parseBigDecimal(map.get(QuotesProperty.DILUTED_EPS)))
                .withPe(parseBigDecimal(map.get(QuotesProperty.PE_RATIO)))
                .withPeg(parseBigDecimal(map.get(QuotesProperty.PEG_RATIO)))

                .withEpsEstimateCurrentYear(parseBigDecimal(map.get(QuotesProperty.EPS_ESTIMATE_CURRENT_YEAR)))
                .withEpsEstimateNextQuarter(parseBigDecimal(map.get(QuotesProperty.EPS_ESTIMATE_NEXT_QUARTER)))
                .withEpsEstimateNextYear(parseBigDecimal(map.get(QuotesProperty.EPS_ESTIMATE_NEXT_YEAR)))

                .withPriceBook(parseBigDecimal(map.get(QuotesProperty.PRICE_BOOK)))
                .withPriceSales(parseBigDecimal(map.get(QuotesProperty.PRICE_SALES)))
                .withBookValuePerShare(parseBigDecimal(map.get(QuotesProperty.BOOK_VALUE_PER_SHARE)))

                .withOneYearTargetPrice(parseBigDecimal(map.get(QuotesProperty.ONE_YEAR_TARGET_PRICE)))
                .withEBITDA(parseBigDecimal(map.get(QuotesProperty.EBITDA)))
                .withRevenue(parseBigDecimal(map.get(QuotesProperty.REVENUE)))

                .withShortRatio(parseBigDecimal(map.get(QuotesProperty.SHORT_RATIO)));

        return builder.build();
    }
}
