package org.fdiez.datalayer;

import java.math.BigDecimal;

public class Statistics {

    private BigDecimal marketCap;
    private Long sharesFloat;
    private Long sharesOutstanding;
    private Long sharesOwned;

    private BigDecimal eps;
    private BigDecimal pe;
    private BigDecimal peg;

    private BigDecimal epsEstimateCurrentYear;
    private BigDecimal epsEstimateNextQuarter;
    private BigDecimal epsEstimateNextYear;

    private BigDecimal priceBook;
    private BigDecimal priceSales;
    private BigDecimal bookValuePerShare;

    private BigDecimal revenueTTM;
    private BigDecimal ebitdaTTM;
    private BigDecimal oneYearTargetPrice;

    public Statistics(Builder builder) {

        this.marketCap = builder.marketCap;
        this.sharesFloat = builder.sharesFloat;
        this.sharesOutstanding = builder.sharesOutstanding;
        this.sharesOwned = builder.sharesOwned;

        this.eps = builder.eps;
        this.pe = builder.pe;
        this.peg = builder.peg;

        this.epsEstimateCurrentYear = builder.epsEstimateCurrentYear;
        this.epsEstimateNextQuarter = builder.epsEstimateNextQuarter;
        this.epsEstimateNextYear = builder.epsEstimateNextYear;

        this.priceBook = builder.priceBook;
        this.priceSales = builder.priceSales;
        this.bookValuePerShare = builder.bookValuePerShare;

        this.revenueTTM = builder.revenueTTM;
        this.ebitdaTTM = builder.ebitdaTTM;
        this.oneYearTargetPrice = builder.oneYearTargetPrice;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public Long getSharesFloat() {
        return sharesFloat;
    }

    public Long getSharesOutstanding() {
        return sharesOutstanding;
    }

    public Long getSharesOwned() {
        return sharesOwned;
    }

    public BigDecimal getEps() {
        return eps;
    }

    public BigDecimal getPe() {
        return pe;
    }

    public BigDecimal getPeg() {
        return peg;
    }

    public BigDecimal getEpsEstimateCurrentYear() {
        return epsEstimateCurrentYear;
    }

    public BigDecimal getEpsEstimateNextQuarter() {
        return epsEstimateNextQuarter;
    }

    public BigDecimal getEpsEstimateNextYear() {
        return epsEstimateNextYear;
    }

    public BigDecimal getPriceBook() {
        return priceBook;
    }

    public BigDecimal getPriceSales() {
        return priceSales;
    }

    public BigDecimal getBookValuePerShare() {
        return bookValuePerShare;
    }

    public BigDecimal getRevenueTTM() {
        return revenueTTM;
    }

    public BigDecimal getEbitdaTTM() {
        return ebitdaTTM;
    }

    public BigDecimal getOneYearTargetPrice() {
        return oneYearTargetPrice;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "marketCap=" + marketCap +
                ", sharesFloat=" + sharesFloat +
                ", sharesOutstanding=" + sharesOutstanding +
                ", sharesOwned=" + sharesOwned +
                ", eps=" + eps +
                ", pe=" + pe +
                ", peg=" + peg +
                ", epsEstimateCurrentYear=" + epsEstimateCurrentYear +
                ", epsEstimateNextQuarter=" + epsEstimateNextQuarter +
                ", epsEstimateNextYear=" + epsEstimateNextYear +
                ", priceBook=" + priceBook +
                ", priceSales=" + priceSales +
                ", bookValuePerShare=" + bookValuePerShare +
                ", revenueTTM=" + revenueTTM +
                ", ebitdaTTM=" + ebitdaTTM +
                ", oneYearTargetPrice=" + oneYearTargetPrice +
                '}';
    }

    public static class Builder {

        private BigDecimal marketCap;
        private Long sharesFloat;
        private Long sharesOutstanding;
        private Long sharesOwned;

        private BigDecimal eps;
        private BigDecimal pe;
        private BigDecimal peg;

        private BigDecimal epsEstimateCurrentYear;
        private BigDecimal epsEstimateNextQuarter;
        private BigDecimal epsEstimateNextYear;

        private BigDecimal priceBook;
        private BigDecimal priceSales;
        private BigDecimal bookValuePerShare;

        private BigDecimal revenueTTM;
        private BigDecimal ebitdaTTM;
        private BigDecimal oneYearTargetPrice;

        private BigDecimal shortRatio;

        public Builder withMarketCap(BigDecimal marketCap) {
            this.marketCap = marketCap;
            return this;
        }

        public Builder withSharesFloat(Long sharesFloat) {
            this.sharesFloat = sharesFloat;
            return this;
        }

        public Builder withSharesOutstanding(Long sharesOutstanding) {
            this.sharesOutstanding = sharesOutstanding;
            return this;
        }

        public Builder withSharesOwned(Long sharesOwned) {
            this.sharesOwned = sharesOwned;
            return this;
        }

        public Builder withEps(BigDecimal eps) {
            this.eps = eps;
            return this;
        }

        public Builder withPe(BigDecimal pe) {
            this.pe = pe;
            return this;
        }

        public Builder withPeg(BigDecimal peg) {
            this.peg = peg;
            return this;
        }

        public Builder withEpsEstimateCurrentYear(BigDecimal epsEstimateCurrentYear) {
            this.epsEstimateCurrentYear = epsEstimateCurrentYear;
            return this;
        }

        public Builder withEpsEstimateNextQuarter(BigDecimal epsEstimateNextQuarter) {
            this.epsEstimateNextQuarter = epsEstimateNextQuarter;
            return this;
        }

        public Builder withEpsEstimateNextYear(BigDecimal epsEstimateNextYear) {
            this.epsEstimateNextYear = epsEstimateNextYear;
            return this;
        }

        public Builder withPriceBook(BigDecimal priceBook) {
            this.priceBook = priceBook;
            return this;
        }

        public Builder withPriceSales(BigDecimal priceSales) {
            this.priceSales = priceSales;
            return this;
        }

        public Builder withBookValuePerShare(BigDecimal bookValuePerShare) {
            this.bookValuePerShare = bookValuePerShare;
            return this;
        }

        public Builder withOneYearTargetPrice(BigDecimal oneYearTargetPrice) {
            this.oneYearTargetPrice = oneYearTargetPrice;
            return this;
        }

        public Builder withEBITDA(BigDecimal ebitda) {
            this.ebitdaTTM = ebitda;
            return this;
        }

        public Builder withRevenue(BigDecimal revenue) {
            this.revenueTTM = revenue;
            return this;
        }

        public Builder withShortRatio(BigDecimal shortRatio) {
            this.shortRatio = shortRatio;
            return this;
        }

        public Statistics build() {
            return new Statistics(this);
        }
    }
}
