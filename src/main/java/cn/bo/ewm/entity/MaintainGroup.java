package cn.bo.ewm.entity;

import java.util.HashSet;
import java.util.Set;

public class MaintainGroup {
    private Integer oid;
    private String name;
    private String info;
    private Set<Staff> staffs = new HashSet<>();//该维护组的员工 多对多
    private Set<Equipment> equipments = new HashSet<>(); // 该维护组的设备 多对多

    public Integer getStaffNumber() {
        return staffs.size();
    }
    public Integer getEquipmentNumber() {
        return equipments.size();
    }


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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Set<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(Set<Staff> staffs) {
        this.staffs = staffs;
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
    }
}
