package cn.bo.ewm.web.action;

import cn.bo.ewm.entity.*;
import cn.bo.ewm.service.IEquipmentService;
import cn.bo.ewm.service.IRecordService;
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
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@Scope("prototype")
public class RecordAction extends BaseAction<Record> {

    public void list() throws Exception {
        recordService.pageQuery(pageBean);
        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "equipments", "staffs", "records"});
        return;
    }

    public void add() throws Exception {
        // 获取登录用户
        Staff loginUser = (Staff) ServletActionContext.getRequest().getSession().getAttribute("loginUser");
        Staff staff = staffService.findById(loginUser.getOid());// 获取数据库最新信息

        // 获取被维护设备
        Equipment equipment = equipmentService.findById(model.getEquipment().getOid());

        Record record = new Record();
        record.setStaff(staff);
        record.setEquipment(equipment);
        record.setDate(new Date());
        record.setInfo(model.getInfo());
        recordService.save(record);
        printFlag(1);
    }

    public void update() throws Exception {
        Record record = recordService.findById(model.getOid());
        recordService.update(record);
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(1);
    }

    public void delete() throws Exception {
        recordService.deleteBatch(ids);
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(1);
    }

    /**
     * 展示oid对应记录的数据
     */
    public String phone_home() throws Exception {
        Record record = recordService.findById(model.getOid());
        ActionContext.getContext().getValueStack().push(record);
        return "phone_home_success";
    }

    // 手机端提交维护数据
    public void phone_weihu() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        // 获取登录用户
        Staff loginUser = (Staff) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            printFlag(2);//1-成功，2-未登录
            return;
        }
        Staff staff = staffService.findById(loginUser.getOid());// 获取数据库最新信息

        // 获取被维护设备
        Equipment equipment = equipmentService.findById(model.getEquipment().getOid());
        Record record = new Record();
        record.setStaff(staff);
        record.setEquipment(equipment);
        record.setDate(new Date());
        record.setInfo(model.getInfo());
        Serializable rid = recordService.save(record);

        // 获取模板，根据模板项的名称从request请求参数中取数据
        String sql = "select t.filedName,t.filedType from e_muban t where t.name='" + equipment.getMubanName() + "'";
        List<Object[]> names = mubanService.sql(sql);

        for (Object[] objArr : names) {
            // 处理复选框
            if (StringUtils.isNotBlank(objArr[1].toString()) && "复选框".equals(objArr[1].toString())) {
                //g[g1]:on
                //g[g2]:on
                //sys_weihuItem_rid:g=g1|g2|&
                StringBuilder sb = new StringBuilder(objArr[0].toString());
                sb.append("|");
                // 遍历请求参数key，找到被选中项
                Enumeration enumeration = request.getParameterNames();
                Pattern p = Pattern.compile("^" + objArr[0] + "\\[(.+?)\\]$");
                while (enumeration.hasMoreElements()) {
                    Object key = enumeration.nextElement();
                    Matcher m = p.matcher(key.toString());
                    if (m.find()) {
                        // 获取到g1
                        // 获取到g2
                        sb.append(m.group(1) + "|");
                    }
                }
                // 已|&结尾表示为复选框
                String value = sb.append("&").toString();

                Dictionaries dictionaries = new Dictionaries();
                dictionaries.setType("sys_weihuItem_" + rid);
                dictionaries.setValue(value);
                dictionariesService.save(dictionaries);
            } else {
                String key = objArr[0].toString();
                Dictionaries dictionaries = new Dictionaries();
                dictionaries.setType("sys_weihuItem_" + rid);
                if ("文本域".equals(objArr[1].toString())) {
                    //sys_weihuItem_rid:a=a|&area
                    dictionaries.setValue(key + "|" + request.getParameter(key) + "|&area");
                } else {
                    //sys_weihuItem_rid:a=a
                    dictionaries.setValue(key + "|" + request.getParameter(key));
                }
                dictionariesService.save(dictionaries);
            }
        }
        printFlag(1);
    }

    public void xiangqing() throws Exception {
        Record record = recordService.findById(model.getOid());
        // 用String[3] + List 存储
        // [[属性名,属性值,类型],[属性名,属性值,类型]]
        // 类型 1-普通 2-文本域 3-复选框

        // Map储存 属性名=属性值
        Map data = new HashMap();

        // 从数据字典查询该维护记录对应的模板项数据
        List<String> list = dictionariesService.hql("select t.value from Dictionaries t where t.type='sys_weihuItem_" + record.getOid() + "'");
        for (String item : list) {
            // 判断是否为复选框数据
            String[] split = null;
            if (item.endsWith("|&")) {
                // 复选框类型
                split = item.substring(0, item.length() - 2).split("\\|");
                String value = "";
                for (int i=1;i<split.length;i++) {
                    value=value+split[i]+",";
                }
                data.put(split[0],value.substring(0,value.length()-1));
            } else if (item.endsWith("|&area")) {
                split = item.substring(0, item.length() - 6).split("\\|");
                data.put(split[0],split[1]);
            } else {
                // 普通类型
                split = item.split("\\|");
                data.put(split[0],split[1]);
            }

        }
        java2Json(data,null);
    }
    // 维护信息详情，使用模板展示
    public String phone_xiangqing() throws Exception {
        Record record = recordService.findById(model.getOid());
        // 用String[3] + List 存储
        // [[属性名,属性值,类型],[属性名,属性值,类型]]
        // 类型 1-普通 2-文本域 3-复选框

        // Map储存 属性名=属性值
        Map data = new HashMap();

        // 从数据字典查询该维护记录对应的模板项数据
        List<String> list = dictionariesService.hql("select t.value from Dictionaries t where t.type='sys_weihuItem_" + record.getOid() + "'");
        for (String item : list) {
            // 判断是否为复选框数据
            String[] split = null;
            if (item.endsWith("|&")) {
                // 复选框类型
                 split = item.substring(0, item.length() - 2).split("\\|");
                String value = "";
                for (int i=1;i<split.length;i++) {
                    value=value+split[i]+",";
                }
                data.put(split[0],value.substring(0,value.length()-1));
            } else if (item.endsWith("|&area")) {
                split = item.substring(0, item.length() - 6).split("\\|");
                data.put(split[0],split[1]);
            } else {
                // 普通类型
                split = item.split("\\|");
                data.put(split[0],split[1]);
            }

        }
        ServletActionContext.getRequest().setAttribute("data",data);

        return "phone_xiangqing_success";
    }

    // 接收搜索参数
    private String search_staffData;
    private String search_equipmentData;
    private String search_time_begin;
    private String search_time_end;
    private String search_info;

    public void setSearch_staffData(String search_staffData) {
        this.search_staffData = search_staffData;
    }

    public void setSearch_equipmentData(String search_equipmentData) {
        this.search_equipmentData = search_equipmentData;
    }

    public void setSearch_info(String search_info) {
        this.search_info = search_info;
    }

    public void setSearch_time_begin(String search_time_begin) {
        this.search_time_begin = search_time_begin;
    }

    public void setSearch_time_end(String search_time_end) {
        this.search_time_end = search_time_end;
    }

    public void search() throws Exception {
        // TODO 时间只能单独搜
        StringBuilder sb = new StringBuilder("from Record t where 1=1 ");

        if (StringUtils.isNoneBlank(search_staffData)) {
            sb.append(" and ( t.staff.name like '%" + search_staffData + "%' or t.staff.username like '%" + search_staffData + "%' or t.staff.phone like '%" + search_staffData + "%') ");
        }
        if (StringUtils.isNoneBlank(search_equipmentData)) {
            sb.append(" and t.equipment.name like '%" + search_equipmentData + "%' ");
        }

        if (StringUtils.isNoneBlank(search_time_begin)) {
            sb.append(" and t.date > '" + search_time_begin + "'");
        }
        if (StringUtils.isNoneBlank(search_time_end)) {
            sb.append(" and t.date < '" + search_time_end + "'");
        }
        if (StringUtils.isNoneBlank(search_info)) {
            sb.append(" and t.info like '%" + search_info + "%' ");
        }
        List list = recordService.hql(sb.toString());
        pageBean.setCount(list.size());
        int page = pageBean.getPage();
        int limit = pageBean.getLimit();
        pageBean.setData(list.subList((page - 1) * limit, page * limit > list.size() ? list.size() : page * limit));

        this.java2Json(pageBean, new String[]{"page", "limit", "detachedCriteria", "equipments", "staffs", "records"});
    }



    private Long benginDateTime;
    private Integer excursionDayNumber;
    public void setBenginDateTime(Long benginDateTime) {
        this.benginDateTime = benginDateTime;
    }
    public void setExcursionDayNumber(Integer excursionDayNumber) {
        this.excursionDayNumber = excursionDayNumber;
    }

    // 统计
    public void tongji() throws Exception {
        Date benginDate = new Date(benginDateTime);//2019-05-06 16:26:12
        benginDate.setHours(23);
        benginDate.setMinutes(59);
        benginDate.setSeconds(59); // 2019-05-06 23:59:59
        Date excursionDate = new Date(benginDate.getTime() + (1000*60*60*24*-excursionDayNumber) + 1000); // 2019-04-29 23:59:59  +1s=> 2019-04-30 00:00:00
        System.out.println(benginDate.toLocaleString());
        System.out.println(excursionDate.toLocaleString());

        // 获取所有日期 年-月-日
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> dateAndNumber = new HashMap<>();
        List<String> dateList = new ArrayList<>();
        for (int i=0; i<excursionDayNumber; i++) {
            Date date = new Date(benginDate.getTime() - (1000 * 60 * 60 * 24 * i));
            String nyr = sdf2.format(date);
            dateAndNumber.put(nyr,"0");
            dateList.add(nyr);
        }
        Collections.reverse(dateList);//反转，日期由前往后

        Map<String,String[]> rMap = new HashMap<>();//返回的数据map{ staffid:[第1天数量,第2天数量 ...] ...}
        for(String id : ids.split(",")) {
            StringBuilder sql = new StringBuilder("SELECT DATE_FORMAT(t.date, '%Y-%m-%d') d, count(*) FROM e_record t WHERE t.staff_id="+id+" GROUP BY d");
            List<Object[]> list = recordService.sql(sql.toString()); // 2019-05-06 1

            HashMap<String, String> clone = (HashMap<String, String>) ((HashMap<String, String>) dateAndNumber).clone();
            for (Object[] ss : list) {
                clone.put(ss[0].toString(),ss[1].toString());
            }

            String[] rss = new String[excursionDayNumber];
            for(int i=0; i<dateList.size(); i++) {
                rss[i] = clone.get(dateList.get(i));
            }

            rMap.put(id,rss);
        }


        /* 返回数据格式
            {
                1 : {
                        2019-05-05 : 2
                        2019-05-06 : 1
                    }
                2 : {
                        2019-05-04 : 1
                        2019-05-05 : 2
                    }
            }

        */
        java2Json(rMap,null);
    }
}
