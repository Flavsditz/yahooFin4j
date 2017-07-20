package org.fdiez.usecases.utils;

import org.fdiez.gateways.utils.QuotesProperty;
import org.fdiez.gateways.utils.StockProperties;

import java.util.HashMap;
import java.util.List;

public class StockParser {

    private static final String PADDING = "***";
    private String dataLine;

    public HashMap<QuotesProperty, String> parseQuote(List<String> data) {
        if (data.size() == 1) {
            //TODO: else throw error
            dataLine = data.get(0);
        }

        final HashMap<QuotesProperty, String> map = mapData();

        return map;
    }

    private HashMap<QuotesProperty, String> mapData() {
        final List<QuotesProperty> defaultProperties = StockProperties.getDefaultProperties();
        final HashMap<QuotesProperty, String> map = new HashMap<>();

        for (int i = 0; i < defaultProperties.size(); i++) {
            QuotesProperty property = defaultProperties.get(i);

            final String value;
            if (property == QuotesProperty.SYMBOL) {
                value = parseCompanyTicker();
            } else {
                value = parseNext();
            }
            map.put(property, value);
        }

        return map;
    }

    private String parseNext() {
        if (dataLine.length() > 0) {
            return parseNextToken();
        }
        return "";
    }

    private String parseNextToken() {
        String token;
        if (isNextPadding()) {
            token = parsePaddedValueToken();
        } else if (isNextAString()) {
            token = parseStringToken();
        } else {
            token = parseNonStringToken();
        }
        return token;
    }

    private String parseCompanyTicker() {
        String ticker = parseStringToken();

        dataLine = dataLine.replace("\"" + ticker + "\"", PADDING);

        return ticker;
    }

    private String parsePaddedValueToken() {
        int tokenStart = PADDING.length() + 1; // skip symbol
        int tokenEnd = dataLine.indexOf(PADDING, tokenStart) - 1; // don't include last ,
        int skip = 2;

        final String token = dataLine.substring(tokenStart, tokenEnd);

        tokenEnd += PADDING.length();
        trimLineForNextToken(tokenEnd, skip);

        return token;
    }

    private String parseStringToken() {
        int tokenEnd = dataLine.indexOf('\"', 1);
        int skip = 2;

        final String token = dataLine.substring(1, tokenEnd);
        trimLineForNextToken(tokenEnd, skip);

        return token;
    }

    private String parseNonStringToken() {
        int tokenEnd = dataLine.indexOf(',', 0);
        int skip = 1;

        final String token = dataLine.substring(0, tokenEnd);

        trimLineForNextToken(tokenEnd, skip);

        return token;
    }

    private void trimLineForNextToken(int tokenEnd, int skip) {
        final int nextStartPoint = tokenEnd + skip;

        if (nextStartPoint >= dataLine.length()) {
            dataLine = "";
        } else {
            dataLine = dataLine.substring(nextStartPoint);
        }
    }

    private boolean isNextPadding() {
        return dataLine.startsWith(PADDING);
    }

    private boolean isNextAString() {
        return dataLine.startsWith("\"");
    }
}
