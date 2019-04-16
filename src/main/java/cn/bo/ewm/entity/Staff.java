package cn.bo.ewm.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Staff {
    private Integer oid;
    private String name;
    private String username;
    private String password;
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
