package cn.bo.ewm.entity;

import java.util.Date;

/**
 * 维护记录
 */
public class Record {
    private Integer oid;
    private Staff staff; // 维护员工 多对一
    private Equipment equipment; // 维护设备 多对一
    private Date date; // 维护时间
    private String info; // 维护信息

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
