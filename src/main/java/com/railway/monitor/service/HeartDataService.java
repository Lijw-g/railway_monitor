package com.railway.monitor.service;

import com.railway.monitor.model.HeartData;
import org.springframework.stereotype.Service;

/**
 * @program: railway-monitor
 * @description: 心跳数据
 * @author: lijiwen
 * @create: 2019-10-27 13:50
 **/
@Service
public class HeartDataService extends AbstractService {
    public int createData(HeartData heartData) {
        return sqlSession.insert("heartData.insert", heartData);
    }
}
