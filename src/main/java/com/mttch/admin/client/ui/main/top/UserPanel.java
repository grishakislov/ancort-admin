package com.mttch.admin.client.ui.main.top;

import com.mttch.admin.client.utils.LabelHelper;
import com.mttch.admin.common.StringConstants;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VBoxLayoutContainer;

public class UserPanel extends SimpleContainer {

    private SimpleContainer userNameContainer;
    private TextButton logoutButton;

    public UserPanel() {
        initUi();
    }

    private void initUi() {
        userNameContainer = new SimpleContainer();
        logoutButton = new TextButton(StringConstants.LOGOUT);
        logoutButton.setWidth(79);

        BoxLayoutContainer.BoxLayoutData layoutData = new BoxLayoutContainer.BoxLayoutData(new Margins(5));
        VBoxLayoutContainer container = new VBoxLayoutContainer();
        container.setVBoxLayoutAlign(VBoxLayoutContainer.VBoxLayoutAlign.CENTER);
        container.add(userNameContainer, layoutData);
        container.add(logoutButton, layoutData);

        add(container);
    }

    public void setUserName(String name) {
        userNameContainer.clear();
        userNameContainer.add(LabelHelper.createWhiteLabel(name));
    }

    public TextButton getLogoutButton() {
        return logoutButton;
    }
}
