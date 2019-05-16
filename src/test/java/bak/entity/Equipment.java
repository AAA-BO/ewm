package bak.entity;

import java.util.HashSet;
import java.util.Set;

public class Equipment {
    private Integer oid;
    private String name;
    private Site site; // 所属工地 多对一
    private Set<Staff> staffs = new HashSet<>();//设备所属的维护人员 多对多
    private Set<Record> records = new HashSet<>();// 设备的维护记录 一对多

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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public Set<Record> getRecords() {
        return records;
    }

    public void setRecords(Set<Record> records) {
        this.records = records;
    }
}
