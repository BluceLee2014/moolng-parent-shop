package com.moolng.test.service.impl;

import com.github.pagehelper.Page;
import com.moolng.test.entity.SysAttendanceRecord;
import com.moolng.test.entity.ao.UserAO;
import com.moolng.test.mapper.SysAttendanceRecordMapper;
import com.moolng.test.service.ISysAttendanceRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
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
        // 获取当前方法的接口上面的注解标签信息
        try {
            String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
            String uri = this.getURI(methodName, userAO);
            System.out.println(uri);
//            System.out.println(method.getAnnotations());
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return sysAttendanceRecordMapper.findAll();
    }

    private <T> String getURI(String methodName, T t) throws NoSuchMethodException {

        Method method = this.getClass().getInterfaces()[0].getMethod(methodName, t.getClass());
        Annotation[] annotations = method.getAnnotations();
        String uri = null;
        for(Annotation ann : annotations){
            System.out.println(ann);
            if(ann.annotationType().equals(GetMapping.class)){
                System.out.println(((GetMapping)ann).value()[0]);
                uri = ((GetMapping)ann).value()[0];
                break;
            }
        }
        return uri;
    }
}
