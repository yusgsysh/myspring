package service;

import jakarta.annotation.Resource;
import org.example.myspring.dao.MyRepository;
import org.example.myspring.entity.App;

public class MyService {
    @Resource
    private MyRepository myRepository;

    public int insertapp(App app){
        return myRepository.insertApp(app);
    }
}
