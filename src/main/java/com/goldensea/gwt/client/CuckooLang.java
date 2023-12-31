/*
 * Copyright 2007 Google Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.goldensea.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * This application demonstrates how to construct a relatively complex user
 * interface, similar to many common email readers. It has no back-end,
 * populating its components with hard-coded data.
 */
public class CuckooLang implements EntryPoint {

  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  /*
   * private static final String SERVER_ERROR = "An error occurred while "
   * + "attempting to contact the server. Please check your network "
   * + "connection and try again.";
   */

  /**
   * Create a remote service proxy to talk to the server-side Greeting
   * service.
   */
  // private final GreetingServiceAsync greetingService =
  // GWT.create(GreetingService.class);

  interface Binder extends UiBinder<DockLayoutPanel, CuckooLang> {
  }

  interface GlobalResources extends ClientBundle {
    @Source("global.gss")
    CssResource css();
  }

  private static final Binder binder = GWT.create(Binder.class);

  @UiField TopPanel topPanel;
  @UiField MailList mailList;
  @UiField MailDetail mailDetail;
  @UiField Shortcuts shortcuts;

  /**
   * This method constructs the application user interface by instantiating
   * controls and hooking up event handler.
   */
  public void onModuleLoad() {
    // Inject global styles.
    GWT.<GlobalResources>create(GlobalResources.class).css().ensureInjected();

    // Create the UI defined in Mail.ui.xml.
    DockLayoutPanel outer = binder.createAndBindUi(this);

    // Get rid of scrollbars, and clear out the window's built-in margin,
    // because we want to take advantage of the entire client area.
    Window.enableScrolling(false);
    Window.setMargin("0px");

    // Special-case stuff to make topPanel overhang a bit.
    Element topElem = outer.getWidgetContainerElement(topPanel);
    topElem.getStyle().setZIndex(2);
    topElem.getStyle().setOverflow(Overflow.VISIBLE);

    // Listen for item selection, displaying the currently-selected item in
    // the detail area.
    mailList.setListener(new MailList.Listener() {
      public void onItemSelected(MailItem item) {
        mailDetail.setItem(item);
      }
    });

    // Add the outer panel to the RootLayoutPanel, so that it will be
    // displayed.
    RootLayoutPanel root = RootLayoutPanel.get();
    root.add(outer);
  }
  /**
   * Send the name from the nameField to the server and wait for a
   * response. the following code is backuped to show how to communicate with
   * server.
   */
  /*
   * private void sendNameToServer() {
   * // First, we validate the input.
   * errorLabel.setText("");
   * String textToServer = nameField.getText();
   * if (!FieldVerifier.isValidName(textToServer)) {
   * errorLabel.setText("Please enter at least four characters");
   * return;
   * }
   * 
   * // Then, we send the input to the server.
   * sendButton.setEnabled(false);
   * textToServerLabel.setText(textToServer);
   * serverResponseLabel.setText("");
   * greetingService.greetServer(textToServer, new AsyncCallback<String>() {
   * public void onFailure(Throwable caught) {
   * // Show the RPC error message to the user
   * dialogBox.setText("Remote Procedure Call - Failure");
   * serverResponseLabel.addStyleName("serverResponseLabelError");
   * serverResponseLabel.setHTML(SERVER_ERROR);
   * dialogBox.center();
   * closeButton.setFocus(true);
   * }
   * 
   * public void onSuccess(String result) {
   * dialogBox.setText("Remote Procedure Call");
   * serverResponseLabel.removeStyleName("serverResponseLabelError");
   * serverResponseLabel.setHTML(result);
   * dialogBox.center();
   * closeButton.setFocus(true);
   * }
   * });
   * }
   */

}
