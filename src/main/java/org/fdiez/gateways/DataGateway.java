package org.fdiez.gateways;

import org.fdiez.gateways.utils.RedirectableRequest;
import org.fdiez.gateways.utils.UrlBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;

import static org.fdiez.globals.SystemProperties.CONNECTION_TIMEOUT;

public class DataGateway {

    public List<String> getSingleQuote(String ticker) {
        List<String> result = new LinkedList<>();

        URL request = UrlBuilder.getSingleStockUrl(ticker);

        RedirectableRequest redirectableRequest = new RedirectableRequest(request, 5);
        redirectableRequest.setConnectTimeout(CONNECTION_TIMEOUT);
        redirectableRequest.setReadTimeout(CONNECTION_TIMEOUT);


        try {
            URLConnection connection = redirectableRequest.openConnection();
            InputStreamReader is = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(is);

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (line.equals("Missing Symbols List.")) {
                    //TODO: LOG it but go on
                    System.out.println("Uh-oh");
                } else {
                    result.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }

    public List<String> getHistoricalQuote() {


        return null;
    }
}
