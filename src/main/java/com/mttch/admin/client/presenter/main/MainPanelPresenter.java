package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.grid.administrators.AdministratorsPanel;
import com.mttch.admin.client.ui.grid.logs.AdminLogPanel;
import com.mttch.admin.client.ui.grid.logs.LicenseEventsPanel;
import com.mttch.admin.client.ui.grid.servers.ServersPanel;
import com.mttch.admin.client.ui.grid.services.EmailServicePanel;
import com.mttch.admin.client.ui.grid.services.XmppServicePanel;
import com.mttch.admin.client.ui.grid.users.UsersPanel;
import com.mttch.admin.client.ui.main.MainPanel;
import com.sencha.gxt.widget.core.client.ContentPanel;

public class MainPanelPresenter extends AbstractPresenter {

    private MainPanel mainPanel;
    private UsersPanel usersPanel;
    private AdministratorsPanel administratorsPanel;
    private LicenseEventsPanel licenseEventsPanel;
    private AdminLogPanel adminLogPanel;
    private EmailServicePanel emailServicePanel;
    private XmppServicePanel xmppServicePanel;
    private ServersPanel serversPanel;

    @Inject
    public MainPanelPresenter(SimpleEventBus eventBus,
                              MainPanel mainPanel,
                              UsersPanel usersPanel,
                              AdministratorsPanel administratorsPanel,
                              LicenseEventsPanel licenseEventsPanel,
                              AdminLogPanel adminLogPanel,
                              EmailServicePanel emailServicePanel,
                              XmppServicePanel xmppServicePanel,
                              ServersPanel serversPanel) {
        super(eventBus);
        this.mainPanel = mainPanel;
        this.usersPanel = usersPanel;
        this.administratorsPanel = administratorsPanel;
        this.licenseEventsPanel = licenseEventsPanel;
        this.adminLogPanel = adminLogPanel;
        this.emailServicePanel = emailServicePanel;
        this.xmppServicePanel = xmppServicePanel;
        this.serversPanel = serversPanel;
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

            case ACTIONS:
                mainPanel.addToCenter(adminLogPanel);
                break;

            case EMAIL:
                mainPanel.addToCenter(emailServicePanel);
                break;

            case XMPP:
                mainPanel.addToCenter(xmppServicePanel);
                break;

            case SERVERS:
                mainPanel.addToCenter(serversPanel);
                break;

            default:
                ContentPanel contentPanel = new ContentPanel();
                contentPanel.getHeader().setText("Unimplemented panel: " + menuType.name());
                mainPanel.addToCenter(contentPanel);
                break;
        }
    }
}
