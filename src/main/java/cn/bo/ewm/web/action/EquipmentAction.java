package cn.bo.ewm.web.action;

import cn.bo.ewm.dao.base.impl.BaseDaoImpl;
import cn.bo.ewm.entity.Equipment;
import cn.bo.ewm.entity.MaintainGroup;
import cn.bo.ewm.entity.Record;
import cn.bo.ewm.entity.Staff;
import cn.bo.ewm.service.IEquipmentService;
import cn.bo.ewm.service.ISiteService;
import cn.bo.ewm.service.IStaffService;
import cn.bo.ewm.web.action.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@Scope("prototype")
public class EquipmentAction extends BaseAction<Equipment> {
    public void getAll() throws Exception {
        List<Equipment> equipments =  equipmentService.findAll();
        pageBean.setCount(equipments.size());
        pageBean.setData(equipments);
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria", "records", "staffs","equipments" });
    }

    public void list() throws Exception {
        equipmentService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria", "records", "staffs","equipments" });
        return;

    }

    public void add() throws Exception {
        equipmentService.save(model);
        printFlag(1);
    }

    public void update() throws Exception {
        Equipment equipment = equipmentService.findById(model.getOid());
        equipment.setName(model.getName());// 将要更新的属性重设
        // 设置Site
        if (model.getSite() != null && model.getSite().getOid() != null) {
            equipment.setSite(siteService.findById(model.getSite().getOid()));
        } else {
            equipment.setSite(null);
        }
        equipmentService.update(equipment);
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(1);
    }


    public void delete() throws Exception {
        equipmentService.deleteBatch(ids);
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(1);
    }

