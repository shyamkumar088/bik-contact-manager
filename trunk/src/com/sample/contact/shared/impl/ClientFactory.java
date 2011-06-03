package com.sample.contact.shared.impl;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.sample.contact.client.ui.ContactEditor;
import com.sample.contact.client.ui.ContactForm;
import com.sample.contact.client.ui.IContactEditor;
import com.sample.contact.client.ui.IContactForm;
import com.sample.contact.shared.IClientFactory;

/**
 * User: nawaraj
 * Date: 6/1/11
 */
public class ClientFactory implements IClientFactory{
  private EventBus eventBus;
  private IContactEditor contactEditor;
  private IContactForm contactForm;
  private PlaceController placeController;

  public ClientFactory() {
    this.eventBus = new SimpleEventBus();
    this.contactEditor = new ContactEditor();
    this.contactForm = new ContactForm();
    this.placeController = new PlaceController(this.eventBus);
  }

  @Override
  public EventBus getEventBus() {
    return this.eventBus;
  }

  @Override
  public IContactEditor getContactEditor() {
    return contactEditor;
  }

  @Override
  public IContactForm getContactForm() {
    return contactForm;
  }

  @Override
  public PlaceController getPlaceController(){
    return this.placeController;
  }
}
