package com.mttch.admin.server.mybatis.helpers;

import com.mttch.admin.server.mybatis.entity.LicenseEntity;
import org.apache.ibatis.type.EnumTypeHandler;

public class PlatformTypeHandler extends EnumTypeHandler<LicenseEntity.Platform> {

    public PlatformTypeHandler() {
        super(LicenseEntity.Platform.class);
    }

}

