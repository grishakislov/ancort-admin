package com.mttch.admin.client.ui.main.center.servers;

import com.mttch.admin.client.ui.grid.BaseProperties;
import com.mttch.admin.common.model.grid.servers.MailServerModel;
import com.sencha.gxt.core.client.ValueProvider;

public interface MailServersProperties extends BaseProperties<MailServerModel> {

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

}
