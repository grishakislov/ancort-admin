package com.mttch.admin.client.ui.main.center.administrators;

import com.google.gwt.editor.client.Editor;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface AdministratorProperties extends PropertyAccess<AdministratorModel> {

    ValueProvider<AdministratorModel, Integer> id();
    ValueProvider<AdministratorModel, String> name();
    ValueProvider<AdministratorModel, String> online();

    @Editor.Path("key")
    ModelKeyProvider<AdministratorModel> key();

}
