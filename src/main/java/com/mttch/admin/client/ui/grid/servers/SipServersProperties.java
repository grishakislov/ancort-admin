package com.mttch.admin.client.ui.grid.servers;

import com.mttch.admin.client.ui.grid.BaseProperties;
import com.mttch.admin.common.model.grid.servers.SipServerModel;
import com.sencha.gxt.core.client.ValueProvider;

public interface SipServersProperties extends BaseProperties<SipServerModel> {

    ValueProvider<SipServerModel, Integer> id();

    ValueProvider<SipServerModel, String> server();

    ValueProvider<SipServerModel, String> description();

    ValueProvider<SipServerModel, Boolean> active();

}
