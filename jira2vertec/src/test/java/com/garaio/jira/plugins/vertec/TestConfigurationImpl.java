package com.garaio.jira.plugins.vertec;

import com.garaio.jira.plugins.configuration.JiraToVertecConfiguration;
import org.junit.Ignore;

@Ignore
public class TestConfigurationImpl implements JiraToVertecConfiguration {

    public String getVertecServiceUrl() {
        return "http://erptest1:8090/xml";
    }

    public String getVertecServiceToken() {
        return "<test-token>";
    }

    public String getVertecJiraReferenceField() { return "referenz"; }

    public boolean getVertecJiraReferenceFieldIsZusatzfeld() {
        return false;
    }

    public String getDefaultPhaseIdWennNichtZugeordnet() {
        return "phaseIdNichtZugeordnet";
    }

    public String getDefaultPhaseIdWennNachbearbeitungNoetig() {
        return "phaseIdNachbearbeitungNoetig";
    }

    public boolean isCachingEnabled()
    {
        return true;
    }

    public boolean zeigeProjektbeschrieb() {
        return false;
    }

    public int getProjektbeschriebMaxLaenge() {
        return 25;
    }
}
