package bak2.entity;

import java.util.HashSet;
import java.util.Set;

public class Site {
    private Integer oid;
    private String name;
    private String info;//工地简介
    //    private Staff manager;//工地负责人
    // 两个冗余数据
    private Integer staffNumber;//工地员工数
    private Integer equipmentNumber;//工地设备数
    private Set<Staff> staffs = new HashSet<>();//工地员工 多对一
    private Set<Equipment> equipments = new HashSet<>();// 工地设备 多对一

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

    public Integer getStaffNumber() {
        return staffNumber;
    }

    public void setStaffNumber(Integer staffNumber) {
        this.staffNumber = staffNumber;
    }

    public Integer getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(Integer equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
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
