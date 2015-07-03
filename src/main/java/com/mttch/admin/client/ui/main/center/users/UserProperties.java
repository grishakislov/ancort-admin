package com.mttch.admin.client.ui.main.center.users;

import com.google.gwt.editor.client.Editor;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface UserProperties extends PropertyAccess<UserModel> {

    ValueProvider<UserModel, String> createDate();
    ValueProvider<UserModel, String> receiveDate();
    ValueProvider<UserModel, String> firstQueryDate();
    ValueProvider<UserModel, Integer> cryptoNumber();


    @Editor.Path("key")
    ModelKeyProvider<UserModel> key();

    ValueProvider<UserModel, String> login();


    ValueProvider<UserModel, String> deviceId();
    ValueProvider<UserModel, String> platform();
    ValueProvider<UserModel, String> pushToken();
    ValueProvider<UserModel, Integer> license();
    ValueProvider<UserModel, Integer> linkTable();


}
