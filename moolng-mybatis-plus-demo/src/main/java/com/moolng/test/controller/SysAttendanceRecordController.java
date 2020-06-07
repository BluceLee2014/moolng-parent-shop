package com.moolng.test.controller;


import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.moolng.test.entity.SysAttendanceRecord;
import com.moolng.test.entity.ao.UserAO;
import com.moolng.test.service.ISysAttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 考勤记录 前端控制器
 * </p>
 *
 * @author 李权
 * @since 2020-06-07
 */
@RestController
@RequestMapping("/test/")
public class SysAttendanceRecordController {

    @Autowired
    ISysAttendanceRecordService iSysAttendanceRecordService;

    @GetMapping(value = "/list")
    public String index(UserAO userAO){
        Page<SysAttendanceRecord> reultPage = iSysAttendanceRecordService.findAll(userAO);
        for(SysAttendanceRecord record : reultPage.getResult()){
            System.out.println(record.getId());
        }
        String resultVal = JSONArray.toJSONString(reultPage.getResult());
        System.out.println(resultVal);
        return resultVal;
    }

}
