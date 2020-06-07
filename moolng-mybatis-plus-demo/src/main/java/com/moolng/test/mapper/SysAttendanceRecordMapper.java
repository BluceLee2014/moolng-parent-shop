package com.moolng.test.mapper;

import com.github.pagehelper.Page;
import com.moolng.test.entity.SysAttendanceRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 考勤记录 Mapper 接口
 * </p>
 *
 * @author 李权
 * @since 2020-06-07
 */
@Repository
public interface SysAttendanceRecordMapper extends BaseMapper<SysAttendanceRecord> {

    Page<SysAttendanceRecord> findAll();

}
