package com.moolng.test.service;

import com.github.pagehelper.Page;
import com.moolng.test.entity.SysAttendanceRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.moolng.test.entity.ao.UserAO;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p>
 * 考勤记录 服务类
 * </p>
 *
 * @author 李权
 * @since 2020-06-07
 */
public interface ISysAttendanceRecordService extends IService<SysAttendanceRecord> {

    @GetMapping("/我是你的注解pageListGetMapperAnnotation")
    Page<SysAttendanceRecord> findAll(UserAO userAO);

}
