package com.mttch.admin.client.presenter.login;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.inject.Inject;
import com.mttch.admin.client.callback.ServerCallback;
import com.mttch.admin.client.events.AuthenticationCompletedEvent;
import com.mttch.admin.client.events.LogoutEvent;
import com.mttch.admin.client.presenter.AbstractPresenter;
import com.mttch.admin.client.server.login.LoginService;
import com.mttch.admin.client.server.login.LoginServiceAsync;
import com.mttch.admin.client.ui.login.LoginView;
import com.mttch.admin.common.model.AuthenticationResult;
import com.sencha.gxt.fx.client.FxElement;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

public class LoginPresenter extends AbstractPresenter {

    private LoginView loginView;

    @Inject
    public LoginPresenter(SimpleEventBus eventBus, LoginView loginView) {
        super(eventBus);
        this.loginView = loginView;
        bind();
    }

    @Override
    public void bind() {
        loginView.getSubmitButton().addSelectHandler(new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                handleSubmit();
            }
        });
        eventBus.addHandler(LogoutEvent.TYPE, new LogoutEvent.Handler() {
            @Override
            public void onLogout() {
                clearFields();
            }
        });
    }

    private void clearFields() {
        loginView.getUsername().setText("");
        loginView.getPassword().setText("");

    }

    private void handleSubmit() {
        boolean valid = checkForm();

        if (valid) {
            String login = loginView.getUsername().getValue();
            String password = loginView.getPassword().getValue();
            LoginServiceAsync loginServiceAsync = LoginService.ServiceLoader.getInstance();
            loginServiceAsync.authenticate(login, password, new ServerCallback<AuthenticationResult>() {
                @Override
                public void onSuccess(AuthenticationResult result) {
                    if (result.isAuthenticated()) {
                        eventBus.fireEvent(new AuthenticationCompletedEvent(result));
                    } else {
                        loginView.getPanel().getElement().<FxElement>cast().blink();
                    }
                }
            });
        } else {
            //TODO?
        }
    }

    private boolean checkForm() {
        return loginView.getUsername().isValid() && loginView.getPassword().isValid();
    }
}
