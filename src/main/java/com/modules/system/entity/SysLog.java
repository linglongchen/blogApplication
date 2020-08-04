package com.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.modules.common.base.BaseEntity;
import lombok.Data;

/**
* @author chen
*
* @date 2020-07-31 15:42:18
*/
@Data
@TableName("sys_log")
public class SysLog extends BaseEntity {

    /**
    * 编号
    */
	private Long id;
    /**
    * 用户名
    */
	private String userName;
    /**
    * 用户操作
    */
	private String operation;
    /**
    * 请求方法
    */
	private String method;
    /**
    * 请求参数
    */
	private String params;
    /**
    * 执行时长(毫秒)
    */
	private Long time;
    /**
    * IP地址
    */
	private String ip;


}

