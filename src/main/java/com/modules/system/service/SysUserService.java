package com.modules.system.service;


import com.modules.common.utils.PageInfo;
import com.modules.system.dbEntity.SysUserDB;
import com.modules.system.entity.SysUser;
import com.modules.system.query.SysUserQuery;
import com.modules.system.vo.SysUserVO;

import java.util.List;

/**
* @author chen
*
* @date 2020-07-31 15:42:18
*/
public interface SysUserService {
    /**
    *获取一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysUser
    */
    SysUser get(Long id);
    /**
    * 删除一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return int
    */
    int delete(Long id);
    /**
    * 插入一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param entity
    * @return int
    */
    long insert(SysUser entity);
    /**
    *  批量插入
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param list
    * @return int
    */
    int insertAll(List<SysUser> list);
    /**
    * 更新一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @param entity
    * @return int
    */
    int update(Long id,SysUser entity);
    /**
    * 获取分页数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param query
    * @param page
    * @param size
    * @return com.tencent.modules.common.utils.PageInfo
    */
    PageInfo<SysUser> page(SysUserQuery query, int page, int size);
    /**
    * 下一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysUser
    */
    SysUser next(Long id);
    /**
    * 上一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysUser
    */
    SysUser prev(Long id);
    /**
    *  获取最后一个编号
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param
    * @return java.lang.Integer
    */
    Integer getLastNumber();

    SysUser findByUserName(String name);

    /**
     *
     * @param name
     * @return
     */
    SysUserDB selectUserRole(String name);


    /**
     * 通过token获取用户信息
     * @param token
     * @return
     */
    SysUser getSysUserByToken(String token);

    /**
     * 获取用户信息(角色以及菜单)
     * @param token
     * @return
     */
    SysUserVO getCurrentUserInfo(String token);
}
