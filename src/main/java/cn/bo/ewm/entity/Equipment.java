package cn.bo.ewm.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Equipment {
    private Integer oid;
    private String name;
    private Site site; // 所属工地 多对一
    private String mubanName; // 模板名 多对一
    private Set<MaintainGroup> maintainGroups = new HashSet<>();//所属维护组 多对多
    private Integer maintainGroupNumber;
    private Set<Staff> staffs = new HashSet<>();//设备所属的维护人员 多对多
    private Integer staffNumber;
    private Set<Record> records = new HashSet<>();// 设备的维护记录 一对多
    private Integer recordNumber;

    public Integer getMaintainGroupNumber() {
        return maintainGroups.size();
    }

    public Integer getStaffNumber() {
        Integer num = 0;
        for (MaintainGroup mg:maintainGroups) {
            num+=mg.getStaffs().size();
        }
        // 直接维护人员
//        num+=staffs.size();
        return num;
    }

    public Integer getRecordNumber() {
        return records.size();
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

    public String getMubanName() {
        return mubanName;
    }

    public void setMubanName(String mubanName) {
        this.mubanName = mubanName;
    }

    public Set<MaintainGroup> getMaintainGroups() {
        return maintainGroups;
    }

    public void setMaintainGroups(Set<MaintainGroup> maintainGroups) {
        this.maintainGroups = maintainGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(oid, equipment.oid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oid);
    }
}
