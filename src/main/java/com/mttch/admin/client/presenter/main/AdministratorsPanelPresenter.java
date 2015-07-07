package com.mttch.admin.client.presenter.main;

import com.google.gwt.cell.client.Cell;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.callback.ServerCallback;
import com.mttch.admin.client.events.LeftMenuToggledEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.server.administrator.AdministratorService;
import com.mttch.admin.client.server.administrator.AdministratorServiceAsync;
import com.mttch.admin.client.ui.main.center.administrators.AddAdministratorDialog;
import com.mttch.admin.client.ui.main.center.administrators.AdministratorsGrid;
import com.mttch.admin.client.ui.main.center.administrators.AdministratorsPanel;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.sencha.gxt.fx.client.FxElement;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.info.Info;
import com.sencha.gxt.widget.core.client.selection.SelectionChangedEvent;

public class AdministratorsPanelPresenter extends AbstractPresenter {

    private AdministratorsPanel administratorsPanel;
    private AdministratorsGrid grid;
    private AddAdministratorDialog addAdministratorDialog;

    private AdministratorServiceAsync administratorService = AdministratorService.ServiceLoader.getInstance();

    @Inject
    public AdministratorsPanelPresenter(SimpleEventBus eventBus,
                                        AdministratorsPanel administratorsPanel,
                                        AddAdministratorDialog addAdministratorDialog) {
        super(eventBus);
        this.administratorsPanel = administratorsPanel;
        this.grid = administratorsPanel.getAdministratorsGrid();
        this.addAdministratorDialog = addAdministratorDialog;
        bind();
    }

    @Override
    public void bind() {
        eventBus.addHandler(LeftMenuToggledEvent.TYPE, new LeftMenuToggledEvent.Handler() {
            @Override
            public void onMenuTypeChanged(LeftMenuToggledEvent.MenuType menuType) {
                if (menuType != LeftMenuToggledEvent.MenuType.ADMINISTRATORS) {
                    return;
                }
                grid.refresh();
            }
        });

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

        grid.getGrid().getSelectionModel().addSelectionChangedHandler(new SelectionChangedEvent.SelectionChangedHandler<AdministratorModel>() {
            @Override
            public void onSelectionChanged(SelectionChangedEvent<AdministratorModel> event) {
//                System.out.println(event.getSelection().get(0).getName());
            }
        });

        administratorsPanel.getAddAdministratorButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                addAdministratorDialog.show();
            }
        });

        addAdministratorDialog.getSaveButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                handleAddAdministrator();
            }
        });
    }

    private void handleAddAdministrator() {
        boolean valid = checkForm();
        if (valid) {
            final String name = addAdministratorDialog.getLoginField().getValue();
            String password = addAdministratorDialog.getPasswordField1().getValue();

            administratorService.addAdministrator(name, password, new ServerCallback<Void>() {
                @Override
                public void onSuccess(Void result) {
                    addAdministratorDialog.hide();
                    grid.refresh();
                    Info.display("Success", name + " added");
                }
            });
        } else {
            addAdministratorDialog.getElement().<FxElement>cast().blink();
        }
    }

    private boolean checkForm() {
        String name = addAdministratorDialog.getLoginField().getValue();
        String p1 = addAdministratorDialog.getPasswordField1().getValue();
        String p2 = addAdministratorDialog.getPasswordField2().getValue();
        return name != null && p1 != null && p2 != null && p1.equals(p2);
    }
}