    /**
     * 查看当前设备所归属的员工
     */
    // 旧版 查询直接管理人员
   /* public void showStaff() throws Exception {
        // TODO:需改造
        Equipment equipment = equipmentService.findById(model.getOid());
        List<Staff> staffs = new ArrayList<>(equipment.getStaffs());

        // 使用oid排序
        staffs.sort(new Comparator<Staff>() {
            public int compare(Staff o1, Staff o2) {
                if(o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if(o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        pageBean.setCount(staffs.size());
        int page = pageBean.getPage();
        int limit = pageBean.getLimit();
        pageBean.setData(staffs.subList((page-1)*limit, page*limit>staffs.size()?staffs.size():page*limit));
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria","equipments","records","staffs"});
        return;
    }*/
   // 查询所属维护组的管理人员
    public void showStaff() throws Exception {
        // TODO:需改造
        Equipment equipment = equipmentService.findById(model.getOid());
        List<Staff> staffs = new ArrayList<>();
        for (MaintainGroup  mg : equipment.getMaintainGroups()) {
            staffs.addAll(mg.getStaffs());
        }

        // 使用oid排序
        staffs.sort(new Comparator<Staff>() {
            public int compare(Staff o1, Staff o2) {
                if(o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if(o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        pageBean.setCount(staffs.size());
        int page = pageBean.getPage();
        int limit = pageBean.getLimit();
        pageBean.setData(staffs.subList((page-1)*limit, page*limit>staffs.size()?staffs.size():page*limit));
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria","equipments","records","staffs"});
        return;
    }


    // 设置模板
    public void useMuban() throws Exception {
        Equipment equipment = equipmentService.findById(model.getOid());
        equipment.setMubanName(model.getMubanName());
        equipmentService.update(equipment);
        printFlag(1);
    }

    // 查看制定模板所关联设备
    public void guanlianshebei() throws Exception {
        // TODO 编码问题
        DetachedCriteria dc = pageBean.getDetachedCriteria();
        dc.add(Restrictions.eq("mubanName",model.getMubanName()));
        equipmentService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria","equipments","records","staffs"});
    }



    /**
     * 查看指定设备的所有维护记录
     * @throws Exception
     */
    public void showRecord_phone() throws Exception {
        showRecord();//跳过登陆拦截

    }
    public void showRecord() throws Exception {
        // TODO:需改造
        Equipment equipment = equipmentService.findById(model.getOid());
        List<Record> records = new ArrayList<>(equipment.getRecords());

        // 使用oid排序
        records.sort(new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                if(o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if(o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        if(pageBean.getLimit() == 0) {
            pageBean.setData(records);
        }else{
            pageBean.setCount(records.size());
            int page = pageBean.getPage();
            int limit = pageBean.getLimit();
            pageBean.setData(records.subList((page-1)*limit, page*limit>records.size()?records.size():page*limit));
        }

        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria","equipments","staffs","records"});
        return;
    }

    /**
     * 展示扫描二维码页面
     * @throws Exception
     */
    public String showQrcode() throws Exception {
        Equipment equipment = equipmentService.findById(model.getOid());
        ServletActionContext.getContext().getValueStack().push(equipment);
        return "qrcordInfo";
    }

    /**
     * 是否有维护此设备的权限
     */
    public void maintenanceAuthority() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        // 获取登录用户
        Object loginUser =  ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if(loginUser == null) {
            printFlag(3);//0-无，1-有，3-未登录
            return;
        }

        Staff staff = staffService.findById(((Staff)loginUser).getOid());// 获取数据库最新信息

        // 获取设备
        Equipment equipment = equipmentService.findById(model.getOid());

        // 判断是否有权限进行维护
        Set<Equipment> equipments = staff.getEquipments();
        for (MaintainGroup mg :staff.getMaintainGroups()) {
            equipments.addAll(mg.getEquipments());
        }
        boolean containsFlag = staff.getEquipments().contains(equipment);
        if(!containsFlag) {
            printFlag(0);//0-无，1-有，3-未登录
            return;
        }

        printFlag(1);//0-无，1-有，3-未登录

    }

    /**
     * 我的维护记录
     */
    public void myRecord() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        // 获取登录用户
        Object loginUser =  ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        if(loginUser == null) {
            printFlag(3);//0-无，1-有，3-未登录
            return;
        }

        Staff staff = staffService.findById(((Staff)loginUser).getOid());// 获取数据库最新信息

        Integer eid = model.getOid();//设备id

        List<Record> records = new ArrayList<>(staff.getRecords());
        // 过滤其他设备de维护信息
        for (Record record:records) {
            if(record.getEquipment().getOid() != eid) {
                records.remove(record);
            }
        }

        // 使用oid排序
        records.sort(new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                if(o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if(o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
        pageBean.setCount(records.size());
        pageBean.setData(records);
        this.java2Json(pageBean, new String[]{"page","limit","detachedCriteria","equipments","staffs","records"});


    }

    public String phone_home() throws Exception {
        Equipment equipment = equipmentService.findById(model.getOid());
        int number = equipment.getStaffs().size();
        ActionContext.getContext().getValueStack().push(equipment);
        ServletActionContext.getRequest().setAttribute("number",number);
        return "phone_home_success";
    }

    // 所有维护人员
    public String phone_slist() throws Exception {
        // 直接管理人员
        Equipment equipment = equipmentService.findById(model.getOid());
        List<Staff> staffs = new ArrayList<>(equipment.getStaffs());

        // 使用oid排序
        staffs.sort(new Comparator<Staff>() {
            public int compare(Staff o1, Staff o2) {
                if(o1.getOid() == o2.getOid()) {
                    return 0;
                }
                if(o1.getOid() > o2.getOid()) {
                    return 1;
                }
                return -1;
            }
        });
//        ServletActionContext.getRequest().setAttribute("staffs",staffs);

        // 维护组人员
        ServletActionContext.getRequest().setAttribute("maintainGroups", equipment.getMaintainGroups());

        return "phone_slist_success";
    }

    // 所有维护组
    public String phone_mlist() throws Exception {
        Equipment equipment = equipmentService.findById(model.getOid());
        ServletActionContext.getRequest().setAttribute("maintainGroups", equipment.getMaintainGroups());
        return "phone_mlist_Success";
    }

    // 所有维护记录
    public String phone_rlist() throws Exception {
        Equipment equipment = equipmentService.findById(model.getOid());
        List<Record> records = new ArrayList<>(equipment.getRecords());

        // 使用oid排序
        records.sort(new Comparator<Record>() {
            public int compare(Record o1, Record o2) {
                if(o1.getDate().getTime() == o2.getDate().getTime()) {
                    return 0;
                }
                if(o1.getDate().getTime() < o2.getDate().getTime()) {
                    return 1;
                }
                return -1;
            }
        });
        ServletActionContext.getRequest().setAttribute("records",records);
        return "phone_rlist_success";
    }

    // 自己的维护记录
    public String phone_myrlist() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        // 获取登录用户
        Object loginUser =  ServletActionContext.getRequest().getSession().getAttribute("loginUser");

        Staff staff = staffService.findById(((Staff)loginUser).getOid());// 获取数据库最新信息

        Integer eid = model.getOid();//设备id

        List<Record> records = new ArrayList<>(staff.getRecords());
        // 过滤其他设备de维护信息
        Iterator<Record> iterator = records.iterator();
        while (iterator.hasNext()) {
            Record record = iterator.next();
            if(record.getEquipment().getOid() != eid) {
                iterator.remove();
            }
        }

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

        return "phone_myrlist_success";
    }

    public void phone_myrlist_verification() throws Exception {
        maintenanceAuthority();
    }

    // 准备维护用的模板信息
    public String phone_weihu() throws Exception {
        Equipment equipment = equipmentService.findById(model.getOid());
        String mubanName = equipment.getMubanName();
        if(StringUtils.isNotBlank(mubanName)) {
            // 使用了模板
            List mubanLlist = mubanService.hql("from Muban t where t.name='" + mubanName + "'");
            ServletActionContext.getRequest().setAttribute("mubanLlist",mubanLlist);
        }
        return "phone_weihu_success";
    }



}
