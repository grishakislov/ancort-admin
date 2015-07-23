package com.mttch.admin.client.ui.main.center.servers;

import com.google.gwt.editor.client.Editor;
import com.mttch.admin.common.model.grid.servers.SipServerModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

//TODO: BaseProperties<T>
public interface SipServersProperties extends PropertyAccess<SipServerModel> {

    ValueProvider<SipServerModel, Integer> id();
    ValueProvider<SipServerModel, String> server();
    ValueProvider<SipServerModel, String> description();
    ValueProvider<SipServerModel, Boolean> active();

    @Editor.Path("key")
    ModelKeyProvider<SipServerModel> key();


}
