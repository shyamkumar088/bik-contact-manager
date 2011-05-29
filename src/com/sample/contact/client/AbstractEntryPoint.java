package com.sample.contact.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

/**
 * Created by IntelliJ IDEA.
 * User: zephyr
 * Date: 5/29/11
 * Time: 8:46 AM
 * To change this template use File | Settings | File Templates.
 */
public class AbstractEntryPoint implements EntryPoint{
    @Override
    public void onModuleLoad() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
    public void setRpcEndPointUrl(Object proxy)  {
        //AddServiceAsync addService = (AddServiceAsync) GWT.create(AddService.class);
//ServiceDefTarget endpoint = (ServiceDefTarget) addService;
//String moduleRelativeURL = GWT.getModuleBaseURL() + "myAddService;
//endpoint.setServiceEntryPoint(moduleRelativeURL);
    ServiceDefTarget target = (ServiceDefTarget) proxy;
    StringBuffer sb = new StringBuffer( );
    sb.append( GWT.getTypeName(proxy) );
    String endPointName = sb.substring( 0, sb.indexOf("_Proxy") );
    endPointName = endPointName.replace('.','/');

    target.setServiceEntryPoint(endPointName + ".rpc");
    }
}
