package com.mttch.admin.client.ui.grid.administrators;

import com.google.gwt.user.client.ui.IsWidget;
import com.mttch.admin.client.utils.UiFactory;
import com.mttch.admin.common.StringConstants;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;

public class AddAdministratorDialog extends Dialog {

    //TODO: move to abstract dialog
    private TextButton cancelButton;

    private TextButton saveButton;

    private TextField loginField;
    private PasswordField passwordField1;
    private PasswordField passwordField2;

    public AddAdministratorDialog() {
        initUi();
    }

    private void initUi() {
        setAllowTextSelection(false);
        setBlinkModal(true);
        getHeader().setText("Добавить администратора");
        setHeight(200);
        setWidth(425);
        setResizable(false);
        setModal(true);
        getButtonBar().clear();

        saveButton = new TextButton("Сохранить");
        saveButton.setWidth(80);

        cancelButton = new TextButton("Отмена");
        cancelButton.setWidth(80);

        cancelButton.addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                hide();
            }
        });

        getButtonBar().add(saveButton);
        getButtonBar().add(cancelButton);

        //Form
        loginField = new TextField();
        loginField.setAllowBlank(false);
        passwordField1 = new PasswordField();
        passwordField1.setAllowBlank(false);
        passwordField2 = new PasswordField();
        passwordField2.setAllowBlank(false);
        add(createForm(), new MarginData(0, 0, 0, 50));
        forceLayout();
    }

    private FormPanel createForm() {
        VerticalLayoutContainer container = new VerticalLayoutContainer();
        container.add(UiFactory.createVerticalSpacer(10));
        container.add(createFieldLabel(loginField, StringConstants.USERNAME), new VerticalLayoutContainer.VerticalLayoutData(35, -1));
        container.add(createFieldLabel(passwordField1, StringConstants.PASSWORD), new VerticalLayoutContainer.VerticalLayoutData(35, -1));
        container.add(createFieldLabel(passwordField2, StringConstants.RETYPE_PASSWORD), new VerticalLayoutContainer.VerticalLayoutData(35, -1));

        FormPanel form = new FormPanel();
        form.add(container);
        form.setResize(false);
        return form;
    }

    private FieldLabel createFieldLabel(IsWidget textField, String label) {
        FieldLabel fieldLabel = new FieldLabel(textField, label);
        fieldLabel.setLabelAlign(FormPanel.LabelAlign.LEFT);
        fieldLabel.setLabelWidth(135);
        fieldLabel.setWidth(320);
        return fieldLabel;
    }

    public TextButton getSaveButton() {
        return saveButton;
    }

    public TextField getLoginField() {
        return loginField;
    }

    public PasswordField getPasswordField1() {
        return passwordField1;
    }

    public PasswordField getPasswordField2() {
        return passwordField2;
    }

    public void reset() {
        //TODO: fix it
        loginField.clear();
        loginField.setWidth(180);
        passwordField1.clear();
        passwordField1.setWidth(180);
        passwordField2.clear();
        passwordField2.setWidth(180);
        forceLayout();
    }
}
