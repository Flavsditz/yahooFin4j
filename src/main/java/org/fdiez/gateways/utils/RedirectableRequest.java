package org.fdiez.gateways.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;


public class RedirectableRequest {

    private URL request;
    private int protocolRedirectLimit;

    private int connectTimeout = 10000;
    private int readTimeout = 10000;

    public RedirectableRequest(URL request, int protocolRedirectLimit) {
        this.request = request;
        this.protocolRedirectLimit = protocolRedirectLimit;
    }

    public URLConnection openConnection() throws IOException {
        return openConnection(new HashMap<>());
    }

    private URLConnection openConnection(Map<String, String> requestProperties) throws IOException {
        int redirectCount = 0;
        boolean hasResponse = false;
        HttpURLConnection connection = null;
        URL currentRequest = this.request;
        while (!hasResponse && (redirectCount <= this.protocolRedirectLimit)) {
            connection = (HttpURLConnection) currentRequest.openConnection();
            connection.setConnectTimeout(this.connectTimeout);
            connection.setReadTimeout(this.readTimeout);

            for (String requestProperty : requestProperties.keySet()) {
                connection.addRequestProperty(requestProperty, requestProperties.get(requestProperty));
            }

            // only handle protocol redirects manually...
            connection.setInstanceFollowRedirects(true);

            switch (connection.getResponseCode()) {
                case HttpURLConnection.HTTP_MOVED_PERM:
                case HttpURLConnection.HTTP_MOVED_TEMP:
                    redirectCount++;
                    String location = connection.getHeaderField("Location");
                    currentRequest = new URL(request, location);
                    break;
                default:
                    hasResponse = true;
            }
        }

        if (redirectCount > this.protocolRedirectLimit) {
            throw new IOException("Protocol redirect count exceeded for url: " + this.request.toExternalForm());
        } else if (connection == null) {
            throw new IOException("Unexpected error while opening connection");
        } else {
            return connection;
        }
    }

    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
