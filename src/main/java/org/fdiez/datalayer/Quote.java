package org.fdiez.datalayer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class Quote {

    private BigDecimal ask;
    private Long askSize;
    private BigDecimal bid;
    private Long bidSize;
    private BigDecimal price;

    private Long lastTradeSize;
    private String lastTradeDateStr;
    private String lastTradeTimeStr;

    private BigDecimal open;
    private BigDecimal previousClose;
    private BigDecimal dayLow;
    private BigDecimal dayHigh;

    private BigDecimal yearLow;
    private BigDecimal yearHigh;
    private BigDecimal priceAvg50;
    private BigDecimal priceAvg200;

    private Long volume;
    private Long avgVolume;

    public Quote(Builder builder) {
        this.ask = builder.ask;
        this.askSize = builder.askSize;
        this.bid = builder.bid;
        this.bidSize = builder.bidSize;
        this.price = builder.price;
        this.lastTradeSize = builder.lastTradeSize;
        this.lastTradeDateStr = builder.lastTradeDateStr;
        this.lastTradeTimeStr = builder.lastTradeTimeStr;
        this.open = builder.open;
        this.previousClose = builder.previousClose;
        this.dayLow = builder.dayLow;
        this.dayHigh = builder.dayHigh;
        this.yearLow = builder.yearLow;
        this.yearHigh = builder.yearHigh;
        this.priceAvg50 = builder.priceAvg50;
        this.priceAvg200 = builder.priceAvg200;
        this.volume = builder.volume;
        this.avgVolume = builder.avgVolume;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public Long getAskSize() {
        return askSize;
    }

    public BigDecimal getBid() {
        return bid;
    }

    public Long getBidSize() {
        return bidSize;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Long getLastTradeSize() {
        return lastTradeSize;
    }

    public String getLastTradeDateStr() {
        return lastTradeDateStr;
    }

    public String getLastTradeTimeStr() {
        return lastTradeTimeStr;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public BigDecimal getPreviousClose() {
        return previousClose;
    }

    public BigDecimal getDayLow() {
        return dayLow;
    }

    public BigDecimal getDayHigh() {
        return dayHigh;
    }

    public BigDecimal getYearLow() {
        return yearLow;
    }

    public BigDecimal getYearHigh() {
        return yearHigh;
    }

    public BigDecimal getPriceAvg50() {
        return priceAvg50;
    }

    public BigDecimal getPriceAvg200() {
        return priceAvg200;
    }

    public Long getVolume() {
        return volume;
    }

    public Long getAvgVolume() {
        return avgVolume;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "ask=" + ask +
                ", askSize=" + askSize +
                ", bid=" + bid +
                ", bidSize=" + bidSize +
                ", price=" + price +
                ", lastTradeSize=" + lastTradeSize +
                ", lastTradeDateStr='" + lastTradeDateStr + '\'' +
                ", lastTradeTimeStr='" + lastTradeTimeStr + '\'' +
                ", open=" + open +
                ", previousClose=" + previousClose +
                ", dayLow=" + dayLow +
                ", dayHigh=" + dayHigh +
                ", yearLow=" + yearLow +
                ", yearHigh=" + yearHigh +
                ", priceAvg50=" + priceAvg50 +
                ", priceAvg200=" + priceAvg200 +
                ", volume=" + volume +
                ", avgVolume=" + avgVolume +
                '}';
    }

    public static class Builder {

        private ZoneId timeZone;

        private BigDecimal ask;
        private Long askSize;
        private BigDecimal bid;
        private Long bidSize;
        private BigDecimal price;

        private Long lastTradeSize;
        private String lastTradeDateStr;
        private String lastTradeTimeStr;
        private LocalDateTime lastTradeTime;

        private BigDecimal open;
        private BigDecimal previousClose;
        private BigDecimal dayLow;
        private BigDecimal dayHigh;

        private BigDecimal yearLow;
        private BigDecimal yearHigh;
        private BigDecimal priceAvg50;
        private BigDecimal priceAvg200;

        private Long volume;
        private Long avgVolume;


        public Builder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder withLastTradeSize(Long lastTradeSize) {
            this.lastTradeSize = lastTradeSize;
            return this;
        }

        public Builder withAsk(BigDecimal ask) {
            this.ask = ask;
            return this;
        }

        public Builder withAskSize(Long askSize) {
            this.askSize = askSize;
            return this;
        }

        public Builder withBid(BigDecimal bid) {
            this.bid = bid;
            return this;
        }

        public Builder withBidSize(Long bidSize) {
            this.bidSize = bidSize;
            return this;
        }

        public Builder withOpen(BigDecimal open) {
            this.open = open;
            return this;
        }

        public Builder withPreviousClose(BigDecimal previousClose) {
            this.previousClose = previousClose;
            return this;
        }

        public Builder withDayHigh(BigDecimal dayHigh) {
            this.dayHigh = dayHigh;
            return this;
        }

        public Builder withDayLow(BigDecimal dayLow) {
            this.dayLow = dayLow;
            return this;
        }

//        public Builder withTimeZone() {
//            this.timeZone = timeZone;
//            return this;
//        }

        public Builder withLastTradeDateStr(String lastTradeDateStr) {
            this.lastTradeDateStr = lastTradeDateStr;
            return this;
        }

        public Builder withLastTradeTimeStr(String lastTradeTimeStr) {
            this.lastTradeTimeStr = lastTradeTimeStr;
            return this;
        }

//        public Builder withLastTradeTime() {
//            this. = ;
//            return this;
//        }

        public Builder withYearHigh(BigDecimal yearHigh) {
            this.yearHigh = yearHigh;
            return this;
        }

        public Builder withYearLow(BigDecimal yearLow) {
            this.yearLow = yearLow;
            return this;
        }

        public Builder withPriceAvg50(BigDecimal priceAvg50) {
            this.priceAvg50 = priceAvg50;
            return this;
        }

        public Builder withPriceAvg200(BigDecimal priceAvg200) {
            this.priceAvg200 = priceAvg200;
            return this;
        }

        public Builder withVolume(Long volume) {
            this.volume = volume;
            return this;
        }

        public Builder withAvgVolume(Long avgVolume) {
            this.avgVolume = avgVolume;
            return this;
        }

        public Quote build() {
            return new Quote(this);
        }
    }
}
