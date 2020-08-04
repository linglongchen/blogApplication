package com.modules.system.dao;

import com.modules.common.generator.utils.MyMapper;
import com.modules.system.entity.SysLog;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

/**
* @author chen
*
*@date 2020-07-31 15:42:18
*/
public interface SysLogDao extends MyMapper<SysLog> {
    /**
    * 下一页
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysLog
    */
    SysLog next(Long id);
    /**
    * 上一页
    * @author chen
    * @date 2020-07-31 15:42:18
    * @param id
    * @return com.tencent.modules.sys.entity.SysLog
    */
    SysLog prev(Long id);
    /**
    * 覆盖原来的接口方法设置默认自增
    * @author chen
    * @date  2020-07-31 15:42:18
    * @param record
    * @return int
    */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // id自动增长
    int insert(SysLog record);
    /**
    * 获取最后一个编号
    * @author caizx
    * @date 2020/2/28 20:45
    * @param
    * @return java.lang.String
    */
    @Select("SELECT (number+0) numberStr FROM sys_log WHERE is_deleted=0 ORDER BY numberStr DESC LIMIT 1")
    @ResultType(Integer.class)
    Integer getLastNumber();

}
