package com.moolng.test.app.controller;


import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.Page;
import com.moolng.test.entity.SysAttendanceRecord;
import com.moolng.test.entity.ao.UserAO;
import com.moolng.test.service.ISysAttendanceRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 考勤记录 前端控制器
 * </p>
 *
 * @author 李权
 * @since 2020-06-07
 */
@Api
@RestController
@RequestMapping("/index/")
public class IndexController {

    @Autowired
    ISysAttendanceRecordService iSysAttendanceRecordService;

    @ApiOperation("测试连接")
    @GetMapping(value = "/list")
    public String index(UserAO userAO){
        String resultVal = "/index/list";
//        Page<SysAttendanceRecord> reultPage = iSysAttendanceRecordService.findAll(userAO);
//        for(SysAttendanceRecord record : reultPage.getResult()){
//            System.out.println(record.getId());
//        }
//        String resultVal = JSONArray.toJSONString(reultPage.getResult());
//        System.out.println(resultVal);
        return resultVal;
    }

}
