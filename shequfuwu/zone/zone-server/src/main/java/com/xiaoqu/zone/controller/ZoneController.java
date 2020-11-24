package com.xiaoqu.zone.controller;

import com.xiaoqu.zone.pojo.Zone;
import com.xiaoqu.zone.service.ZoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("zone")
@Api("地区查询接口")
public class ZoneController {
    @Autowired
    private ZoneService zoneService;

    @GetMapping("list")
    @ApiOperation(value = "根据父节点(pid)查询地址",notes = "查询地址")
    @ApiImplicitParam(name = "pid",required = true,value = "地区的父节点(pid)")
    public ResponseEntity<List<Zone>> queryZoneListByPid(@RequestParam("pid") Long pid){
        return ResponseEntity.ok(zoneService.queryZoneListByPid(pid));
    }
}
