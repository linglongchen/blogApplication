package com.modules.common.utils;

import com.google.common.collect.Lists;
import com.modules.system.entity.SysMenu;
import lombok.Data;

import java.util.List;

@Data
public class MenuTreeNode extends SysMenu {

    List<MenuTreeNode> children = Lists.newArrayList();

}
