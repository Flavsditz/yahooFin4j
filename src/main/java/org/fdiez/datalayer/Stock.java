package org.fdiez.datalayer;

public class Stock {
    private final String ticker;
    private final String name;
    private final String currency;
    private final String exchangeName;
    private final Quote quote;
    private final Statistics statistics;
    private final Dividend dividend;

    private Stock(Builder builder) {
        this.ticker = builder.ticker;
        this.name = builder.name;
        this.currency = builder.currency;
        this.exchangeName = builder.exchangeName;
        this.quote = builder.quote;
        this.statistics = builder.statistics;
        this.dividend = builder.dividend;
    }

    public String getTicker() {
        return ticker;
    }

    public String getName() {
        return name;
    }

    public String getCurrency() {
        return currency;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public Quote getQuote() {
        return quote;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public Dividend getDividend() {
        return dividend;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "ticker='" + ticker + '\'' +
                ", name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", exchangeName='" + exchangeName + '\'' +
                ", quote=" + quote +
                ", statistics=" + statistics +
                ", dividend=" + dividend +
                '}';
    }

    public static class Builder {

        private String ticker;
        private String name;
        private String currency;
        private String exchangeName;
        private Quote quote;
        private Statistics statistics;
        private Dividend dividend;

        public Builder(String ticker) {
            this.ticker = ticker;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public Builder withExchange(String exchangeName) {
            this.exchangeName = exchangeName;
            return this;
        }

        public Builder withQuote(Quote quote) {
            this.quote = quote;
            return this;
        }

        public Builder withStatistics(Statistics statistics) {
            this.statistics = statistics;
            return this;
        }

        public Builder withDividends(Dividend dividend) {
            this.dividend = dividend;
            return this;
        }

        public Stock build() {
            return new Stock(this);
        }
    }
}
