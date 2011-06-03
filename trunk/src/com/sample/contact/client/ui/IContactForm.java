package com.sample.contact.client.ui;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;

public interface IContactForm extends IsWidget{
  void setFirstName(String firstName);
  void setLastName(String lastName);
  String getFirstName();
  String getLastName();
  Button getUpdate();
  void setPresenter(IContactEditor.Presenter presenter);
}
