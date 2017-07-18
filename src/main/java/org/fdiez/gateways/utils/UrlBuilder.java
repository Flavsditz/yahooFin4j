package org.fdiez.gateways.utils;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.fdiez.gateways.utils.QuotesProperty.SYMBOL;
import static org.fdiez.globals.SystemProperties.QUOTES_BASE_URL;

public class UrlBuilder {

    public static URL getSingleStockUrl(String ticker) {
        Map<String, String> params = new LinkedHashMap<>();
        params.put("s", ticker);
        params.put("f", getStockFieldsString());
        params.put("e", ".csv");

        String url = QUOTES_BASE_URL + "?" + convertToURLParameters(params);

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
}
