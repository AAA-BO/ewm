package cn.bo.ewm.entity;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Staff {
    private Integer oid;
    private String name;
    private Integer sex;
    private String department;//部门
    private String zhicheng;//职称
    private String phone;//手机
    private String email;//邮箱
    private String username;
    private String password;
    private String image;//头像

    private Set<Equipment> equipments = new HashSet<>();
    private Set<Record> records = new HashSet<>();

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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
/*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        Staff staff = (Staff) o;
        return Objects.equals(getOid(), staff.getOid()) &&
                Objects.equals(getName(), staff.getName()) &&
                Objects.equals(getUsername(), staff.getUsername()) &&
                Objects.equals(getPassword(), staff.getPassword()) &&
                Objects.equals(getEquipments(), staff.getEquipments()) &&
                Objects.equals(getRecords(), staff.getRecords());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getOid(), getName(), getUsername(), getPassword(), getEquipments(), getRecords());
    }*/
}
