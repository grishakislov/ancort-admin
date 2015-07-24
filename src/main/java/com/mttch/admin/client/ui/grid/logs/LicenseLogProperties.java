package com.mttch.admin.client.ui.grid.logs;

import com.mttch.admin.client.ui.grid.BaseProperties;
import com.mttch.admin.common.model.grid.log.LicenseLogModel;
import com.sencha.gxt.core.client.ValueProvider;

public interface LicenseLogProperties extends BaseProperties<LicenseLogModel> {

    ValueProvider<LicenseLogModel, Long> id();

    ValueProvider<LicenseLogModel, String> method();

    ValueProvider<LicenseLogModel, Integer> cryptonumber();

    ValueProvider<LicenseLogModel, Integer> event();

    ValueProvider<LicenseLogModel, String> text();

    ValueProvider<LicenseLogModel, String> dt();

    ValueProvider<LicenseLogModel, String> ip();

    ValueProvider<LicenseLogModel, String> server();

    ValueProvider<LicenseLogModel, Boolean> active();

    ValueProvider<LicenseLogModel, Long> user();

}
