package com.fubic.mxd.scroll.mapper;

import com.fubic.mxd.scroll.model.WeaponScroll;

import java.util.List;

public interface ScrollMapper {
    int save(WeaponScroll scroll);

    WeaponScroll selectById(String id);
    List<WeaponScroll> selectAll();

}
