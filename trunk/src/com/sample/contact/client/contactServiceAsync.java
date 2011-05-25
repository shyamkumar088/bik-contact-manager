package com.sample.contact.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface contactServiceAsync {

  void getMessage(String msg, AsyncCallback<String> async);
}
