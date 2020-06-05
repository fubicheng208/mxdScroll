package com.fubic.mxd.scroll.service;

import com.fubic.mxd.scroll.dto.WeaponEmailDTO;

public interface ISendMailService {
    void sendEmail();
    void sendCalculateWeaponEmail(String email, String content);
}
