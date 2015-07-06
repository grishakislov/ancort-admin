package com.mttch.admin.client.presenter.main;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.ui.main.center.users.UsersGrid;
import com.mttch.admin.client.ui.main.center.users.UsersPanel;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;

public class UsersPanelPresenter extends AbstractPresenter {

    private UsersPanel usersPanel;
    private UsersGrid grid;

    @Inject
    public UsersPanelPresenter(SimpleEventBus eventBus, UsersPanel usersPanel) {
        super(eventBus);
        this.usersPanel = usersPanel;
        this.grid = usersPanel.getUsersGrid();
        bind();
    }

    @Override
    public void bind() {
        grid.getGrid().getSelectionModel().addSelectionChangedHandler(new SelectionChangedEvent.SelectionChangedHandler<UserModel>() {
            @Override
            public void onSelectionChanged(SelectionChangedEvent<UserModel> event) {
                System.out.println(event.getSelection().get(0).getLogin());
            }
        });

        eventBus.addHandler(LeftMenuToggledEvent.TYPE, new LeftMenuToggledEvent.Handler() {
            @Override
            public void onMenuTypeChanged(LeftMenuToggledEvent.MenuType menuType) {
                if (menuType != LeftMenuToggledEvent.MenuType.USERS) {
                    return;
                }
                grid.refresh();

            }
        });


    }
}
