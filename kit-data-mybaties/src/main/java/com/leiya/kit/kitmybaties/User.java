package com.leiya.kit.kitmybaties;

import java.io.Serializable;

/**
 * @author: honglei
 * @Date: 2018/9/29 11:23
 * @Version: 1.0
 * @See:
 * @Description:
 */
public class User implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
