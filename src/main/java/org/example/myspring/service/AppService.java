package org.example.myspring.service;


import jakarta.annotation.Resource;
import org.example.myspring.dao.AppRepository;
import org.example.myspring.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {
    @Resource
    private AppRepository appRepository;
    public int insertApp(App app) {
        return appRepository.insertApp(app);
    }
    public List<App> findAllAppsApp(App app) {
        return appRepository.findAllApps();
    }
    public App findAppById(String id) {
        return appRepository.findAppById(id);
    }

    // 可以添加更多的业务逻辑方法
}