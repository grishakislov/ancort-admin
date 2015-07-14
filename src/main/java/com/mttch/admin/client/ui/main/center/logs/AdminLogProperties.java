package com.mttch.admin.client.ui.main.center.logs;

import com.google.gwt.editor.client.Editor;
import com.mttch.admin.common.model.grid.log.AdminLogModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface AdminLogProperties extends PropertyAccess<AdminLogModel> {

    ValueProvider<AdminLogModel, Long> id();
    ValueProvider<AdminLogModel, Integer> event();
    ValueProvider<AdminLogModel, String> useragent();
    ValueProvider<AdminLogModel, Integer> cryptonumber();
    ValueProvider<AdminLogModel, String> user();
    ValueProvider<AdminLogModel, String> dt();
    ValueProvider<AdminLogModel, String> text();
    ValueProvider<AdminLogModel, String> ip();

    @Editor.Path("key")
    ModelKeyProvider<AdminLogModel> key();

}
