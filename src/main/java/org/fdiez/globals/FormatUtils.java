package org.fdiez.globals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatUtils {

    private static final BigDecimal THOUSAND = new BigDecimal(1000);
    private static final BigDecimal MILLION = new BigDecimal(1000000);
    private static final BigDecimal BILLION = new BigDecimal(1000000000);

    public static BigDecimal parseBigDecimal(String numStr) {
        BigDecimal result = null;
        if (!isParseable(numStr)) {
            return result;
        }
        try {
            numStr = removeCommasOnNumberString(numStr);
            char lastChar = numStr.charAt(numStr.length() - 1);
            BigDecimal multiplier = BigDecimal.ONE;
            switch (lastChar) {
                case 'B':
                    multiplier = BILLION;
                    break;
                case 'M':
                    multiplier = MILLION;
                    break;
                case 'K':
                    multiplier = THOUSAND;
                    break;
            }
            numStr = numStr.substring(0, numStr.length() - 1);
            result = new BigDecimal(numStr).multiply(multiplier);
        } catch (NumberFormatException e) {
            //TODO: Logging
        }
        return result;
    }

    private static boolean isParseable(String data) {
        return !(data == null || data.equalsIgnoreCase("N/A") || data.equals("-")
                || data.isEmpty() || data.equalsIgnoreCase("nan"));
    }

    private static String removeCommasOnNumberString(String data) {
        return data.trim().replace(",", "");
    }

    public static Long parseLong(String data) {
        Long result = null;
        if (!isParseable(data)) {
            return result;
        }
        try {
            data = removeCommasOnNumberString(data);
            result = Long.parseLong(data);
        } catch (NumberFormatException e) {
            //TODO: logging
        }
        return result;
    }

    public static BigDecimal parseRealTimeBigDecimal(String realtimeValue, String lastValue) {
        BigDecimal realtime = parseBigDecimal(realtimeValue);
        BigDecimal last = parseBigDecimal(lastValue);
        if (realtime == null || realtime.compareTo(BigDecimal.ZERO) == 0) {
            return last;
        }
        return realtime;
    }

    public static LocalDate parseDateInAmericanFormat(String dateStr) {
        if (!isParseable(dateStr)) {
            return null;
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        return LocalDate.parse(dateStr, dtf);
    }

}
