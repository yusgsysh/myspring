package org.example.myspring.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.myspring.entity.App;

@Mapper
public interface MyRepository {
    @Insert("insert into app(mail,mail,ber,pho,kjnhjn,seikj,meikj,seikn,meikn,seien,seikn,sex) values(#{mail},#{mail},#{ber},#{pho},#{kjnhjn},#{seikj},#{meikj},#{seikn},#{meikn},#{seien},#{seikn},#{sex})")
    public int insertApp(App a);
}

