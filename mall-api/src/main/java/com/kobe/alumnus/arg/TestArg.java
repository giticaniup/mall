package com.kobe.alumnus.arg;

import com.google.common.base.MoreObjects;

/**
 * @author zhongchengyong
 */
public class TestArg extends BaseArg{

    private static final long serialVersionUID = -3867100552542046608L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("token", token)
                .toString();
    }
}
