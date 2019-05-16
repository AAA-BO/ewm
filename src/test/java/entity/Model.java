package entity;

import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.Staff;

import java.util.HashSet;
import java.util.Set;

public class Model {
    private int oid;
    private String name;
    private Integer age;
    private Staff staff;//一对多
    private Set<Equipment> staffs = new HashSet<>();//多对一
    private Set<Equipment> equipments = new HashSet<>();//多对多

}
