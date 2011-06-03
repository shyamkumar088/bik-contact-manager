package com.sample.contact.client.ui.home;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

public class HomePage extends Composite{

  interface HomePageUiBinder extends UiBinder<HTMLPanel, HomePage> {

  }

  private static HomePageUiBinder ourUiBinder = GWT.create(HomePageUiBinder.class);
  /*@UiField
  HorizontalPanel banner;
  @UiField
  HorizontalPanel breadCrumb;
  @UiField
  VerticalPanel centent;
  @UiField
  HorizontalPanel footer;
  @UiField
  VerticalPanel leftPanel;
  @UiField
  HorizontalPanel menu;
  @UiField
  VerticalPanel rightPanel;*/
  @UiField
  SpanElement spanToBeProgrammed;

  public HomePage() {
    //HTMLPanel rootElement = ourUiBinder.createAndBindUi(this);
    initWidget(ourUiBinder.createAndBindUi(this));
    spanToBeProgrammed.setInnerText("you are not logged in");
  }

  public void setUsername(String username) {
    spanToBeProgrammed.setInnerText("Welcome, " + username);
  }
}