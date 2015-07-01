package com.mttch.admin.client.presenter;

import com.google.gwt.event.shared.SimpleEventBus;

public abstract class AbstractPresenter {

    protected SimpleEventBus eventBus;

    public AbstractPresenter(SimpleEventBus eventBus) {
        this.eventBus = eventBus;
    }

    public abstract void bind();
}
