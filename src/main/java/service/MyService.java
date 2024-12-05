package service;

import jakarta.annotation.Resource;
import org.example.myspring.dao.AppRepository;

import org.example.myspring.entity.App;

public class MyService {
    @Resource
    private AppRepository myRepository;

    public int insertApp(App app){
        return myRepository.insertApp(app);

    }
}
