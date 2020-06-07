package com.moolng.test.service.impl;

import com.github.pagehelper.Page;
import com.moolng.test.entity.SysAttendanceRecord;
import com.moolng.test.entity.ao.UserAO;
import com.moolng.test.mapper.SysAttendanceRecordMapper;
import com.moolng.test.service.ISysAttendanceRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 考勤记录 服务实现类
 * </p>
 *
 * @author 李权
 * @since 2020-06-07
 */
@Service
public class SysAttendanceRecordServiceImpl extends ServiceImpl<SysAttendanceRecordMapper, SysAttendanceRecord> implements ISysAttendanceRecordService {

    @Autowired
    SysAttendanceRecordMapper sysAttendanceRecordMapper;

    @Override
    public Page<SysAttendanceRecord> findAll(UserAO userAO) {
        return sysAttendanceRecordMapper.findAll();
    }
}
