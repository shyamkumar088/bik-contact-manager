package com.sample.contact.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("upload.rpc")
public interface UploadService extends RemoteService{

  public static class App {

    private static UploadServiceAsync ourInstance = GWT.create(UploadService.class);

    public static synchronized UploadServiceAsync getInstance() {
      return ourInstance;
    }
  }
}
