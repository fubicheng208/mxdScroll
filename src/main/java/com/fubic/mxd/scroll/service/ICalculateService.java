package com.fubic.mxd.scroll.service;

import com.fubic.mxd.scroll.model.Weapon;
import com.fubic.mxd.scroll.model.WeaponScroll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ICalculateService {
    List<WeaponScroll> getAllScroll();
    String getResult(Weapon weapon) throws Exception;
    List<WeaponScroll> getSelectedScroll(String[] selected);
    List<List<String>> filterByMainAndViceAttribute(List<List<String>> attackCollection, HashMap<String, Integer> mMainAttr, HashMap<String, Integer> mViceAttr, int scrollMainAttr, int scrollViceAttr);
}
