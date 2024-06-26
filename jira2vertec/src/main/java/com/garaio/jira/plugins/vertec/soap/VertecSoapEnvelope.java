package com.garaio.jira.plugins.vertec.soap;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: mjr0177_2
 * Date: Sep 20, 2011
 * Time: 1:05:14 PM
 * To change this template use File | Settings | File Templates.
 */
@XmlRootElement(name = "Envelope")
public class VertecSoapEnvelope
{
    @XmlElement(name = "Body")
    private VertecSoapBody body;

    public VertecSoapEnvelope()
    {
        body = new VertecSoapBody();
    }

    public VertecSoapBody getBody()
    {
        return body;
    }
}

