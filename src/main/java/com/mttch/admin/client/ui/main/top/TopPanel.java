package com.mttch.admin.client.ui.main.top;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.mttch.admin.client.utils.AppBundle;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HBoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;

public class TopPanel extends HBoxLayoutContainer {

    private UserPanel userPanel;

    @Inject
    public TopPanel(UserPanel userPanel) {
        this.userPanel = userPanel;
        initUi();
    }

    private void initUi() {
        Widget logo = createLogo();
        Widget center = createCenter();
        Widget user = createUser();

        BoxLayoutContainer.BoxLayoutData flex = new BoxLayoutContainer.BoxLayoutData(new Margins(0));
        flex.setFlex(1);

        BoxLayoutContainer.BoxLayoutData flex2 = new BoxLayoutContainer.BoxLayoutData(new Margins(10));
        flex.setFlex(1);
        flex.setMaxSize(170);

        setHBoxLayoutAlign(HBoxLayoutContainer.HBoxLayoutAlign.MIDDLE);
        add(logo, flex2);
        add(center, flex);
        add(user, flex2);
        setStyleName("x-toolbar-mark");
    }

    private Widget createUser() {
        return userPanel;
    }

    private Widget createCenter() {
        SimpleContainer panel = new SimpleContainer();
        return panel;
    }

    private Widget createLogo() {
        SimpleContainer logoContainer = new SimpleContainer();
        Image image = new Image(AppBundle.INSTANCE.appLogo());
        logoContainer.add(image, new MarginData(0,0,0,30));
        return logoContainer;
    }

    public UserPanel getUserPanel() {
        return userPanel;
    }
}
