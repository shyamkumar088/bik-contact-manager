package com.sample.contact.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.sample.contact.client.ui.ContactEditor;
import com.sample.contact.shared.domain.PersonDTO;

import java.util.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class contact implements EntryPoint {

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {
    final Button button = new Button("Get All contacts");
    final Label label = new Label();
    final ContactEditor contactEditor = new ContactEditor();

    button.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (label.getText().equals("")) {
          /*contactService.App.getInstance().getMessage("Hello, World!", new MyAsyncCallback(label));*/
          contactService.App.getInstance().findAllPersons(new PersonListAsyncCallback(label, contactEditor));
        } else {
          label.setText("");
        }
      }
    });

    // Assume that the host HTML has elements defined whose
    // IDs are "slot1", "slot2".  In a real app, you probably would not want
    // to hard-code IDs.  Instead, you could, for example, search for all
    // elements with a particular CSS class and replace them with widgets.
    //
    RootPanel.get("slot1").add(button);
    RootPanel.get("slot2").add(label);
     RootPanel.get("contactListDisplay").add(contactEditor);
  }

  private class PersonListAsyncCallback implements AsyncCallback<List<PersonDTO>>{

    Label label;
    ContactEditor contactEditor;
    public PersonListAsyncCallback(Label label, ContactEditor contactEditor) {
      this.label = label;
      this.contactEditor = contactEditor;
    }

    public void onFailure(Throwable caught) {
      label.setText("failure");
    }

    public void onSuccess(List<PersonDTO> result) {
       label.setText("received data from server!!!");
      contactEditor.setDataProvider(result);
    }
  }
  private static class MyAsyncCallback implements AsyncCallback<String> {

    private Label label;

    public MyAsyncCallback(Label label) {
      this.label = label;
    }

    public void onSuccess(String result) {
      label.getElement().setInnerHTML(result);
    }

    public void onFailure(Throwable throwable) {
      label.setText("Failed to receive answer from server!");
    }
  }
}
