package com.mttch.admin.client.presenter.main;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.callback.ServerCallback;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.server.administrator.AdministratorService;
import com.mttch.admin.client.server.administrator.AdministratorServiceAsync;
import com.mttch.admin.client.ui.main.center.administrators.AdministratorsGrid;
import com.mttch.admin.client.ui.main.center.administrators.AdministratorsPanel;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;

public class AdministratorsPanelPresenter extends AbstractPresenter {

    private AdministratorsPanel administratorsPanel;
    private AdministratorsGrid grid;

    private AdministratorServiceAsync administratorService = AdministratorService.ServiceLoader.getInstance();

    @Inject
    public AdministratorsPanelPresenter(SimpleEventBus eventBus, AdministratorsPanel administratorsPanel) {
        super(eventBus);
        this.administratorsPanel = administratorsPanel;
        this.grid = administratorsPanel.getAdministratorsGrid();
        bind();
    }

    @Override
    public void bind() {
        grid.getDeleteButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                //TODO: Implement
                Cell.Context c = event.getContext();
                int row = c.getIndex();
                final AdministratorModel model = grid.getGrid().getStore().get(row);
                grid.mask();
                administratorService.deleteAdministrator(model.getName(), new ServerCallback<Void>() {
                    @Override
                    public void onSuccess(Void result) {
                        grid.unmask();
                        grid.refresh();
                        Info.display("Event", model.getName() + " deleted");
                    }
                });

            }
        });

        administratorsPanel.getLoadAdministratorsButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                //TODO: implement
            }
        });

        grid.getGrid().getSelectionModel().addSelectionChangedHandler(new SelectionChangedEvent.SelectionChangedHandler<AdministratorModel>() {
            @Override
            public void onSelectionChanged(SelectionChangedEvent<AdministratorModel> event) {
                System.out.println(event.getSelection().get(0).getName());
            }
        });

        eventBus.addHandler(LeftMenuToggledEvent.TYPE, new LeftMenuToggledEvent.Handler() {
            @Override
            public void onMenuTypeChanged(LeftMenuToggledEvent.MenuType menuType) {
                if (menuType != LeftMenuToggledEvent.MenuType.ADMINISTRATORS) {
                    return;
                }
                grid.refresh();
            }
        });
    }
}
