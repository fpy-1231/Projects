package com.huawei.team.domain;

/**
 * @author fpystart
 * @create 2020-09-24 20:44
 */
public class Status {

    public final String NAME;

    public String getNAME() {
        return NAME;
    }

    private Status(String NAME) {
        this.NAME = NAME;
    }

    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    @Override
    public String toString() {
        return NAME;
    }
}
