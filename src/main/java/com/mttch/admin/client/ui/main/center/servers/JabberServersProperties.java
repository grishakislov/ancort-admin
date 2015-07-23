package com.mttch.admin.client.ui.main.center.servers;

import com.google.gwt.editor.client.Editor;
import com.mttch.admin.common.model.grid.servers.JabberServerModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface JabberServersProperties extends PropertyAccess<JabberServerModel> {

    ValueProvider<JabberServerModel, String> description();
    ValueProvider<JabberServerModel, String> jabberserver();
    ValueProvider<JabberServerModel, String> jabberserverconf();
    ValueProvider<JabberServerModel, Integer> jabberport();
    ValueProvider<JabberServerModel, Integer> jabberportssl();
    ValueProvider<JabberServerModel, Boolean> act();

    @Editor.Path("key")
    ModelKeyProvider<JabberServerModel> key();
}
