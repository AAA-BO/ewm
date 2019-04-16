package cn.bo.ewm.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equipment {
    private int oid;
    private String name;// 设备名
    private Set<Staff> staffs = new HashSet<>();//设备所属的维护人员
    private Set<Record> records = new HashSet<>();// 设备的维护记录


    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;
        Equipment equipment = (Equipment) o;
        return getOid() == equipment.getOid();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOid());
    }
}
