package com.mttch.admin.client.ui.main.center.services;

import com.google.gwt.editor.client.Editor;
import com.mttch.admin.common.model.grid.service.MailboxModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface MailboxProperties extends PropertyAccess<MailboxModel> {

    ValueProvider<MailboxModel, String> login();
    ValueProvider<MailboxModel, String> username();
    ValueProvider<MailboxModel, String> password();
    ValueProvider<MailboxModel, Long> quota();
    ValueProvider<MailboxModel, String> maildir();

    @Editor.Path("key")
    ModelKeyProvider<MailboxModel> key();


}
