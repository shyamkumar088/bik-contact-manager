package com.sample.contact.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.sample.contact.client.mvp.place.ContactPlace;
import com.sample.contact.client.ui.IContactEditor;
import com.sample.contact.shared.IClientFactory;
import com.sample.contact.shared.activity.ContactActivity;

/**
 * User: nawaraj
 * Date: 6/2/11
 */
public class ContactActivityMapper implements ActivityMapper{

  private final IClientFactory clientFactory;

  public ContactActivityMapper(IClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  @Override
  public Activity getActivity(Place place) {
    if( place instanceof ContactPlace){
      return new ContactActivity(clientFactory);
    }
    return null;
  }
}
