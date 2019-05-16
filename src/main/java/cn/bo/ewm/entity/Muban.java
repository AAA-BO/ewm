package cn.bo.ewm.entity;

import java.util.HashSet;
import java.util.Set;

public class Muban {
    private Integer oid;
    private String name;
    private String filedName;
    private String filedType;
    private String filedItem;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getFiledType() {
        return filedType;
    }

    public void setFiledType(String filedType) {
        this.filedType = filedType;
    }

    public String getFiledItem() {
        return filedItem;
    }

    public void setFiledItem(String filedItem) {
        this.filedItem = filedItem;
    }

}

