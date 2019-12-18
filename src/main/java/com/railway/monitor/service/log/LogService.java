package com.railway.monitor.service.log;

import com.railway.monitor.common.query.GenericQuery;
import com.railway.monitor.service.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService extends AbstractService {

    public int createLog(Log log) {
        return sqlSession.insert("log.insert", log);
    }

    public List<Log> selectLog(LogType type, int oid) {
        return sqlSession.selectList("log.select", new GenericQuery().fill("type", type).fill("oid", oid));
    }

    public int selectCount(LogType type, int oid) {
        return sqlSession.selectOne("log.selectCount", new GenericQuery().fill("type", type).fill("oid", oid));
    }
}
