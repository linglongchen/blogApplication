package com.modules.common.utils;

import com.google.common.collect.Lists;
import com.modules.system.vo.SysMenuVO;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TreeBuilder {

    public static Set<SysMenuVO> buildTree(Set<SysMenuVO> allNodes) {
        // 根节点
        Set<SysMenuVO> root = new HashSet<>();
        allNodes.forEach(node -> {
            if (Long.valueOf( node.getParentId() ) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findChildren(node, allNodes);
        });
        return root;
    }


    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static SysMenuVO findChildren(SysMenuVO treeNode, Set<SysMenuVO> treeNodes) {
        for (SysMenuVO it : treeNodes) {
            if (String.valueOf( treeNode.getId() ).equals(it.getParentId())) {
                treeNode.getChildren().add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }

    public static List<MenuTreeNode> buildMenuTree(List<MenuTreeNode> allNodes) {
        // 根节点
        List<MenuTreeNode> root = Lists.newArrayList();
        allNodes.forEach(node -> {
            if (Long.valueOf( node.getParentId() ) == 0) {
                root.add(node);
            }
        });
        root.forEach(node -> {
            findMenuChildren(node, allNodes);
        });
        //对根节点排序
        List<MenuTreeNode> sortedList = root.stream().sorted( Comparator.comparing( MenuTreeNode::getNums ) ).collect( Collectors.toList());
        //先清空，在添加
        root.clear();
        root.addAll( sortedList );
        return root;
    }


    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private static MenuTreeNode findMenuChildren(MenuTreeNode treeNode, List<MenuTreeNode> treeNodes) {
        for (MenuTreeNode it : treeNodes) {
            if (String.valueOf( treeNode.getId() ).equals(it.getParentId())) {
                treeNode.getChildren().add(findMenuChildren(it, treeNodes));
            }
        }
        //对子节点排序
        List<MenuTreeNode> childrenSorted = treeNode.getChildren().stream().sorted( Comparator.comparing( MenuTreeNode::getNums ) ).collect( Collectors.toList());
        //先清空，在添加
        treeNode.getChildren().clear();
        treeNode.getChildren().addAll( childrenSorted );
        return treeNode;
    }

}
