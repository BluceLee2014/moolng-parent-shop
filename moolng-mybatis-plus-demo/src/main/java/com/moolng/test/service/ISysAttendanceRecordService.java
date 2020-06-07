package com.moolng.test.service;

import com.github.pagehelper.Page;
import com.moolng.test.entity.SysAttendanceRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.moolng.test.entity.ao.UserAO;

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

    Page<SysAttendanceRecord> findAll(UserAO userAO);

}
