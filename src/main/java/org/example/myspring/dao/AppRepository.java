package org.example.myspring.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.myspring.entity.App;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AppRepository {
    // 可以添加一些自定义的数据库查询方法
    @Insert("insert into app(appcd, cstid, syokbn, mail, ber, pho, ukttme, appsts, brdcd, crdshucd, kjnhjn, seikj, seikn, seien, meikj, meikn, meien, sex, jkysbt, tel, post, knc, jskj1, jskj2, jskn1, jskn2, spgtorkbn, spgkbn, csgkbn, torkbn, driverid, kkhcd, hgsumk, kzkmlflg, cammlflg, bankcd, bchcd, ykn, actcd, actnae, actkkndte, actkknid, actkknnam, agtcd, hnnhhucd, hnnflg, hks1, hks2, hks3, hks4, hnnkkndte, hnnkknid, hnnkknnam, gyocd, kms, kmsdep, kmstel, kmsjs1, kmsjs2, nshym, nsg, kzkkbn, kzkflg, kzkseikj, kzkseikn, kzkseien, kzksex, kzkgyocd, kzkkms, kzkkmsdep, kzkkmstel, kzkhhucd, kzkks1, kzkks2, kzkks3, kzkks4, kzkkknate, kzkkknid, kzkkknnam, ysninf, skjsskflg, sskiritme, sskcd, sskjrytme, appcnctme, oldcrdcd, insertdte, insertid, updatedte, updateid, deleteflg, deletedte) values (#{appcd},#{cstid},#{syokbn},#{mail},#{ber},#{pho},#{ukttme},#{appsts},#{brdcd},#{crdshucd},#{kjnhjn},#{seikj},#{seikn},#{seien},#{meikj},#{meikn},#{meien},#{sex},#{jkysbt},#{tel},#{post},#{knc},#{jskj1},#{jskj2},#{jskn1},#{jskn2},#{spgtorkbn},#{spgkbn},#{csgkbn},#{torkbn},#{driverid},#{kkhcd},#{hgsumk},#{kzkmlflg},#{cammlflg},#{bankcd},#{bchcd},#{ykn},#{actcd},#{actnae},#{actkkndte},#{actkknid},#{actkknnam},#{agtcd},#{hnnhhucd},#{hnnflg},#{hks1},#{hks2},#{hks3},#{hks4},#{hnnkkndte},#{hnnkknid},#{hnnkknnam},#{gyocd},#{kms},#{kmsdep},#{kmstel},#{kmsjs1},#{kmsjs2},#{nshym},#{nsg},#{kzkkbn},#{kzkflg},#{kzkseikj},#{kzkseikn},#{kzkseien},#{kzksex},#{kzkgyocd},#{kzkkms},#{kzkkmsdep},#{kzkkmstel},#{kzkhhucd},#{kzkks1},#{kzkks2},#{kzkks3},#{kzkks4},#{kzkkknate},#{kzkkknid},#{kzkkknnam},#{ysninf},#{skjsskflg},#{sskiritme},#{sskcd},#{sskjrytme},#{appcnctme},#{oldcrdcd},#{insertdte},#{insertid},#{updatedte},#{updateid},#{deleteflg},#{deletedte})")
    public int insertApp(App app);

    @Select("select * from app order by APPCD")
    public List<App> findAllApps();

    @Select("select * from app where APPCD=#{appcd}")
    public App findAppById(String appcd);
}
