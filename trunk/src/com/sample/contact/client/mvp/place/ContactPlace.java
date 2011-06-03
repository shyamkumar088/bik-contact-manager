package com.sample.contact.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * User: nawaraj
 * Date: 6/3/11
 */
public class ContactPlace extends Place{

  public static class Tokenizer implements PlaceTokenizer<ContactPlace> {
        @Override
        public String getToken(ContactPlace place) {
            return PlaceToken.CONTACT;
        }

        @Override
        public ContactPlace getPlace(String token) {
            return new ContactPlace();
        }
    }
}
