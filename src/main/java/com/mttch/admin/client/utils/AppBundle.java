package com.mttch.admin.client.utils;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface AppBundle extends ClientBundle {

    @ClientBundle.Source("../resources/images/logo.png")
    ImageResource appLogo();

    public static final AppBundle INSTANCE = GWT.create(AppBundle.class);

}
