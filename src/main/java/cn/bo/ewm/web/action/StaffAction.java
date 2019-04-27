package cn.bo.ewm.web.action;

import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.Record;
import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.IEquipmentService;
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
import java.util.*;

@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
    @Autowired
    private IStaffService staffService;
    @Autowired
    private IEquipmentService equipmentService;

    public void list() throws Exception {
        staffService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "equipments", "records"});
        return;
    }

    public void add() throws Exception {
        staffService.save(model);
        printFlag(1);
    }

    public void update() throws Exception {
        Staff staff = staffService.findById(model.getOid());
        staff.setName(model.getName());// 将要更新的属性重设
        staff.setUsername(model.getUsername());// 将要更新的属性重设
        staff.setPassword(model.getPassword());// 将要更新的属性重设

        staffService.update(staff);
        printFlag(1);
    }


    private String ids;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
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
    public void showEquipment() throws Exception {
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
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "staffs", "records"});
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
        pageBean.setCount(null==equipments ? 0 : equipments.size());
        pageBean.setData(null==equipments ? null : equipments);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "staffs", "records"});
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
        request.getSession().setAttribute("lastOid",model.getOid());
        return "phoneLogin";
    }

    public String login() throws Exception {
        Staff staff = staffService.findByUsername(model.getUsername());
        if (staff != null && StringUtils.isNotBlank(staff.getPassword()) && StringUtils.isNotBlank(model.getPassword())) {
            if (staff.getPassword().equals(model.getPassword())) {
                ServletActionContext.getRequest().getSession().setAttribute("loginUser", staff);
                if(isPhone){
                    return "phoneLoginSUCCESS";
                }
                return SUCCESS;
            }
        }

        addActionError("用户名或密码错误");

        if(isPhone){
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
        ServletActionContext.getRequest().setAttribute("equipments",equipments);
        return "phone_elist_Success";
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
        ServletActionContext.getRequest().setAttribute("records",records);
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
