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
@ApiModel("SysLogVO")
public class SysLogVO extends BaseVO {

    /**
    * 编号
    */
    @ApiModelProperty("编号")
	private Long id;
    /**
    * 用户名
    */
    @ApiModelProperty("用户名")
	private String userName;
    /**
    * 用户操作
    */
    @ApiModelProperty("用户操作")
	private String operation;
    /**
    * 请求方法
    */
    @ApiModelProperty("请求方法")
	private String method;
    /**
    * 请求参数
    */
    @ApiModelProperty("请求参数")
	private String params;
    /**
    * 执行时长(毫秒)
    */
    @ApiModelProperty("执行时长(毫秒)")
	private Long time;
    /**
    * IP地址
    */
    @ApiModelProperty("IP地址")
	private String ip;
}
