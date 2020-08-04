package com.modules.system.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
* @author chen
*
* @date 2020-07-31 15:42:18
*/
@Data
@ApiModel("SysRole")
public class SysRoleForm {

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
