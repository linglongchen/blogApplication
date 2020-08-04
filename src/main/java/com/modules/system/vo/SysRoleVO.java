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
@ApiModel("SysRoleVO")
public class SysRoleVO extends BaseVO {

    /**
    * 编号
    */
    @ApiModelProperty("编号")
	private Long id;
    /**
    * 角色名称
    */
    @ApiModelProperty("角色名称")
	private String name;
    /**
    * 备注
    */
    @ApiModelProperty("备注")
	private String remark;
}
