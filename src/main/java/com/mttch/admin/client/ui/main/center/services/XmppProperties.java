package com.mttch.admin.client.ui.main.center.services;

import com.google.gwt.editor.client.Editor;
import com.mttch.admin.common.model.grid.service.XmppModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface XmppProperties extends PropertyAccess<XmppModel> {

    ValueProvider<XmppModel, String> username();
    ValueProvider<XmppModel, String> name();
    ValueProvider<XmppModel, String> email();

    @Editor.Path("key")
    ModelKeyProvider<XmppModel> key();

}
