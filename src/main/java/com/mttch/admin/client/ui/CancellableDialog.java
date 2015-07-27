package com.mttch.admin.client.ui;

import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

import java.util.List;

public abstract class CancellableDialog extends Dialog {

    private TextButton cancelButton;

    public CancellableDialog() {
        cancelButton = new TextButton("Отмена");
        cancelButton.setWidth(80);
        cancelButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                hide();
            }
        });
        getButtonBar().clear();
        for (TextButton button : getButtons()) {
            getButtonBar().add(button);
        }
        getButtonBar().add(cancelButton);
    }

    protected abstract List<TextButton> getButtons();
}
