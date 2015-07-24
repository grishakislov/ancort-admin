package com.mttch.admin.client.ui.grid.servers;

import com.mttch.admin.client.ui.grid.BaseProperties;
import com.mttch.admin.common.model.grid.servers.JabberServerModel;
import com.sencha.gxt.core.client.ValueProvider;

public interface JabberServersProperties extends BaseProperties<JabberServerModel> {

    ValueProvider<JabberServerModel, String> description();

    ValueProvider<JabberServerModel, String> jabberserver();

    ValueProvider<JabberServerModel, String> jabberserverconf();

    ValueProvider<JabberServerModel, Integer> jabberport();

    ValueProvider<JabberServerModel, Integer> jabberportssl();

    ValueProvider<JabberServerModel, Boolean> act();

}
