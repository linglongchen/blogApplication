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
@TableName("sys_menu")
public class SysMenu extends BaseEntity {

    /**
    * 编号
    */
	private Long id;
    /**
    * 菜单名称
    */
	private String name;
    /**
    * 父菜单ID，一级菜单为0
    */
	private Long parentId;
    /**
    * 菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)
    */
	private String url;
    /**
    * 授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)
    */
	private String perms;
    /**
    * 类型   0：目录   1：菜单   2：按钮
    */
	private Integer type;
    /**
    * 菜单图标
    */
	private String icon;
    /**
    * 排序
    */
	private Integer nums;


}

