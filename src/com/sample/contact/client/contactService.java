package com.sample.contact.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("contactService.rpc")
public interface contactService extends RemoteService {

  // Sample interface method of remote interface
  String getMessage(String msg);

  /**
   * Utility/Convenience class.
   * Use contactService.App.getInstance() to access static instance of contactServiceAsync
   */
  public static class App {

    private static contactServiceAsync ourInstance = GWT.create(contactService.class);

    public static synchronized contactServiceAsync getInstance() {
      return ourInstance;
    }
  }
}
