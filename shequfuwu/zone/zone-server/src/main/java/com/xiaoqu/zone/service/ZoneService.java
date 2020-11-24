package com.xiaoqu.zone.service;

import com.xiaoqu.zone.mapper.ZoneMapper;
import com.xiaoqu.zone.pojo.Zone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {
    @Autowired
    private ZoneMapper zoneMapper;

    public List<Zone> queryZoneListByPid(Long pid) {
        Zone zone = new Zone();
        zone.setParentId(pid);

        List<Zone> zoneList = zoneMapper.select(zone);
        return zoneList;
    }
}
