package com.mttch.admin.client.ui;

import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.Grid;

import java.util.ArrayList;
import java.util.List;

public class AbstractGrid<T> extends SimpleContainer {

    private Grid<T> grid;

    private List<ColumnConfig<T, String>> columnConfigs = new ArrayList<>();

    public void addColumnConfig(ColumnConfig<T, String> value) {

    }

    public void addColumnConfigs(List<ColumnConfig<T, String>> value) {

    }

    public void build() {

    }

}
