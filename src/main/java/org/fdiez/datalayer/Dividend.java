package org.fdiez.datalayer;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Dividend {

    private LocalDate payDate;
    private LocalDate exDate;
    private BigDecimal annualYield;
    private BigDecimal annualYieldPercent;


    public Dividend(Builder builder) {
        this.payDate = builder.payDate;
        this.exDate = builder.exDate;
        this.annualYield = builder.annualYield;
        this.annualYieldPercent = builder.annualYieldPercent;
    }

    public LocalDate getPayDate() {
        return payDate;
    }

    public LocalDate getExDate() {
        return exDate;
    }

    public BigDecimal getAnnualYield() {
        return annualYield;
    }

    public BigDecimal getAnnualYieldPercent() {
        return annualYieldPercent;
    }

    @Override
    public String toString() {
        return "Dividend{" +
                "payDate=" + payDate +
                ", exDate=" + exDate +
                ", annualYield=" + annualYield +
                ", annualYieldPercent=" + annualYieldPercent +
                '}';
    }

    public static class Builder {

        private LocalDate payDate;
        private LocalDate exDate;
        private BigDecimal annualYield;
        private BigDecimal annualYieldPercent;

        public Builder withPayDate(LocalDate payDate) {
            this.payDate = payDate;
            return this;
        }

        public Builder withExDate(LocalDate exDate) {
            this.exDate = exDate;
            return this;
        }

        public Builder withAnnualYield(BigDecimal annualYield) {
            this.annualYield = annualYield;
            return this;
        }

        public Builder withAnnualYieldPercent(BigDecimal annualYieldPercent) {
            this.annualYieldPercent = annualYieldPercent;
            return this;
        }

        public Dividend build() {
            return new Dividend(this);
        }
    }
}
