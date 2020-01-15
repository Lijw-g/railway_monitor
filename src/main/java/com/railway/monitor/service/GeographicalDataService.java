package com.railway.monitor.service;

import com.google.common.collect.Maps;
import com.railway.monitor.api.MapperBuilder;
import com.railway.monitor.model.GeoInfo;
import com.railway.monitor.model.GeographicalData;
import com.railway.monitor.utils.DataUtil;
import com.railway.monitor.utils.HttpUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @program: railway-monitor
 * @description: 地理位置信息
 * @author: lijiwen
 * @create: 2019-10-27 21:40
 **/
@Service
public class GeographicalDataService extends AbstractService {
    public int createData(GeographicalData geographicalData) {
        return sqlSession.insert("geographicalData.insert", geographicalData);
}

    public String getGeo(String jzData) {
        String lac = DataUtil.getData(jzData.substring(0, 4));
        String cid = DataUtil.getData(jzData.substring(4, 8));
        String url = " http://api.cellocation.com:81/cell/";
        Map<String, String> params = Maps.newHashMap();
        String responseBody = "";
        params.put("mcc", "460");
        params.put("mnc", "1");
        params.put("lac", lac);
        params.put("ci", cid);
        params.put("output", "json");
        try {
            responseBody = HttpUtils.httpGetMethod(url, params);
            GeoInfo geoInfo = MapperBuilder.getDefaultMapper().readValue(responseBody, GeoInfo.class);
            GeographicalData geographicalData = new GeographicalData();
            geographicalData.setLat(geoInfo.getLat());
            geographicalData.setLng(geoInfo.getLon());
            geographicalData.setDate("0")
                    .setDirection("0")
                    .setSign("0")
                    .setTime("");
            sqlSession.insert("geographicalData.insert", geographicalData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

}
