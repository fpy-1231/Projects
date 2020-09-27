package com.huawei.team.domain;

/**
 * @author fpystart
 * @create 2020-09-24 20:51
 */
public class Architect extends Designer {
    private int stock;

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + stock + "\t" + getEquipment().getDescription();
    }

    @Override
    public String getTeamDetails() {
        return getTeamBaseDetails() + "\t架构师\t" + getBonus() + "\t" + stock;
    }
}
