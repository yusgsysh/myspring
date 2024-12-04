package org.example.myspring.service;


import org.example.myspring.dao.AppRepository;
import org.example.myspring.entity.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {
    @Autowired
    private AppRepository appRepository;

    // 可以添加更多的业务逻辑方法
}