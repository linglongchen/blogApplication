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
@TableName("sys_user_role")
public class SysUserRole extends BaseEntity {

    /**
    * 编号
    */
	private Long id;
    /**
    * 用户ID
    */
	private Long userId;
    /**
    * 角色ID
    */
	private Long roleId;


}

