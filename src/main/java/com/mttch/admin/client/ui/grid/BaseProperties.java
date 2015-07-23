package com.mttch.admin.client.ui.grid;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

public interface BaseProperties<T> extends PropertyAccess<T> {

    @Editor.Path("key")
    ModelKeyProvider<T> key();

}
