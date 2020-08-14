/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50728
Source Host           : localhost:3306
Source Database       : questionnaire

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-08-12 15:22:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `operation` varchar(50) DEFAULT NULL COMMENT '用户操作',
  `method` varchar(200) DEFAULT NULL COMMENT '请求方法',
  `params` varchar(5000) DEFAULT NULL COMMENT '请求参数',
  `time` bigint(20) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) DEFAULT NULL COMMENT 'IP地址',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除(1-已删除,0-未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1653 DEFAULT CHARSET=utf8 COMMENT='系统日志';

-- ----------------------------
-- Records of sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)',
  `type` int(11) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `nums` int(11) DEFAULT NULL COMMENT '排序',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除(1-已删除,0-未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', '系统管理', '0', null, null, '0', 'el-icon-setting', '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('2', '用户管理', '1', '/sys/user', null, '1', 'el-icon-service', '1', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('3', '机构管理', '1', '/sys/dept', null, '1', 'el-icon-news', '2', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('4', '角色管理', '1', '/sys/role', null, '1', 'el-icon-view', '4', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('5', '菜单管理', '1', '/sys/menu', null, '1', 'el-icon-menu', '5', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('6', 'SQL监控', '0', 'http://139.196.87.48:8001/druid/login.html', null, '1', 'el-icon-info', '2', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('7', '字典管理', '1', '/sys/dict', null, '1', 'el-icon-edit-outline', '7', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('8', '系统日志', '1', '/sys/log', 'sys:log:view', '1', 'el-icon-info', '8', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('9', '查看', '2', null, 'sys:user:view', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('10', '新增', '2', null, 'sys:user:add', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('11', '修改', '2', null, 'sys:user:edit', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('12', '删除', '2', null, 'sys:user:delete', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('13', '查看', '3', null, 'sys:dept:view', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('14', '新增', '3', null, 'sys:dept:add', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('15', '修改', '3', null, 'sys:dept:edit', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('16', '删除', '3', null, 'sys:dept:delete', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('17', '查看', '4', null, 'sys:role:view', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('18', '新增', '4', null, 'sys:role:add', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('19', '修改', '4', null, 'sys:role:edit', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('20', '删除', '4', null, 'sys:role:delete', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('21', '查看', '5', null, 'sys:menu:view', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('22', '新增', '5', null, 'sys:menu:add', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('23', '修改', '5', null, 'sys:menu:edit', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('24', '删除', '5', null, 'sys:menu:delete', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('28', '使用案例', '0', null, null, '0', 'el-icon-picture-outline', '6', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('29', '国际化', '28', '/demo/i18n', null, '1', 'el-icon-edit', '1', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('30', '换皮肤', '28', '/demo/theme', null, '1', 'el-icon-picture', '2', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('31', '查看', '7', null, 'sys:dict:view', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('32', '新增', '7', null, 'sys:dict:add', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('33', '修改', '7', null, 'sys:dict:edit', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('34', '删除', '7', null, 'sys:dict:delete', '2', null, '0', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('35', '接口文档', '0', 'http://139.196.87.48:8001/swagger-ui.html', null, '1', 'el-icon-tickets', '1', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('38', '服务监控', '0', 'http://139.196.87.48:8000/', '', '1', 'el-icon-view', '3', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('41', '服务治理', '0', 'http://139.196.87.48:8500', '', '1', 'el-icon-service', '4', null, null, null, null, null);
INSERT INTO `sys_menu` VALUES ('42', '代码生成', '0', '/generator/generator', '', '1', 'el-icon-star-on', '5', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) DEFAULT NULL COMMENT '角色名称',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除(1-已删除,0-未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='角色管理';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '超级管理员', null, null, null, null, null);
INSERT INTO `sys_role` VALUES ('2', 'dev', '开发人员', null, null, null, null, null);
INSERT INTO `sys_role` VALUES ('4', 'test', '测试人员', null, null, null, null, '0');
INSERT INTO `sys_role` VALUES ('8', 'mng', '部门经理', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `menu_id` bigint(20) DEFAULT NULL COMMENT '菜单ID',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除(1-已删除,0-未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=445 DEFAULT CHARSET=utf8 COMMENT='角色菜单';

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('224', '4', '1', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('225', '4', '2', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('226', '4', '9', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('227', '4', '3', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('228', '4', '13', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('229', '4', '4', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('230', '4', '17', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('231', '4', '5', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('232', '4', '21', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('233', '4', '6', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('234', '4', '7', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('235', '4', '31', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('236', '4', '8', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('237', '4', '25', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('238', '4', '26', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('239', '4', '27', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('240', '4', '28', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('241', '4', '29', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('242', '4', '30', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('243', '4', '35', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('388', '2', '1', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('389', '2', '2', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('390', '2', '9', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('391', '2', '3', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('392', '2', '13', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('393', '2', '17', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('394', '2', '5', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('395', '2', '21', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('396', '2', '7', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('397', '2', '31', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('398', '2', '8', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('399', '2', '6', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('400', '2', '35', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('401', '2', '28', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('402', '2', '29', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('403', '2', '30', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('404', '3', '1', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('405', '3', '2', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('406', '3', '9', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('407', '3', '3', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('408', '3', '13', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('409', '3', '8', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('410', '3', '6', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('411', '3', '28', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('412', '3', '29', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('413', '3', '30', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('431', '8', '1', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('432', '8', '2', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('433', '8', '9', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('434', '8', '3', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('435', '8', '13', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('436', '8', '4', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('437', '8', '17', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('438', '8', '5', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('439', '8', '21', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('440', '8', '7', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('441', '8', '31', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('442', '8', '8', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('443', '8', '6', null, null, null, null, null);
INSERT INTO `sys_role_menu` VALUES ('444', '8', '35', null, null, null, null, null);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `salt` varchar(40) DEFAULT NULL COMMENT '盐',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(100) DEFAULT NULL COMMENT '手机号',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态  0：禁用   1：正常',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '机构ID',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除(1-已删除,0-未删除)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='用户管理';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('22', '刘备', '3e2837c71ed7013809bda296e94c1e3141a47c17efe5c95d887ea7e16e4ed8df', '5749c68caf394f50ad79', 'test@qq.com', '13889700023', '1', '34', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('23', '赵云', '7388da1b788173de33cd60023e72b048fe166fd59658eb0829bc92b662fe84b6', 'ba301cfff37c4f4294b1', 'test@qq.com', '13889700023', '1', '34', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('24', '诸葛亮', '03598a9d3ca0175b9652267a475b7b49a589a35bb25c5830e3d02c460f344991', '7f31d587bd1a4ba6b28c', 'test@qq.com', '13889700023', '1', '34', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('25', '曹操', '1759880c5a2ea94967db4f5e7a82152cadf831c45c0d1f32af0e939eeb943255', 'b2cb4778302b486cb846', 'test@qq.com', '13889700023', '1', '33', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('26', '典韦', 'c21cd657efcf9fff6e936155246ec3b3d0dc8051941c2edd80871652950919a7', 'cd0bd6d773314062a743', 'test@qq.com', '13889700023', '1', '33', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('27', '夏侯惇', '074f481a029c23fe655bb0a5ca80d4f46239bc7ad6aa1538c00dc32f6185db15', '68024ab4050f423d9eaf', 'test@qq.com', '13889700023', '1', '33', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('28', '荀彧', '74361a718a9a6fa498362d3499c52c7446b1d8eaf2e1babef6bb88257eb7f710', 'fef1f3b8cc674e5a854d', 'test@qq.com', '13889700023', '1', '33', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('29', '孙权', 'e12430482e68dcbffabbc9591e0b6a22c8609fa297c54311543173f200755bda', '2f4300ded4294bb7bdf9', 'test@qq.com', '13889700023', '1', '35', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('30', '周瑜', '5de59dabc6e3ea9e8ed0adec59b84ae5df6c1843702242854cb13bebc176f7dd', '33f508fae431405da24d', 'test@qq.com', '13889700023', '1', '35', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('31', '陆逊', '8f23cd3ba3602b4044c57853d73a9e559e19a8b09b38ba4878215b28a09df1e5', 'e4a2451603e04012ac24', 'test@qq.com', '13889700023', '1', '35', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('32', '黄盖', 'd0914e18fe84a03149f5a293156e85ef5151327610bc9c48a2d66d4a9025b226', '754d3457dc094c45b51a', 'test@qq.com', '13889700023', '1', '35', null, null, null, null, null);
INSERT INTO `sys_user` VALUES ('33', 'admin', '$2a$10$3I//yBJlWrxmnpkGID4LFubLgb6Z0ZwlAxMymlxXaJrEeuV52NXJS', null, null, null, '0', null, null, null, null, null, '0');
INSERT INTO `sys_user` VALUES ('34', '测试', '$2a$10$jEjuTsacEW7XCPEgSEQHQeGXcmUbyoEicvYYC.9i.tcMxCkIpmBiS', 'string', 'string', 'string', '1', '0', null, null, null, null, '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `role_id` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `create_user_id` bigint(20) DEFAULT NULL COMMENT '创建人id',
  `update_user_id` bigint(20) DEFAULT NULL COMMENT '更新人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` tinyint(4) DEFAULT NULL COMMENT '是否删除(1-已删除,0-未删除)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COMMENT='用户角色';

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('2', '2', '1', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('26', '5', '3', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('33', '6', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('34', '4', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('35', '9', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('36', '10', '3', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('37', '11', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('38', '12', '3', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('39', '15', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('41', '16', '3', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('42', '8', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('43', '7', '4', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('45', '18', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('46', '17', '3', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('47', '3', '4', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('48', '21', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('50', '23', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('51', '24', '3', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('52', '25', '8', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('53', '26', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('54', '27', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('56', '29', '8', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('57', '31', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('58', '30', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('59', '32', '3', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('68', '33', '4', null, null, null, null, '0');
INSERT INTO `sys_user_role` VALUES ('69', '22', '8', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('70', '22', '2', null, null, null, null, null);
INSERT INTO `sys_user_role` VALUES ('71', '28', '2', null, null, null, null, null);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=649 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('499', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('500', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('501', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('502', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('503', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('504', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('505', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('506', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('507', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('508', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('509', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('510', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('511', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('512', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('513', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('514', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('515', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('516', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('517', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('518', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('519', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('520', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('521', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('522', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('523', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('524', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('525', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('526', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('527', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('528', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('529', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('530', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('531', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('532', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('533', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('534', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('535', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('536', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('537', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('538', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('539', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('540', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('541', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('542', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('543', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('544', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('545', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('546', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('547', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('548', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('549', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('550', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('551', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('552', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('553', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('554', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('555', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('556', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('557', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('558', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('559', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('560', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('561', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('562', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('563', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('564', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('565', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('566', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('567', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('568', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('569', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('570', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('571', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('572', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('573', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('574', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('575', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('576', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('577', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('578', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('579', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('580', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('581', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('582', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('583', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('584', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('585', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('586', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('587', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('588', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('589', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('590', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('591', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('592', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('593', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('594', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('595', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('596', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('597', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('598', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('599', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('600', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('601', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('602', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('603', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('604', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('605', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('606', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('607', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('608', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('609', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('610', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('611', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('612', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('613', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('614', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('615', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('616', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('617', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('618', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('619', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('620', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('621', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('622', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('623', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('624', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('625', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('626', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('627', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('628', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('629', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('630', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('631', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('632', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('633', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('634', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('635', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('636', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('637', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('638', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('639', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('640', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('641', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('642', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('643', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('644', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('645', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('646', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('647', '\"Hello\"qwer');
INSERT INTO `test` VALUES ('648', '\"Hello\"qwer');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `head_img` varchar(255) DEFAULT NULL,
  `wechat_id` varchar(128) DEFAULT NULL,
  `phone` varchar(128) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` int(11) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `is_deleted` tinyint(2) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'https://wx.qlogo.cn/mmopen/vi_32/DYAIOgq83erzAQctR8x8ZEyfT7yCTwbpcdheuwsR2oMNdhC7iapicJUEV8kZcf2dwKodhl1l0cPJqMV0xN1w6CEA/132', 'o5LWV5NMCEL7X_5ovPr95b6eccpE', null, '陈汤姆', null, null, '2020-07-07 17:41:01', null, null, '0', null, null, null, null);
