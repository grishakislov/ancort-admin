package com.mttch.admin.common.model.grid;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
import com.sencha.gxt.data.shared.loader.DataProxy;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;

import java.util.List;

public class ServerPagingLoadResult<T> extends PagingLoadResultBean<T> {

    protected ServerPagingLoadResult () {
    }

    public ServerPagingLoadResult (List<T> list, int totalLength, int offset) {
        super(list, totalLength, offset);
    }
    @ProxyFor(ServerPagingLoadResult.class)
    public interface ServerPagingLoadResultProxy extends ValueProxy, PagingLoadResult<DataProxy> {
        @Override
        List<DataProxy> getData();
    }
}
