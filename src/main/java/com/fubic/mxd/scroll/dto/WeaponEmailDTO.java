package com.fubic.mxd.scroll.dto;

import com.fubic.mxd.scroll.model.Weapon;

import javax.validation.constraints.Email;
import java.io.Serializable;

public class WeaponEmailDTO implements Serializable {
    private static final long serialVersionUID = -1196974013493367583L;
    Weapon weapon;
    @Email
    String email;

    public WeaponEmailDTO() {
    }

    public WeaponEmailDTO(Weapon weapon, String email) {
        this.weapon = weapon;
        this.email = email;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "WeaponEmailDTO{" +
                "weapon=" + weapon.toString() +
                ", email='" + email + '\'' +
                '}';
    }
}
