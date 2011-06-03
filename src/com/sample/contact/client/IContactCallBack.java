package com.sample.contact.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface IContactCallBack<T> extends AsyncCallback<T>{
  public boolean isResultValid();
  public T getResult();
}
