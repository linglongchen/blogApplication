package com.modules.system.dbEntity;

import com.modules.system.entity.SysRole;
import lombok.Data;

import java.util.List;

/**
 * @author v_vllchen
 */
@Data
public class SysUserDB {

    /**
     * 编号
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 盐
     */
    private String salt;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 状态  0：禁用   1：正常
     */
    private boolean status;
    /**
     * 机构ID
     */
    private Long deptId;


    private SysRole roles;
}
