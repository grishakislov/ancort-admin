package com.mttch.admin.client.ui.grid.users;

import com.mttch.admin.client.ui.grid.BaseProperties;
import com.mttch.admin.common.model.grid.UserModel;
import com.sencha.gxt.core.client.ValueProvider;

public interface UserProperties extends BaseProperties<UserModel> {

    ValueProvider<UserModel, String> createDate();

    ValueProvider<UserModel, String> receiveDate();

    ValueProvider<UserModel, String> firstRequestDate();

    ValueProvider<UserModel, Integer> cryptoNumber();

    ValueProvider<UserModel, String> login();

    ValueProvider<UserModel, String> deviceId();

    ValueProvider<UserModel, String> platform();

    ValueProvider<UserModel, String> pushToken();

    ValueProvider<UserModel, Integer> license();

    ValueProvider<UserModel, Integer> linkTable();


}
