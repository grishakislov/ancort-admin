package com.mttch.admin.client.ui.main.center.logs;

import com.mttch.admin.client.ui.grid.BaseProperties;
import com.mttch.admin.common.model.grid.log.AdminLogModel;
import com.sencha.gxt.core.client.ValueProvider;

public interface AdminLogProperties extends BaseProperties<AdminLogModel> {

    ValueProvider<AdminLogModel, Long> id();

    ValueProvider<AdminLogModel, Integer> event();

    ValueProvider<AdminLogModel, String> useragent();

    ValueProvider<AdminLogModel, Integer> cryptonumber();

    ValueProvider<AdminLogModel, String> user();

    ValueProvider<AdminLogModel, String> dt();

    ValueProvider<AdminLogModel, String> text();

    ValueProvider<AdminLogModel, String> ip();

}
