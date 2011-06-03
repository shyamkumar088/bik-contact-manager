package com.sample.contact.client.ui.upload;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.*;
import com.google.gwt.user.client.ui.SubmitButton;

public class FileuploadPanel extends Composite {

  interface FileuploadUiBinder extends UiBinder<FormPanel, FileuploadPanel> {

  }

  private static FileuploadUiBinder ourUiBinder = GWT.create(FileuploadUiBinder.class);

  @UiField
  FormPanel uploadForm;
  @UiField
  FileUpload fileToUpload;
  @UiField
  Button uploadButton;

  public FileuploadPanel() {
    FormPanel rootElement = ourUiBinder.createAndBindUi(this);
    initWidget(rootElement);
    uploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
    uploadForm.setMethod(FormPanel.METHOD_POST);
  }

  @UiHandler("uploadButton")
  public void onUnload(final ClickEvent event){
    uploadForm.submit();
    Window.alert("uploaded");
  }

}