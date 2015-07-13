package com.mttch.admin.client.ui.main.center.logs;

import com.google.gwt.editor.client.Editor;
import com.mttch.admin.common.model.grid.log.LicenseLogModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface LicenseLogProperties extends PropertyAccess<LicenseLogModel> {

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

    @Editor.Path("key")
    ModelKeyProvider<LicenseLogModel> key();

}
