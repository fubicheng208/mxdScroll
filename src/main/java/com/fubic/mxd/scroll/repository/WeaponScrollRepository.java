package com.fubic.mxd.scroll.repository;

import com.fubic.mxd.scroll.model.WeaponScroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponScrollRepository extends JpaRepository<WeaponScroll, String> {
}
