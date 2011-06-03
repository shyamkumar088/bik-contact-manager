package com.sample.contact.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.sample.contact.client.mvp.AppPlaceHistoryMapper;
import com.sample.contact.client.mvp.ContactActivityMapper;
import com.sample.contact.client.mvp.place.ContactPlace;
import com.sample.contact.client.service.ContactServiceProvider;
import com.sample.contact.client.ui.ContactEditor;
import com.sample.contact.client.ui.IContactEditor;
import com.sample.contact.client.ui.upload.FileuploadPanel;
import com.sample.contact.shared.IClientFactory;
import com.sample.contact.shared.domain.PersonDTO;
import com.sample.contact.shared.impl.ClientFactory;

import java.util.*;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class contact implements EntryPoint{
    private SimplePanel appWidget = new SimplePanel();

  /**
   * This is the entry point method.
   */
  public void onModuleLoad() {

    final IClientFactory clientFactory = GWT.create(IClientFactory.class);
    final IContactEditor contactEditor = clientFactory.getContactEditor();
    EventBus eventBus = clientFactory.getEventBus();

    PlaceController placeController = clientFactory.getPlaceController();

    // Start ActivityManager for the main widget with our ActivityMapper
    ActivityMapper activityMapper = new ContactActivityMapper(clientFactory);
    ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
    activityManager.setDisplay(appWidget);
    //Start PlaceHistoryHandler with our PlaceHistoryMapper
    AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
    PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
    historyHandler.register(placeController, eventBus, new ContactPlace());
    RootPanel.get().add(appWidget);
    // Goes to the place represented on URL else default place
    historyHandler.handleCurrentHistory();
  }
}
