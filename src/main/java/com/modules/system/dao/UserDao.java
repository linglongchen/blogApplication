package com.modules.system.dao;
import com.modules.system.entity.User;
import com.modules.common.generator.utils.MyMapper;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Options;

/**
* @author chenTom
*
*@date 2020-07-23 16:18:12
*/
public interface UserDao extends MyMapper<User> {
    /**
    * 下一页
    * @author chenTom
    * @date 2020-07-23 16:18:12
    * @param id
    * @return com.modules.system.entity.User
    */
    User next(Long id);
    /**
    * 上一页
    * @author chenTom
    * @date 2020-07-23 16:18:12
    * @param id
    * @return com.modules.system.entity.User
    */
    User prev(Long id);
    /**
    * 覆盖原来的接口方法设置默认自增
    * @author chenTom
    * @date  2020-07-23 16:18:12
    * @param record
    * @return int
    */
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id") // id自动增长
    int insert(User record);
    /**
    * 获取最后一个编号
    * @author caizx
    * @date 2020/2/28 20:45
    * @param
    * @return java.lang.String
    */
    @Select("SELECT (number+0) numberStr FROM user WHERE is_deleted=0 ORDER BY numberStr DESC LIMIT 1")
    @ResultType(Integer.class)
    Integer getLastNumber();

    /**
     * 查询该openid是否存在
     * @return
     */
    @Select("select * from user where wechat_id=#{wechatId}")
    @ResultType(Integer.class)
    User getCountByOpenId(String  openId);


    @Select("select * from user where wechat_id=#{wechatId}")
    @ResultType(User.class)
    User getByOpenId(User userInfo);

}
