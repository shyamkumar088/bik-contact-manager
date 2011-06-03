package com.sample.contact.shared.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.sample.contact.client.IContactCallBack;
import com.sample.contact.client.contactService;
import com.sample.contact.client.contactServiceAsync;
import com.sample.contact.client.service.ContactServiceProvider;
import com.sample.contact.client.ui.IContactEditor;
import com.sample.contact.shared.IClientFactory;
import com.sample.contact.shared.domain.PersonDTO;
import com.sample.contact.shared.impl.ClientFactory;

import java.util.*;

/**
 * User: nawaraj
 * Date: 6/1/11
 */
public class ContactActivity extends AbstractActivity implements IContactEditor.Presenter{
  private IClientFactory clientFactory;
  contactServiceAsync contactServiceAsync1 = ContactServiceProvider.getContactService();

  public ContactActivity(IClientFactory clientFactory) {
    this.clientFactory = clientFactory;
    clientFactory.getContactEditor().setPresenter(this);

  }


  @Override
  public void start(AcceptsOneWidget panel, EventBus eventBus) {
    panel.setWidget(clientFactory.getContactEditor());
  }

  @Override
  public String getMessage(String msg) {
    /*String result;
    contactServiceAsync contactServiceAsync1 = ContactServiceProvider.getContactService();

    contactServiceAsync1.getMessage(msg, messageCallback);*/
    return "";
  }

  @Override
  public List<PersonDTO> findAllPersons() {

    contactServiceAsync1.findAllPersons(new AsyncCallback<List<PersonDTO>>() {
      @Override
      public void onFailure(Throwable throwable) {
        clientFactory.getContactEditor().setError(throwable.toString());
      }

      @Override
      public void onSuccess(List<PersonDTO> personDTOs) {
        clientFactory.getContactEditor().setDataProvider(personDTOs);
      }
    });
    return null;
  }
}
