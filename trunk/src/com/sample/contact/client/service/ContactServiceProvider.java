package com.sample.contact.client.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.ServiceDefTarget;
import com.sample.contact.client.contactService;
import com.sample.contact.client.contactServiceAsync;

/**
 * User: nawaraj
 * Date: 6/2/11
 */
public class ContactServiceProvider {
  public static contactServiceAsync getContactService(){
   contactServiceAsync contactServiceAsync1 = contactService.App.getInstance();
   setRpcEndPointUrl(contactServiceAsync1);
    return contactServiceAsync1;
  }
  public static void setRpcEndPointUrl(Object proxy)  {
    ServiceDefTarget target = (ServiceDefTarget) proxy;
    StringBuffer sb = new StringBuffer( );
    sb.append( GWT.getTypeName(proxy) );
    String endPointName = sb.substring( 0, sb.indexOf("_Proxy") );
    endPointName = endPointName.replace('.','/');

    target.setServiceEntryPoint(endPointName + ".rpc");
    }
}
