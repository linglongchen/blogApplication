package com.modules.system.vo;

import com.modules.common.base.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @author chen
*
* @date 2020-07-31 15:42:18
*/
@Data
@ApiModel("SysUserRoleVO")
public class SysUserRoleVO extends BaseVO {

    /**
    * 编号
    */
    @ApiModelProperty("编号")
	private Long id;
    /**
    * 用户ID
    */
    @ApiModelProperty("用户ID")
	private Long userId;
    /**
    * 角色ID
    */
    @ApiModelProperty("角色ID")
	private Long roleId;
}
