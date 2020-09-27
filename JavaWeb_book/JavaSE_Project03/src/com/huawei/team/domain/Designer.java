package com.huawei.team.domain;

/**
 * @author fpystart
 * @create 2020-09-24 20:49
 */
public class Designer extends Programmer {
    private double bonus;

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" + bonus + "\t\t\t" + getEquipment().getDescription();
    }

    @Override
    public String getTeamDetails() {
        return getTeamBaseDetails() + "\t设计师\t" + bonus;
    }
}
