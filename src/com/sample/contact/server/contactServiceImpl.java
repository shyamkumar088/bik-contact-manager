package com.sample.contact.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sample.contact.client.contactService;

public class contactServiceImpl extends RemoteServiceServlet implements contactService {

  // Implementation of sample interface method
  public String getMessage(String msg) {
    return "Client said: \"" + msg + "\"<br>Server answered: \"Hello!\"";
  }
}