package cn.bo.ewm.service.base;

import cn.bo.ewm.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    protected IEquipmentDao equipmentDao;
    @Autowired
    protected IStaffDao staffDao;
    @Autowired
    protected IRecordDao recordDao;
    @Autowired
    protected ISiteDao siteDao;
    @Autowired
    protected IDictionariesDao dictionariesDao;
    @Autowired
    protected IMubanDao mubanDao;
    @Autowired
    protected IMaintainGroupDao maintainGroupDao;

}
