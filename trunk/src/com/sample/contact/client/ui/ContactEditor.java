package com.sample.contact.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.InlineHTML;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.sample.contact.server.domain.Person;
import com.sample.contact.shared.domain.PersonDTO;

import java.util.*;

public class ContactEditor  extends Composite implements IContactEditor {
  interface ContactEditorUiBinder extends UiBinder<HTMLPanel, ContactEditor> { }
  private static ContactEditorUiBinder ourUiBinder = GWT.create(ContactEditorUiBinder.class);

  @UiField ListBox contactList;
  @UiField
  ContactForm contactForm;
  @UiField
  InlineHTML errorHtml;
  @UiField
  Button getAllContacts;
  List<PersonDTO> dataProvider;
  private boolean isDirty;

  private PersonDTO selectedDto;
   private Presenter presenter;

  @Override
  public void setDataProvider(List<PersonDTO> dataProvider) {
    errorHtml.setVisible(false);
    this.dataProvider = dataProvider;
    isDirty = true;
    refresh();
  }

  @Override
  public void setError(String error) {
    errorHtml.setHTML(error);
    errorHtml.setVisible(true);
  }

  public ContactEditor() {
    initWidget(ourUiBinder.createAndBindUi(this));
    contactForm.getUpdate().addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
          selectedDto =new PersonDTO(25,contactForm.getFirstName(),contactForm.getLastName(), false);
             }
    });
  }

  @UiHandler("getAllContacts")
  public void onGetAllContactsClicked(final ClickEvent clickEvent) {
      presenter.findAllPersons();
  }

  @UiHandler("contactList")
  public void onListClick(final ChangeEvent event) {
    contactForm.setVisible(true);
    PersonDTO selectedPerson = this.dataProvider.get(contactList.getSelectedIndex());
    contactForm.setFirstName(selectedPerson.getFirstName());
    contactForm.setLastName(selectedPerson.getLastName());
  }

  public void refresh(){
    if(isDirty){
      contactList.clear();
     for(PersonDTO personDTO:dataProvider) {
       contactList.addItem(personDTO.getFirstName() + " " + personDTO.getLastName(), personDTO.getId().toString());
     }
    }
  }

  @Override
  public void setPresenter(Presenter presenter) {
    this.presenter = presenter;
  }
}