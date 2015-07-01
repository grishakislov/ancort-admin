package com.mttch.admin.client.ui.login;

import com.google.gwt.user.client.ui.IsWidget;
import com.mttch.admin.client.ui.UiColors;
import com.mttch.admin.common.StringConstants;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.PasswordField;
import com.sencha.gxt.widget.core.client.form.TextField;


public class LoginView extends ContentPanel {

    private TextButton submitButton;

    private FramedPanel panel;
    private FormPanel form;

    private TextField username;
    private PasswordField password;

    public LoginView() {
        submitButton = new TextButton(StringConstants.LOGIN);
        submitButton.setWidth(79);
        username = new TextField();
        username.setAllowBlank(false);
        password = new PasswordField();
        password.setAllowBlank(false);

        form = createForm();

        panel = new FramedPanel();
        panel.setHeadingText(StringConstants.LOGIN_TO_ACCESS_YOUR_ACCOUNT);
        panel.setButtonAlign(BoxLayoutContainer.BoxLayoutPack.CENTER);
        panel.setWidth(300);
        panel.setHeight(160);
        panel.add(form);
        panel.getButtonBar().setPosition(0, -5);
        panel.addButton(submitButton);

        CenterLayoutContainer centerLayoutContainer = new CenterLayoutContainer();
        centerLayoutContainer.add(panel);

        //TODO: Check in Firefox
        setBodyStyle("background-color:" + UiColors.LIGHT_BLUE);

        add(centerLayoutContainer);
    }

    private FormPanel createForm() {
        VerticalLayoutContainer container = new VerticalLayoutContainer();
        container.add(createFieldLabel(username, StringConstants.USERNAME), new VerticalLayoutContainer.VerticalLayoutData(25, -1));
        container.add(createFieldLabel(password, StringConstants.PASSWORD), new VerticalLayoutContainer.VerticalLayoutData(25, -1));
        FormPanel result = new FormPanel();
        result.add(container, new MarginData(10));
        return result;
    }

    private FieldLabel createFieldLabel(IsWidget textField, String label) {
        FieldLabel fieldLabel = new FieldLabel(textField, label);
        fieldLabel.setLabelAlign(FormPanel.LabelAlign.LEFT);
        fieldLabel.setLabelWidth(75);
        fieldLabel.setWidth(270);
        return fieldLabel;
    }

    public TextButton getSubmitButton() {
        return submitButton;
    }

    public TextField getUsername() {
        return username;
    }

    public PasswordField getPassword() {
        return password;
    }

    public FramedPanel getPanel() {
        return panel;
    }
}
