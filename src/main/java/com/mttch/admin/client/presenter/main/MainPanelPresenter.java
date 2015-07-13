package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.main.MainPanel;
import com.mttch.admin.client.ui.main.center.administrators.AdministratorsPanel;
import com.mttch.admin.client.ui.main.center.logs.LicenseEventsPanel;
import com.mttch.admin.client.ui.main.center.users.UsersPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class MainPanelPresenter extends AbstractPresenter {

    private MainPanel mainPanel;

    private UsersPanel usersPanel;

    private AdministratorsPanel administratorsPanel;

    private LicenseEventsPanel licenseEventsPanel;

    @Inject
    public MainPanelPresenter(SimpleEventBus eventBus,
                              MainPanel mainPanel,
                              UsersPanel usersPanel,
                              AdministratorsPanel administratorsPanel,
                              LicenseEventsPanel licenseEventsPanel) {
        super(eventBus);
        this.mainPanel = mainPanel;
        this.usersPanel = usersPanel;
        this.administratorsPanel = administratorsPanel;
        this.licenseEventsPanel = licenseEventsPanel;
        bind();
    }

    @Override
    public void bind() {
        eventBus.addHandler(LeftMenuToggledEvent.TYPE, new LeftMenuToggledEvent.Handler() {
            @Override
            public void onMenuTypeChanged(LeftMenuToggledEvent.MenuType menuType) {
                handleLeftMenuToggle(menuType);
            }
        });
    }

    private void handleLeftMenuToggle(LeftMenuToggledEvent.MenuType menuType) {
        switch (menuType) {
            case USERS:
                mainPanel.addToCenter(usersPanel);
                break;
            case ADMINISTRATORS:
                mainPanel.addToCenter(administratorsPanel);
                break;

            case EVENTS:
                mainPanel.addToCenter(licenseEventsPanel);
                break;

            default:
                ContentPanel contentPanel = new ContentPanel();
                contentPanel.getHeader().setText("Unimplemented panel: " + menuType.name());
                mainPanel.addToCenter(contentPanel);
                break;
        }
    }
}
