package com.mttch.admin.client.ui.main.center.services;

import com.mttch.admin.client.ui.grid.BaseProperties;
import com.mttch.admin.common.model.grid.service.XmppModel;
import com.sencha.gxt.core.client.ValueProvider;

public interface XmppProperties extends BaseProperties<XmppModel> {

    ValueProvider<XmppModel, String> username();

    ValueProvider<XmppModel, String> name();

    ValueProvider<XmppModel, String> email();

}
