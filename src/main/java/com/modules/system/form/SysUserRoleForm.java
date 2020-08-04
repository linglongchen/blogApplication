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
@ApiModel("SysUserRole")
public class SysUserRoleForm {

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
