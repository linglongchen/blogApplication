package com.modules.system.dao;

import com.modules.common.generator.utils.MyMapper;
import com.modules.system.entity.SysRole;
import com.modules.system.entity.SysUserRole;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author chen
*
*@date 2020-07-31 15:42:18
*/
public interface SysUserRoleDao extends MyMapper<SysUserRole> {
    /**
    * 下一页
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysUserRole
    */
    SysUserRole next(Long id);
    /**
    * 上一页
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysUserRole
    */
    SysUserRole prev(Long id);
    /**
    * 覆盖原来的接口方法设置默认自增
    * @author chen
    * @date  2020-07-31 15:42:18
    * @param record
    * @return int
    */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // id自动增长
    int insert(SysUserRole record);
    /**
    * 获取最后一个编号
    * @author caizx
    * @date 2020/2/28 20:45
    * @param
    * @return java.lang.String
    */
    @Select("SELECT (number+0) numberStr FROM sys_user_role WHERE is_deleted=0 ORDER BY numberStr DESC LIMIT 1")
    @ResultType(Integer.class)
    Integer getLastNumber();

    @Select("select b.* from sys_user_role a left join sys_role b on b.id = a.role_id where a.user_id = #{userId}")
    @ResultType(SysRole.class)
    List<SysRole> selectRoleByUserId(Long userId);

}
