package com.sample.contact.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.sample.contact.shared.domain.PersonDTO;

import java.util.*;

public interface contactServiceAsync {

  void getMessage(String msg, AsyncCallback<String> async);

  void findAllPersons(AsyncCallback<List<PersonDTO>> async);
}
