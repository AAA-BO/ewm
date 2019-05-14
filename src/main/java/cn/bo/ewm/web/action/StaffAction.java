package cn.bo.ewm.web.action;

import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.MaintainGroup;
import cn.bo.ewm.entity.Record;
import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.IEquipmentService;
import cn.bo.ewm.service.ISiteService;
import cn.bo.ewm.service.IStaffService;
import cn.bo.ewm.web.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.*;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {

    public void list() throws Exception {
        staffService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "equipments", "records", "staffs"});
    }

    public void getAll() throws Exception {
        List<Staff> all = staffService.findAll();
        pageBean.setCount(all.size());
        pageBean.setData(all);
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria", "records", "staffs","equipments" });
    }

    private String getZhicheng() {
        Enumeration e = ServletActionContext.getRequest().getParameterNames();
        StringBuilder sb = new StringBuilder();
        while (e.hasMoreElements()) {
            Object o = e.nextElement();
            String s = o.toString();
            if (s.startsWith("zhicheng")) {
                sb.append(s.split("_")[1] + ",");
            }
        }
        if (sb.length() > 0) {
            return sb.deleteCharAt(sb.length() - 1).toString();
        } else {
            return null;
        }
    }

    public void add() throws Exception {
        // 对username的存在性进行校验
        if (staffService.usernameExist(model.getUsername())) {
            printFlag(2);
            return;
        }
        // 解析工地
        // 对象要先get，不能直接传oid，hibernate无法解析。没有对象引用时传null。不要传空数据的Object
        if (model.getSite() != null && model.getSite().getOid() != null) {
            model.setSite(siteService.findById(model.getSite().getOid()));
        } else {
            model.setSite(null);
        }
        // 解析职称
        model.setZhicheng(getZhicheng());
        staffService.save(model);
        printFlag(1);
    }

    /**
     * 检测账户username是否已存在，用与add或upadte操作时的验证
     *
     * @return 0-不存在，1-存在
     */
    public void usernameExist() throws Exception {
        Boolean exist = staffService.usernameExist(model.getUsername());
        if (exist) {
            printFlag(1);
        } else {
            printFlag(0);
        }
    }

    public void update() throws Exception {
        Staff staff = staffService.findById(model.getOid());
        // 先判断账户知否更改
        // 没更改肯定存在，就是原账户
        if (!staff.getUsername().equals(model.getUsername())) {
            if (staffService.usernameExist(model.getUsername())) {
                printFlag(2);
                return;
            }
        }

        staff.setName(model.getName());// 将要更新的属性重设
        staff.setUsername(model.getUsername());// 将要更新的属性重设
        staff.setPassword(model.getPassword());// 将要更新的属性重设
        staff.setSex(model.getSex());// 将要更新的属性重设
        staff.setAge(model.getAge());// 将要更新的属性重设
        staff.setDepartment(model.getDepartment());// 将要更新的属性重设
        staff.setPhone(model.getPhone());// 将要更新的属性重设
        staff.setEmail(model.getEmail());// 将要更新的属性重设
        // 设置Site，不级联保存，只是关联！对象要先get，不能直接传oid，hibernate无法解析。没有对象引用时传null。不要传空数据的Object
        if (model.getSite() != null && model.getSite().getOid() != null) {
            staff.setSite(siteService.findById(model.getSite().getOid()));
        } else {
            staff.setSite(null);
        }
        // 解析职称复选框，并设入
        staff.setZhicheng(getZhicheng());

        staffService.update(staff);
        printFlag(1);
    }

    public void delete() throws Exception {
        staffService.deleteBatch(ids);
        printFlag(1);
    }

    /**
     * 查看当前员工所管理的设备，传过来staff id没查询其设备集合
     *
     * @throws Exception
     */
    // 旧版：查询直接维护设备
    /*public void showEquipment() throws Exception {
        // TODO:需改造
        Staff staff = staffService.findById(model.getOid());
        List<Equipment> equipments = new ArrayList<>(staff.getEquipments());

        // 使用oid排序
        equipments.sort(new Comparator<Equipment>() {
            public int compare(Equipment o1, Equipment o2) {
                if (o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if (o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        pageBean.setCount(equipments.size());
        int page = pageBean.getPage();
        int limit = pageBean.getLimit();
        pageBean.setData(equipments.subList((page - 1) * limit, page * limit > equipments.size() ? equipments.size() : page * limit));
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "staffs", "records","equipments"});
        return;
    }*/
    // 查询所属维护组的设备
    public void showEquipment() throws Exception {
        // TODO:需改造
        Staff staff = staffService.findById(model.getOid());
        List<Equipment> equipments = new ArrayList<>();
        for (MaintainGroup  mg : staff.getMaintainGroups()) {
            equipments.addAll(mg.getEquipments());
        }

        // 使用oid排序
        equipments.sort(new Comparator<Equipment>() {
            public int compare(Equipment o1, Equipment o2) {
                if (o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if (o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        pageBean.setCount(equipments.size());
        int page = pageBean.getPage();
        int limit = pageBean.getLimit();
        pageBean.setData(equipments.subList((page - 1) * limit, page * limit > equipments.size() ? equipments.size() : page * limit));
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "staffs", "records","equipments"});
        return;
    }

    /**
     * 查看当前员工的维护记录
     *
     * @throws Exception
     */
    public void showRecord() throws Exception {
        // TODO:需改造
        Staff staff = staffService.findById(model.getOid());
        List<Record> records = new ArrayList<>(staff.getRecords());

        // 使用oid排序
        records.sort(new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                if (o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if (o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        pageBean.setCount(records.size());
        int page = pageBean.getPage();
        int limit = pageBean.getLimit();
        pageBean.setData(records.subList((page - 1) * limit, page * limit > records.size() ? records.size() : page * limit));
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "equipments", "staffs", "records"});
        return;
    }

    private String staffIds;
    private String equipmentIds;
    private Integer equipmentId;

    public String getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(String staffIds) {
        this.staffIds = staffIds;
    }

    public String getEquipmentIds() {
        return equipmentIds;
    }

    public void setEquipmentIds(String equipmentIds) {
        this.equipmentIds = equipmentIds;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    /**
     * 批量关联
     *
     * @throws Exception
     */
    public void batch() throws Exception {
        String[] staffIdArray = this.staffIds.split(",");


        List<Equipment> equipments = equipmentService.findByIds(equipmentIds);
        for (String staffId : staffIdArray) {
            Staff staff = staffService.findById(Integer.valueOf(staffId));
            staff.getEquipments().addAll(equipments);
            staffService.update(staff);
        }
        printFlag(1);
        return;
    }

    /**
     * 取消关联
     *
     * @throws Exception
     */
    public void cancel() throws Exception {
        Staff staff = staffService.findById(model.getOid());
        Equipment equipment = equipmentService.findById(equipmentId);
        staff.getEquipments().remove(equipment);
        staffService.update(staff);
        printFlag(1);
        return;
    }

    /**
     * 获取此员工未关联的设备
     */
    public void getNotRelevance() throws Exception {
        List<Equipment> equipments = equipmentService.getNotRelevance(model.getOid());
        pageBean.setCount(null == equipments ? 0 : equipments.size());
        pageBean.setData(null == equipments ? null : equipments);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "staffs", "records","equipments"});
        return;
    }

    /**
     * 展示扫描二维码页面
     *
     * @throws Exception
     */
    public String showQrcode() throws Exception {
        Staff staff = staffService.findById(model.getOid());
        ServletActionContext.getContext().getValueStack().push(staff);
        return "qrcordInfo";
    }

    private Boolean isPhone = false;

    public Boolean getIsPhone() {
        return isPhone;
    }

    public void setIsPhone(Boolean isPhone) {
        this.isPhone = isPhone;
    }


    public String phoneLoginPage() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("lastOid", model.getOid());
        return "phoneLogin";
    }

    public String login() throws Exception {
        Staff staff = staffService.findByUsername(model.getUsername());
        if (staff != null && StringUtils.isNotBlank(staff.getPassword()) && StringUtils.isNotBlank(model.getPassword())) {
            if (staff.getPassword().equals(model.getPassword())) {
                ServletActionContext.getRequest().getSession().setAttribute("loginUser", staff);
                if (isPhone) {
                    return "phoneLoginSUCCESS";
                }
                return SUCCESS;
            }
        }

        addActionError("用户名或密码错误");

        if (isPhone) {
            return "phoneLogin";
        }
        return LOGIN;
    }


    public String logout() throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        if (session != null) {
            session.invalidate();
        }

        return LOGIN;
    }

    /**
     * 查询该用户的所有维护设备
     */
    public String phone_elist() throws Exception {
        // 从员工直接关联设备查
        Staff staff = staffService.findById(model.getOid());
        List<Equipment> equipments = new ArrayList<>(staff.getEquipments());

        // 使用oid排序
        equipments.sort(new Comparator<Equipment>() {
            public int compare(Equipment o1, Equipment o2) {
                if (o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if (o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
//        ServletActionContext.getRequest().setAttribute("equipments", equipments);

        //获取维护组数据
        ServletActionContext.getRequest().setAttribute("maintainGroups", staff.getMaintainGroups());

        return "phone_elist_Success";
    }

    // 所有维护组
    public String phone_mlist() throws Exception {
        Staff staff = staffService.findById(model.getOid());
        ServletActionContext.getRequest().setAttribute("maintainGroups", staff.getMaintainGroups());
        return "phone_mlist_Success";
    }

    /**
     * 查询该用户的所有维护信息
     */
    public String phone_rlist() throws Exception {
        Staff staff = staffService.findById(model.getOid());
        List<Record> records = new ArrayList<>(staff.getRecords());

        // 使用oid排序
        records.sort(new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                if (o1.getDate().getTime() == o2.getDate().getTime()) {
                    return 0;
                }
                if (o1.getDate().getTime() < o2.getDate().getTime()) {
                    return 1;
                }
                return -1;
            }
        });
        ServletActionContext.getRequest().setAttribute("records", records);
        return "phone_rlist_Success";
    }

    /**
     * 扫员工码后
     */
    public String phone_showQrcode() throws Exception {
        Staff staff = staffService.findById(model.getOid());
        ActionContext.getContext().getValueStack().push(staff);
        return "phone_showQrcode_success";
    }


    public String phone_login() throws Exception {
        Staff staff = staffService.findByUsername(model.getUsername());
        if (staff != null && StringUtils.isNotBlank(staff.getPassword()) && StringUtils.isNotBlank(model.getPassword())) {
            if (staff.getPassword().equals(model.getPassword())) {
                ServletActionContext.getRequest().getSession().setAttribute("loginUser", staff);
                return "phone_login_success";
            }
        }

        addActionError("用户名或密码错误");

        return "phone_login_login";
    }

}
