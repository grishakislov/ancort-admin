package com.mttch.admin.client.ui.main.menu;

import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Widget;
import com.mttch.admin.client.utils.LabelHelper;
import com.mttch.admin.common.StringConstants;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Padding;
import com.sencha.gxt.core.client.util.ToggleGroup;
import com.sencha.gxt.widget.core.client.button.ToggleButton;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;

public class LeftMenu extends VBoxLayoutContainer {

    private ToggleButton usersButton;
    private ToggleButton sipButton;
    private ToggleButton emailButton;
    private ToggleButton xmppButton;
    private ToggleButton serversButton;
    private ToggleButton administrationButton;
    private ToggleButton eventsButton;
    private ToggleButton actionsButton;

    ToggleGroup toggleGroup = new ToggleGroup();

    public LeftMenu() {
        setVBoxLayoutAlign(VBoxLayoutAlign.LEFT);
        setPadding(new Padding(5));
        setStyleName("x-toolbar-mark");

        BoxLayoutData topVBoxData = new BoxLayoutData(new Margins(0, 5, 5, 5));
        BoxLayoutData vBoxData = new BoxLayoutData(new Margins(5, 5, 5, 5));

        usersButton = createToggleButton(StringConstants.LEFT_MENU_USERS);
        sipButton = createToggleButton(StringConstants.LEFT_MENU_SIP);
        emailButton = createToggleButton(StringConstants.LEFT_MENU_EMAIL);
        xmppButton = createToggleButton(StringConstants.LEFT_MENU_XMPP);
        serversButton = createToggleButton(StringConstants.LEFT_MENU_SERVERS);
        administrationButton = createToggleButton(StringConstants.LEFT_MENU_ADMINISTRATION);
        eventsButton = createToggleButton(StringConstants.LEFT_MENU_EVENTS);
        actionsButton = createToggleButton(StringConstants.LEFT_MENU_ACTIONS);

        add(usersButton, topVBoxData);
        add(serversButton, vBoxData);
        add(administrationButton, vBoxData);
        add(createSpacer());
        add(LabelHelper.createWhiteLabel(StringConstants.LEFT_MENU_SERVICES));
        add(sipButton, vBoxData);
        add(emailButton, vBoxData);
        add(xmppButton, vBoxData);
        add(createSpacer());
        add(LabelHelper.createWhiteLabel(StringConstants.LEFT_MENU_LOGS));
        add(eventsButton, vBoxData);
        add(actionsButton, vBoxData);
    }

    private Widget createSpacer() {
        SimpleContainer spacer = new SimpleContainer();
        spacer.setHeight(20);
        return spacer;
    }

    private ToggleButton createToggleButton(String name) {
        ToggleButton button = new ToggleButton(name);
        button.setWidth(150);
        toggleGroup.add(button);
        return button;
    }

    public ToggleButton getUsersButton() {
        return usersButton;
    }

    public ToggleButton getSipButton() {
        return sipButton;
    }

    public ToggleButton getEmailButton() {
        return emailButton;
    }

    public ToggleButton getXmppButton() {
        return xmppButton;
    }

    public ToggleButton getServersButton() {
        return serversButton;
    }

    public ToggleButton getAdministrationButton() {
        return administrationButton;
    }

    public ToggleButton getEventsButton() {
        return eventsButton;
    }

    public ToggleButton getActionsButton() {
        return actionsButton;
    }
}
