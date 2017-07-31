package org.fdiez.gateways.utils;

import org.fdiez.globals.QueryInterval;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.fdiez.gateways.utils.QuotesProperty.SYMBOL;
import static org.fdiez.globals.SystemProperties.HISTORICAL_QUOTES_BASE_URL;
import static org.fdiez.globals.SystemProperties.QUOTES_BASE_URL;

public class UrlBuilder {

    public static URL getSingleStockUrl(String ticker) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("s", ticker);
        params.put("f", getStockFieldsString());
        params.put("e", ".csv");

        String url = QUOTES_BASE_URL + "?" + convertToURLParameters(params);

        return createURLObject(url);
    }

    private static URL createURLObject(String url) {
        // TODO: let's not return a null maybe?
        URL request = null;
        try {
            request = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return request;
    }

    private static String getStockFieldsString() {
        StringBuilder result = new StringBuilder();
        for (QuotesProperty property : StockProperties.getDefaultProperties()) {
            if (property.isPadded()) {
                result.append(SYMBOL.getTag());
                result.append(property.getTag());
                result.append(SYMBOL.getTag());
            } else {
                result.append(property.getTag());
            }
        }
        return result.toString();
    }

    private static String convertToURLParameters(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            String key = entry.getKey();
            String value = entry.getValue();
            try {
                key = URLEncoder.encode(key, "UTF-8");
                value = URLEncoder.encode(value, "UTF-8");
            } catch (UnsupportedEncodingException ex) {
                //TODO: Logging
                // Still try to continue with unencoded values
            }
            sb.append(String.format("%s=%s", key, value));
        }
        return sb.toString();
    }

    public static URL getHistoricalStockUrl(String ticker, LocalDate initialDate, LocalDate endDate, QueryInterval interval) {
        Map<String, String> params = new LinkedHashMap<String, String>();

        params.put("period1", String.valueOf(Instant.from(initialDate).toEpochMilli() / 1000));
        params.put("period2", String.valueOf(Instant.from(endDate).toEpochMilli() / 1000));
        params.put("interval", interval.getTag());
        params.put("crumb", CrumbManager.getCrumb());

        String encode = ticker;
        try {
            encode = URLEncoder.encode(ticker, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            //TODO: logging
        }

        String url = HISTORICAL_QUOTES_BASE_URL + encode + "?" + convertToURLParameters(params);

        return createURLObject(url);
    }
}
