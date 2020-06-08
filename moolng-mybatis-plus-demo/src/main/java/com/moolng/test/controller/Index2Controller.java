package com.moolng.test.controller;


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
@RequestMapping("/index2/")
public class Index2Controller {

    @Autowired
    ISysAttendanceRecordService iSysAttendanceRecordService;

    @ApiOperation("测试连接222")
    @GetMapping(value = "/list222")
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
