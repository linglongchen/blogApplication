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
@TableName("sys_user")
public class SysUser extends BaseEntity {

    /**
    * 编号
    */
	private Long id;
    /**
    * 用户名
    */
	private String username;
    /**
    * 密码
    */
	private String password;
    /**
    * 盐
    */
	private String salt;
    /**
    * 邮箱
    */
	private String email;
    /**
    * 手机号
    */
	private String mobile;
    /**
    * 状态  0：禁用   1：正常
    */
	private boolean status;
    /**
    * 机构ID
    */
	private Long deptId;


}

