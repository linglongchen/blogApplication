package com.modules.system.service;


import com.modules.common.utils.PageInfo;
import com.modules.system.entity.SysRole;
import com.modules.system.query.SysRoleQuery;

import java.util.List;

/**
* @author chen
*
* @date 2020-07-31 15:42:18
*/
public interface SysRoleService {
    /**
    *获取一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysRole
    */
    SysRole get(Long id);
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
    long insert(SysRole entity);
    /**
    *  批量插入
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param list
    * @return int
    */
    int insertAll(List<SysRole> list);
    /**
    * 更新一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @param entity
    * @return int
    */
    int update(Long id,SysRole entity);
    /**
    * 获取分页数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param query
    * @param page
    * @param size
    * @return com.tencent.modules.common.utils.PageInfo
    */
    PageInfo<SysRole> page(SysRoleQuery query, int page, int size);
    /**
    * 下一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysRole
    */
    SysRole next(Long id);
    /**
    * 上一条数据
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysRole
    */
    SysRole prev(Long id);
    /**
    *  获取最后一个编号
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param
    * @return java.lang.Integer
    */
    Integer getLastNumber();

}
