package com.sample.contact.shared;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.sample.contact.client.ui.IContactEditor;
import com.sample.contact.client.ui.IContactForm;

public interface IClientFactory {
  EventBus getEventBus();
  IContactEditor getContactEditor();
  IContactForm getContactForm();
  PlaceController getPlaceController();
}
