package com.garaio.jira.plugins.vertec.service;

import com.atlassian.cache.Cache;
import com.atlassian.cache.CacheManager;
import com.garaio.jira.plugins.configuration.JiraToVertecConfiguration;
import com.garaio.jira.plugins.vertec.soap.VertecSoapEnvelope;
import org.apache.commons.io.IOUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

/**
 * Created by IntelliJ IDEA.
 * User: mjr0177_2
 * Date: Sep 20, 2011
 * Time: 2:23:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class VertecConnectorImpl implements VertecConnector {
    private final String VERTEC_AUTH_TOKEN_CACHE_KEY = "VERTEC_AUTH_TOKEN_CACHE_KEY";
    private final String VERTEC_AUTH_TOKEN_KEY = "VERTEC_AUTH_TOKEN_KEY";

    private JiraToVertecConfiguration configuration;
    private VertecSerializer serializer;
    private CacheManager cacheFactory;

    public VertecConnectorImpl(JiraToVertecConfiguration configuration, VertecSerializer serializer, CacheManager cacheFactory) {
        this.configuration = configuration;
        this.serializer = serializer;
        this.cacheFactory = cacheFactory;
    }

    public String Query(VertecSoapEnvelope envelope) throws IOException, JAXBException {
        HttpURLConnection conn = executeRequest(envelope);

        return IOUtils.toString(conn.getInputStream(), StandardCharsets.UTF_8.name());
    }

    private HttpURLConnection executeRequest(VertecSoapEnvelope envelope) throws JAXBException, IOException {
        String query = serializer.SerializeObject(envelope);

        // Send data
        URL url = new URL(configuration.getVertecServiceUrl());
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestProperty("Content-Type", "text/plain");
        conn.setRequestProperty("Authorization", "Bearer " + configuration.getVertecServiceToken());
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(query);
        wr.flush();

        return conn;
    }
}
