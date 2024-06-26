package com.garaio.jira.plugins.configuration;

/**
 * Created by IntelliJ IDEA.
 * User: mjr0177_2
 * Date: Sep 21, 2011
 * Time: 10:24:15 AM
 * To change this template use File | Settings | File Templates.
 */
public interface JiraToVertecConfiguration {
    String getVertecServiceUrl();

    String getVertecServiceToken();

    String getVertecJiraReferenceField();

    boolean getVertecJiraReferenceFieldIsZusatzfeld();

    String getDefaultPhaseIdWennNichtZugeordnet();

    String getDefaultPhaseIdWennNachbearbeitungNoetig();

    boolean isCachingEnabled();

    boolean zeigeProjektbeschrieb();

    int getProjektbeschriebMaxLaenge();
}
