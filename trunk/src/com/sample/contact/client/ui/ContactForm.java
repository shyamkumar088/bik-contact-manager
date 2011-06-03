package com.sample.contact.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ContactForm extends Composite implements IContactForm {

  private IContactEditor.Presenter presenter = this.presenter;
  interface ContactFormUiBinder extends UiBinder<Widget, ContactForm> {}
  private static ContactFormUiBinder ourUiBinder = GWT.create(ContactFormUiBinder.class);

  @UiField TextBox  firstName;
  @UiField TextBox lastName;
  @UiField Button cancel;
  @UiField Button update;

  public ContactForm() {
    initWidget(ourUiBinder.createAndBindUi(this));
  }

  @Override
  public void setPresenter(IContactEditor.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void setFirstName(String firstName){
    this.firstName.setText(firstName);
  }

  @Override
  public void setLastName(String lastName) {
    this.lastName.setText(lastName);
  }
  @Override
  public String getFirstName(){
    return this.firstName.getText();
  }

  @Override
  public String getLastName() {
    return this.lastName.getText();
  }

  @Override
  public Button getUpdate() {
    return update;
  }
}