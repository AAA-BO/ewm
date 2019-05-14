package cn.bo.ewm.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Staff {
    private Integer oid;
    private String name;
    private Integer age;
    private String sex;
    private String department;//部门 数据字典
    private String zhicheng;//职称 数据字典
    private String phone;//手机
    private String email;//邮箱
    private String username;
    private String password;
    private String image;//头像图片路径
    private Site site;//所属工地 多对一
    private Set<MaintainGroup> maintainGroups = new HashSet<>(); // 所属维护组 多对多
    private Integer maintainGroupNumber;
    private Set<Equipment> equipments = new HashSet<>(); // 所维护设备 多对多
    private Integer equipmentNumber;
    private Set<Record> records = new HashSet<>(); // 维护记录 一对多
    private Integer recordNumber;

    public Integer getMaintainGroupNumber() {
        return maintainGroups.size();
    }

    public Integer getEquipmentNumber() {
        Integer number = 0;
        for (MaintainGroup mg:maintainGroups) {
            number+= mg.getEquipments().size();

        }
//        number+=equipments.size();
        return  number;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getZhicheng() {
        return zhicheng;
    }

    public void setZhicheng(String zhicheng) {
        this.zhicheng = zhicheng;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Set<MaintainGroup> getMaintainGroups() {
        return maintainGroups;
    }

    public void setMaintainGroups(Set<MaintainGroup> maintainGroups) {
        this.maintainGroups = maintainGroups;
    }

    public Set<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(Set<Equipment> equipments) {
        this.equipments = equipments;
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
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(oid, staff.oid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(oid);
    }
}
