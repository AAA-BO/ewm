package cn.bo.ewm.web.action;

import cn.bo.ewm.entity.*;
import cn.bo.ewm.web.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@Scope("prototype")
public class MaintainGroupAction extends BaseAction<MaintainGroup> {

    public void list() throws Exception {
        maintainGroupService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "equipments", "records", "staffs"});
    }

    public void staff() throws Exception {
        MaintainGroup maintainGroup = maintainGroupService.findById(model.getOid());
        Set<Staff> staffs = maintainGroup.getStaffs();
        pageBean.setCount(staffs.size());
        pageBean.setData(new ArrayList(staffs));
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "equipments", "records", "staffs"});
    }

    public void equipment() throws Exception {
        MaintainGroup maintainGroup = maintainGroupService.findById(model.getOid());
        Set<Equipment> equipment = maintainGroup.getEquipments();
        pageBean.setCount(equipment.size());
        pageBean.setData(new ArrayList(equipment));
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "equipments", "records", "staffs"});
    }


    public void add() throws Exception {
        maintainGroupService.save(model);
        printFlag(1);
    }

    public void update() throws Exception {
        MaintainGroup maintainGroup = maintainGroupService.findById(model.getOid());
        maintainGroup.setName(model.getName());
        maintainGroup.setInfo(model.getInfo());
        maintainGroupService.update(maintainGroup);
        printFlag(1);
    }

    public void delete() throws Exception {
        maintainGroupService.deleteBatch(ids);
        printFlag(1);
    }

    private String maintainGroupIds;
    private String staffIds;
    private String equipmentIds;

    public void setMaintainGroupIds(String maintainGroupIds) {
        this.maintainGroupIds = maintainGroupIds;
    }

    public void setStaffIds(String staffIds) {
        this.staffIds = staffIds;
    }

    public void setEquipmentIds(String equipmentIds) {
        this.equipmentIds = equipmentIds;
    }


    public void addStaff() throws Exception {
        List<Staff> staffList = staffService.findByIds(staffIds);
        String[] maintainGroupIdArray = this.maintainGroupIds.split(",");
        for (String maintainGroupId : maintainGroupIdArray) {
            MaintainGroup maintainGroup = maintainGroupService.findById(Integer.valueOf(maintainGroupId));
            maintainGroup.getStaffs().addAll(staffList);
            maintainGroupService.update(maintainGroup);
        }
        printFlag(1);
    }

    public void addEquipment() throws Exception {
        List<Equipment> equipmentList = equipmentService.findByIds(equipmentIds);
        String[] maintainGroupIdArray = this.maintainGroupIds.split(",");
        for (String maintainGroupId : maintainGroupIdArray) {
            MaintainGroup maintainGroup = maintainGroupService.findById(Integer.valueOf(maintainGroupId));
            maintainGroup.getEquipments().addAll(equipmentList);
            maintainGroupService.update(maintainGroup);
        }
        printFlag(1);
    }

    public void remveStaff() throws Exception {
        List<Staff> staffList = staffService.findByIds(staffIds);
        MaintainGroup maintainGroup = maintainGroupService.findById(model.getOid());
        Iterator<Staff> iterator = maintainGroup.getStaffs().iterator();
        while (iterator.hasNext()) {
            Staff staff = iterator.next();
            if(staffList.contains(staff)) {
                iterator.remove();
            }
        }
        maintainGroupService.update(maintainGroup);
        printFlag(1);
    }

    public void remveEquipment() throws Exception {
        List<Equipment> equipmentList = equipmentService.findByIds(equipmentIds);
        MaintainGroup maintainGroup = maintainGroupService.findById(model.getOid());
        Iterator<Equipment> iterator = maintainGroup.getEquipments().iterator();
        while (iterator.hasNext()) {
            Equipment equipment = iterator.next();
            if(equipmentList.contains(equipment)) {
                iterator.remove();
            }
        }
        maintainGroupService.update(maintainGroup);
        printFlag(1);
    }

    // 手机页面：维护组首页
    public String phone_home() throws Exception {
        MaintainGroup maintainGroup = maintainGroupService.findById(model.getOid());
        ActionContext.getContext().getValueStack().push(maintainGroup);
        return "phone_home_Success";
    }

    // 手机页面：当前登录用户申请加入维护组
    public void phone_join() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        // 获取登录用户
        Object loginUser =  ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if(loginUser == null) {
            printFlag(2);//0-已经申请过，1-申请成功，2-未登录,3-已加入
            return;
        }
        // 是否已加入
        Staff staff = staffService.findById(((Staff) loginUser).getOid());
        Iterator<MaintainGroup> iterator = staff.getMaintainGroups().iterator();
        while (iterator.hasNext()) {
            MaintainGroup mg = iterator.next();
            if(mg.getOid() == model.getOid()) {
                printFlag(3);//3-已加入
                return;
            }

        }


        MaintainGroup maintainGroup = maintainGroupService.findById(model.getOid());
        String value = staff.getOid()+","+maintainGroup.getOid();

        List list = dictionariesService.hql("from Dictionaries t where t.value like '"+value+",%'");
        if (list.size()>0) {
            printFlag(0);//0-已经申请过，1-申请成功，2-未登录,3-已加入
            return;
        }

        // 将申请数据加入数据字典表 sys_mg_join:staff.oid|mg.oid\
        Dictionaries dictionaries = new Dictionaries();
        dictionaries.setType("sys_mg_join");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        value = value + "," + sf.format(new Date().getTime());
        dictionaries.setValue(value);
        dictionariesService.save(dictionaries);
        printFlag(1);//1-申请成功
    }

    private String say;

    public void setSay(String say) {
        this.say = say;
    }

    // 同意申请 或 拒绝申请
    public void join() throws Exception {
        if(StringUtils.isNotBlank(say)) {
            Dictionaries dictionaries = dictionariesService.findById(model.getOid());
            if("yes".equals(say)) {
                String[] split = dictionaries.getValue().split(",");
                Staff staff = staffService.findById(Integer.valueOf(split[0]));
                MaintainGroup maintainGroup = maintainGroupService.findById(Integer.valueOf(split[1]));
                maintainGroup.getStaffs().add(staff);
                maintainGroupService.save(maintainGroup);
                dictionariesService.deleteBatch(dictionaries.getOid().toString());
                printFlag(1);
            }else if("no".equals(say)) {
                dictionariesService.deleteBatch(dictionaries.getOid().toString());
                printFlag(1);
            }
        }
    }

    public String phone_slist() throws Exception {
        MaintainGroup mg = maintainGroupService.findById(model.getOid());
        List<Staff> staffs = new ArrayList<>(mg.getStaffs());

        // 使用oid排序
        staffs.sort(new Comparator<Staff>() {
            public int compare(Staff o1, Staff o2) {
                if (o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if (o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        // 维护组人员
        ServletActionContext.getRequest().setAttribute("staffs", staffs);
        return "phone_slist_success";
    }

    public String phone_elist() throws Exception {
        MaintainGroup mg = maintainGroupService.findById(model.getOid());
        List<Equipment> equipments = new ArrayList<>(mg.getEquipments());

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
        // 维护组人员
        ServletActionContext.getRequest().setAttribute("equipments", equipments);
        return "phone_elist_success";
    }
}
