package com.modules.common.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *
 *
 */
@Data
public class BaseVO {
    /**
     * 创建人id
     */
    private Long createUserId;
    /**
     * 更新人id
     */
    private Long updateUserId;
    /**
     * 创建时间
     */
    //timezone：是时间设置为东八区，避免时间在转换中有误差
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    /**
     * 更新时间
     */
    //timezone：是时间设置为东八区，避免时间在转换中有误差
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
    /**
     * 是否删除
     */
    private boolean isDeleted;
}
