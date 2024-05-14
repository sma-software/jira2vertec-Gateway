package com.garaio.jira.plugins.configuration;

import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: mjr0177_2
 * Date: Sep 21, 2011
 * Time: 10:12:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class JiraToVertecConfigurationImpl implements JiraToVertecConfiguration {
    private String vertecServiceUrl;
    private String vertecServiceToken;
    private String vertecJiraReferenceField;
    private boolean vertecJiraReferenceFieldIsZusatzfeld;
    private String defaultPhaseIdWennNichtZugeordnet;
    private String defaultPhaseIdWennNachbearbeitungNoetig;
    private boolean isCachingEnabled;
    private boolean zeigeProjektbeschrieb;
    private int projektbeschriebMaxLaenge;

    public JiraToVertecConfigurationImpl()
    {
        Properties properties = PropertyLoader.loadProperties("JiraToVertec");
        vertecServiceUrl = properties.getProperty("vertecServiceUrl");
        vertecServiceToken = properties.getProperty("vertecServiceToken");
        vertecJiraReferenceField = properties.getProperty("vertecJiraReferenceField");
        vertecJiraReferenceFieldIsZusatzfeld = Boolean.parseBoolean(properties.getProperty("vertecJiraReferenceFieldIsZusatzfeld"));
        defaultPhaseIdWennNichtZugeordnet = properties.getProperty("defaultPhaseIdWennNichtZugeordnet");
        defaultPhaseIdWennNachbearbeitungNoetig = properties.getProperty("defaultPhaseIdWennNachbearbeitungNoetig");
        isCachingEnabled = Boolean.parseBoolean(properties.getProperty("enableCaching"));
        zeigeProjektbeschrieb = Boolean.parseBoolean(properties.getProperty("zeigeProjektbeschrieb"));
        projektbeschriebMaxLaenge = Integer.parseInt(properties.getProperty("projektbeschriebMaxLaenge"));
    }

    public String getVertecServiceUrl() {
        return vertecServiceUrl;
    }

    public String getVertecServiceToken() {
        return vertecServiceToken;
    }

    public String getVertecJiraReferenceField() {
        if(vertecJiraReferenceField != null && !vertecJiraReferenceField.isEmpty()) {
            return vertecJiraReferenceField;
        }

        return "referenz";
    }

    public boolean getVertecJiraReferenceFieldIsZusatzfeld() {
        return vertecJiraReferenceFieldIsZusatzfeld;
    }

    public String getDefaultPhaseIdWennNichtZugeordnet() {
        return defaultPhaseIdWennNichtZugeordnet;
    }

    public String getDefaultPhaseIdWennNachbearbeitungNoetig() {
        return defaultPhaseIdWennNachbearbeitungNoetig;
    }

    public boolean zeigeProjektbeschrieb() {
        return zeigeProjektbeschrieb;
    }

    public int getProjektbeschriebMaxLaenge() {
        if (zeigeProjektbeschrieb && projektbeschriebMaxLaenge <= 0) {
            return 25;
        }
        
        return projektbeschriebMaxLaenge;
    }

    public boolean isCachingEnabled()
    {
        return isCachingEnabled;
    }
}

