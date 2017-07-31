package org.fdiez.gateways.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import static org.fdiez.globals.SystemProperties.*;

/**
 * Created by Stijn on 23/05/2017.
 */
public class CrumbManager {

    private static String crumb = "";
    private static String cookie = "";

    private static void setCookie() throws IOException {
        if (cookie != null && !cookie.isEmpty()) {
            return;
        }

        URL request = new URL(SCRAPE_URL);
        RedirectableRequest redirectableRequest = new RedirectableRequest(request, 5);
        redirectableRequest.setConnectTimeout(CONNECTION_TIMEOUT);
        redirectableRequest.setReadTimeout(CONNECTION_TIMEOUT);
        URLConnection connection = redirectableRequest.openConnection();

        //TODO: ugly ugly ugly
        for (String headerKey : connection.getHeaderFields().keySet()) {
            if ("Set-Cookie".equalsIgnoreCase(headerKey)) {
                for (String cookieField : connection.getHeaderFields().get(headerKey)) {
                    for (String cookieValue : cookieField.split(";")) {
                        if (cookieValue.matches("B=.*")) {
                            cookie = cookieValue;
                            return;
                        }
                    }
                }
            }
        }
    }

    private static void setCrumb() throws IOException {
        if (crumb != null && !crumb.isEmpty()) {
            return;
        }

        URL crumbRequest = new URL(CRUMB_URL);
        RedirectableRequest redirectableCrumbRequest = new RedirectableRequest(crumbRequest, 5);
        redirectableCrumbRequest.setConnectTimeout(CONNECTION_TIMEOUT);
        redirectableCrumbRequest.setReadTimeout(CONNECTION_TIMEOUT);

        Map<String, String> requestProperties = new HashMap<String, String>();
        requestProperties.put("Cookie", cookie);

        URLConnection crumbConnection = redirectableCrumbRequest.openConnection(requestProperties);

        InputStreamReader is = new InputStreamReader(crumbConnection.getInputStream());
        BufferedReader br = new BufferedReader(is);
        String crumbResult = br.readLine();

        if (crumbResult != null && !crumbResult.isEmpty()) {
            crumb = crumbResult.trim();
        } else {
            //TODO: Logging
            System.out.println("Failed to set crumb from http request. Historical quote requests will most likely fail.");
        }
    }

    public static void refresh() throws IOException {
        setCookie();
        setCrumb();
    }

    public static synchronized String getCrumb() throws IOException {
        if (crumb == null || crumb.isEmpty()) {
            refresh();
        }
        return crumb;
    }

    public static String getCookie() throws IOException {
        if (cookie == null || cookie.isEmpty()) {
            refresh();
        }
        return cookie;
    }

}
