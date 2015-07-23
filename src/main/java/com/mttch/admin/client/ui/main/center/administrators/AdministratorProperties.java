package com.mttch.admin.client.ui.main.center.administrators;

import com.mttch.admin.client.ui.grid.BaseProperties;
import com.mttch.admin.common.model.grid.AdministratorModel;
import com.sencha.gxt.core.client.ValueProvider;

public interface AdministratorProperties extends BaseProperties<AdministratorModel> {

    ValueProvider<AdministratorModel, Integer> id();

    ValueProvider<AdministratorModel, String> name();

    ValueProvider<AdministratorModel, String> online();

}
