package com.mttch.admin.server.mybatis;

import com.mttch.admin.common.model.grid.AdministratorModel;
import com.mttch.admin.common.model.grid.UserModel;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AdministratorDao {

    private List<AdministratorModel> administrators = new ArrayList<>();
    private final int COUNT = 10;

    @PostConstruct
    private void init() {
        for (int i = 0; i < COUNT; i++) {
            administrators.add(createAdministrator(i));
        }
    }

    public List<AdministratorModel> listAdministrators(int limit, int offset) {
        List<AdministratorModel> list = new ArrayList<>();
        int last = offset + limit > administrators.size() ? administrators.size() : offset + limit;
        for (int i = offset; i < last; i++) {
            list.add(administrators.get(i));
        }
        return list;
    }

    private AdministratorModel createAdministrator(int i) {
        AdministratorModel model = new AdministratorModel();
        model.setId(i);
        model.setName("Administrator " + i);
        model.setKey("Administrator " + i);
        boolean isNew = i % 2 == 0 && i > 5;
        model.setOnline(isNew ? "New" : "27.06.15 23:24:08");
        return model;
    }

    public int administratorsCount() {
        return administrators.size();
    }

    public void deleteAdministrator(String name) {
        int index = -1;
        for (int i = 0; i < administrators.size(); i++) {
            AdministratorModel administrator = administrators.get(i);
            if (administrator.getName().equals(name)) {
                index = i;
            }
        }
        administrators.remove(index);
    }

}
