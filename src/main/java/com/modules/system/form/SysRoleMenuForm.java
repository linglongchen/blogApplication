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
@ApiModel("SysRoleMenu")
public class SysRoleMenuForm {

		/**
		* 编号
		*/
		@ApiModelProperty("编号")
		private Long id;
		/**
		* 角色ID
		*/
		@ApiModelProperty("角色ID")
		private Long roleId;
		/**
		* 菜单ID
		*/
		@ApiModelProperty("菜单ID")
		private Long menuId;

}
