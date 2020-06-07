package com.moolng.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 考勤记录
 * </p>
 *
 * @author 李权
 * @since 2020-06-07
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysAttendanceRecord extends Model {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 设备号
     */
    private String driverNum;

    /**
     * 卡号
     */
    private String cardNum;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * Y已删除，N未删除
     */
    private String isDelete;

    private Date myDate;

    private String myYear;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }

    public String getMyYear() {
        return myYear;
    }

    public void setMyYear(String myYear) {
        this.myYear = myYear;
    }
}
