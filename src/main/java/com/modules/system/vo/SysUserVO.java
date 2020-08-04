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
@ApiModel("SysUserVO")
public class SysUserVO extends BaseVO {

    /**
    * 编号
    */
    @ApiModelProperty("编号")
	private Long id;
    /**
    * 用户名
    */
    @ApiModelProperty("用户名")
	private String username;
    /**
    * 密码
    */
    @ApiModelProperty("密码")
	private String password;
    /**
    * 盐
    */
    @ApiModelProperty("盐")
	private String salt;
    /**
    * 邮箱
    */
    @ApiModelProperty("邮箱")
	private String email;
    /**
    * 手机号
    */
    @ApiModelProperty("手机号")
	private String mobile;
    /**
    * 状态  0：禁用   1：正常
    */
    @ApiModelProperty("状态  0：禁用   1：正常")
	private boolean status;
    /**
    * 机构ID
    */
    @ApiModelProperty("机构ID")
	private Long deptId;
}
