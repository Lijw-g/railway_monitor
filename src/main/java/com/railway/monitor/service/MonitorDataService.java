package com.railway.monitor.service;

import com.railway.monitor.model.MonitorData;
import org.springframework.stereotype.Service;

/**
 * @program: railway-monitor
 * @description: 监控数据服务
 * @author: lijiwen
 * @create: 2019-10-19 22:04
 **/
@Service
public class MonitorDataService extends AbstractService {

    public int createData(MonitorData monitorData) {
        return sqlSession.insert("monitorData.insert", monitorData);
    }
}
