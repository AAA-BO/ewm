package cn.bo.ewm.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 维护记录
 */
public class Record {
    private int oid;
    private Staff staff; // 维护人
    private Equipment equipment; // 维护设备
    private Date date; // 维护时间
    private String info; // 维护信息

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
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

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Record)) return false;
        Record record = (Record) o;
        return getOid() == record.getOid() &&
                Objects.equals(getStaff(), record.getStaff()) &&
                Objects.equals(getEquipment(), record.getEquipment()) &&
                Objects.equals(getDate(), record.getDate()) &&
                Objects.equals(getInfo(), record.getInfo());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOid(), getStaff(), getEquipment(), getDate(), getInfo());
    }*/
}
