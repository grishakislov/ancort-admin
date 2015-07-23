package com.mttch.admin.client.ui.main.center.servers;

import com.google.gwt.editor.client.Editor;
import com.mttch.admin.common.model.grid.servers.MailServerModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface MailServersProperties extends PropertyAccess<MailServerModel> {

    ValueProvider<MailServerModel, String> hostName();

    ValueProvider<MailServerModel, Integer> popPort();

    ValueProvider<MailServerModel, String> popSecurity();

    ValueProvider<MailServerModel, Integer> smtpPort();

    ValueProvider<MailServerModel, String> smtpSecurity();

    ValueProvider<MailServerModel, String> ip();

    ValueProvider<MailServerModel, String> baseDir();

    ValueProvider<MailServerModel, String> storageNode();

    ValueProvider<MailServerModel, Integer> maxMailboxes();

    ValueProvider<MailServerModel, Integer> maxUse();

    @Editor.Path("key")
    ModelKeyProvider<MailServerModel> key();

}
