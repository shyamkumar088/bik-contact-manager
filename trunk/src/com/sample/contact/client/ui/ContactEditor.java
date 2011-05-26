package com.sample.contact.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.sample.contact.shared.domain.PersonDTO;

import java.util.*;

public class ContactEditor  extends Composite {

  interface ContactEditorUiBinder extends UiBinder<HTMLPanel, ContactEditor> { }
  private static ContactEditorUiBinder ourUiBinder = GWT.create(ContactEditorUiBinder.class);

 /* @UiField  TextBox firstName;
  @UiField  TextBox lastName;*/
 /* @UiField
  CellList<PersonDTO> contactsCellList;*/
  @UiField ListBox contactList;
  List<PersonDTO> dataProvider;
  private boolean isDirty;

  public void setDataProvider(List<PersonDTO> dataProvider) {
    this.dataProvider = dataProvider;
    isDirty = true;
    refresh();
  }

  public ContactEditor() {
    initWidget(ourUiBinder.createAndBindUi(this));
  }

  public void refresh(){
    if(isDirty){
      contactList.clear();
     for(PersonDTO personDTO:dataProvider) {
       contactList.addItem(personDTO.getFirstName() + " " + personDTO.getLastName(), personDTO.getId().toString());
     }
    }
  }
}