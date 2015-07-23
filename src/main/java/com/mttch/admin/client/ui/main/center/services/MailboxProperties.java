package com.mttch.admin.client.ui.main.center.services;

import com.mttch.admin.client.ui.grid.BaseProperties;
import com.mttch.admin.common.model.grid.service.MailboxModel;
import com.sencha.gxt.core.client.ValueProvider;

public interface MailboxProperties extends BaseProperties<MailboxModel> {

    ValueProvider<MailboxModel, String> login();

    ValueProvider<MailboxModel, String> username();

    ValueProvider<MailboxModel, String> password();

    ValueProvider<MailboxModel, Long> quota();

    ValueProvider<MailboxModel, String> maildir();

}
