package com.sample.contact.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.sample.contact.client.mvp.place.ContactPlace;

@WithTokenizers({ContactPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper{}
