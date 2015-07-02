package com.mttch.admin.client.ui.main.center.users;

import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

import java.util.List;

public class UsersGrid extends Grid<UserModel> {

    public UsersGrid() {
        super(createListStore(), createColumnModel());
    }

    private static ListStore<UserModel> createListStore() {
        ListStore<UserModel> store = new ListStore<>(new ModelKeyProvider<UserModel>() {
            @Override
            public String getKey(UserModel item) {
                return item.getLogin();
            }
        });

        return store;
    }

    private static ColumnModel<UserModel> createColumnModel() {
        ColumnModel<UserModel> columnModel = new ColumnModel<>(createColumnConfig());
        return null;
    }

    private static List<ColumnConfig<UserModel, ?>> createColumnConfig() {
        return null;
    }

}
