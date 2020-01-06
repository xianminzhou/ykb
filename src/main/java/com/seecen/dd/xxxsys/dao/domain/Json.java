package com.seecen.dd.xxxsys.dao.domain;

import java.util.List;

public class Json<T> {
    //200成功 404 找不到 500错误 400参数不正确
    private int code;
    //返回错误信息
    private String msg;

    private List<T> list;

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Json(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Json() {
    }
}
