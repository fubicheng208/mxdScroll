package com.fubic.mxd.scroll.mapper;

import com.fubic.mxd.scroll.model.WeaponScroll;

import java.util.List;

//        mybatis流程：
//        1. 添加依赖
//        2. 创建接口类
//        3. 根据接口类的方法编写mapper.xml
//        4. application.properties添加备注
//        5. 启动类里添加mapper接口扫描

public interface ScrollMapper {
    int save(WeaponScroll scroll);

    WeaponScroll selectById(String id);
    List<WeaponScroll> selectAll();

}
