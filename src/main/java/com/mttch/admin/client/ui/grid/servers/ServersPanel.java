package com.mttch.admin.client.ui.grid.servers;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.mttch.admin.client.ui.grid.AbstractGrid;
import com.mttch.admin.client.utils.UiFactory;
import com.sencha.gxt.core.client.resources.ThemeStyles;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;

public class ServersPanel extends ContentPanel {

    private MailServersGrid mailServersGrid;
    private SipServersGrid sipServersGrid;
    private JabberServersGrid jabberServersGrid;

    @Inject
    public ServersPanel(MailServersGrid mailServersGrid, SipServersGrid sipServersGrid, JabberServersGrid jabberServersGrid) {
        this.mailServersGrid = mailServersGrid;
        this.sipServersGrid = sipServersGrid;
        this.jabberServersGrid = jabberServersGrid;
        initUi();
    }

    private void initUi() {
        getHeader().setText("Серверы");

        VerticalLayoutContainer container = new VerticalLayoutContainer();

        container.add(createGridContainer(mailServersGrid, "Mail servers"), new VerticalLayoutContainer.VerticalLayoutData(1, 0.3, new Margins(20)));
        container.add(createGridContainer(sipServersGrid, "Sip servers"), new VerticalLayoutContainer.VerticalLayoutData(1, 0.3, new Margins(20)));
        container.add(createGridContainer(jabberServersGrid, "Jabber servers"), new VerticalLayoutContainer.VerticalLayoutData(1, 0.3, new Margins(20)));
        add(container);
    }

    private SimpleContainer createGridContainer(AbstractGrid grid, String name) {
        SimpleContainer container = new SimpleContainer();

        container.addStyleName(ThemeStyles.get().style().border());

        VerticalLayoutContainer verticalLayoutContainer = new VerticalLayoutContainer();

        Widget gridLabel = UiFactory.createBlackLabel(name, 16);
        verticalLayoutContainer.add(gridLabel, new VerticalLayoutContainer.VerticalLayoutData(1, 0.1));
        verticalLayoutContainer.add(UiFactory.createVerticalSpacer(10), new VerticalLayoutContainer.VerticalLayoutData(1, 0.1));
        verticalLayoutContainer.add(grid, new VerticalLayoutContainer.VerticalLayoutData(1, 0.8));

        container.add(verticalLayoutContainer, new MarginData(20));
        return container;
    }

    public void refreshAll() {
        mailServersGrid.refresh();
        sipServersGrid.refresh();
        jabberServersGrid.refresh();
    }
}
