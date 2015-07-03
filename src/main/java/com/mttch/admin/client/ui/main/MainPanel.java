package com.mttch.admin.client.ui.main;

import com.google.inject.Inject;
import com.mttch.admin.client.AppContext;
import com.mttch.admin.client.ui.main.menu.LeftMenu;
import com.mttch.admin.client.ui.main.top.TopPanel;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;

public class MainPanel extends ContentPanel {

    private TopPanel topPanel;
    private LeftMenu leftMenu;
    private SimpleContainer centerContainer;

    public MainPanel() {
        this.topPanel = AppContext.injector.getTopPanel();
        this.leftMenu = AppContext.injector.getLeftMenu();
        initUi();
    }

    private void initUi() {
        setHeaderVisible(false);

        centerContainer = new SimpleContainer();
        BorderLayoutContainer borderLayoutContainer = new BorderLayoutContainer();
        borderLayoutContainer.setNorthWidget(topPanel, layoutData(80));
        borderLayoutContainer.setWestWidget(leftMenu, layoutData(160));
        borderLayoutContainer.setCenterWidget(centerContainer, layoutData(1));
        add(borderLayoutContainer);

    }

    private BorderLayoutContainer.BorderLayoutData layoutData(double size) {
        BorderLayoutContainer.BorderLayoutData data = new BorderLayoutContainer.BorderLayoutData(size);
        data.setMargins(new Margins(10));
        data.setSplit(false);
        return data;
    }

    public void addToCenter(ContentPanel panel) {
        centerContainer.clear();
        centerContainer.add(panel);
        centerContainer.forceLayout();
    }

}
