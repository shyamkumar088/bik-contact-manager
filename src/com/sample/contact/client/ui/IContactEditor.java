package com.sample.contact.client.ui;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.IsWidget;
import com.sample.contact.shared.domain.PersonDTO;

import java.util.*;

public interface IContactEditor extends IsWidget {
  void setDataProvider(List<PersonDTO> dataProvider);
  void setError(String error);
  void setPresenter(Presenter presenter);

  interface Presenter {
    String getMessage(String msg);
    List<PersonDTO> findAllPersons();
  }
}
