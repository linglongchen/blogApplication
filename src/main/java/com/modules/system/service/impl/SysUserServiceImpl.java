package com.modules.system.service.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.common.jwt.JwtUtils;
import com.modules.common.utils.PageInfo;
import com.modules.system.dao.SysUserDao;
import com.modules.system.dbEntity.SysUserDB;
import com.modules.system.entity.SysUser;
import com.modules.system.query.SysUserQuery;
import com.modules.system.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
* @author chen
*
* @date 2020-07-31 15:42:18
*/
@Service
public class SysUserServiceImpl implements SysUserService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SysUserDao sysUserDao;
	@Resource
	private JwtUtils jwtUtils;

	@Override
	public SysUser get(Long id) {
	    Wrapper<SysUser> wrapper = new QueryWrapper<SysUser>().eq("id", id).eq("is_deleted",0);
		SysUser sysUser =  sysUserDao.selectOne(wrapper);
		return sysUser;
	}

	@Override
	public int delete(Long id) {
		SysUser entity = new SysUser();
	    entity.setIsDeleted(1);
		entity.setId(id);
		return sysUserDao.updateById(entity);
	}

	@Override
	public long insert(SysUser entity) {
	    entity.setIsDeleted(0);
		int i = sysUserDao.insert(entity);
        if(i > 0){
			return entity.getId();
			}
		return 0;
	}

	@Override
	public int insertAll(List<SysUser> list) {
		list.forEach(obj ->{
		obj.setCreateTime(new Date());
		obj.setIsDeleted(0);
		});
		return sysUserDao.insertList(list);
		}


	@Override
	public int update(Long id, SysUser entity) {
		Wrapper<SysUser> wrapper = new QueryWrapper<SysUser>().eq("id", id);
		return sysUserDao.update(entity,wrapper);
	}

	@Override
	public Integer getLastNumber() {
	return sysUserDao.getLastNumber();
	}


	@Override
	public PageInfo<SysUser> page(SysUserQuery query, int page, int size) {
		IPage<SysUser> iPageData = new Page<SysUser>();
		iPageData.setCurrent(page);
		iPageData.setSize(size);
		Wrapper<SysUser> wrapper = new QueryWrapper<SysUser>().eq("is_deleted",0).orderByDesc("create_time");
		IPage<SysUser> iPage = sysUserDao.selectPage(iPageData,wrapper);
		return new PageInfo<SysUser>(iPage);
	}

	@Override
	public SysUser next(Long id) {
		return sysUserDao.next(id);
	}

	@Override
	public SysUser prev(Long id) {
		return sysUserDao.prev(id);
	}


	@Override
	public SysUser findByUserName(String name){
		Wrapper<SysUser> wrapper = new QueryWrapper<SysUser>().eq("is_deleted",0).eq("username",name);
		return sysUserDao.selectOne(wrapper);

	}

	@Override
	public SysUserDB selectUserRole(String name){
		return sysUserDao.selectUserRole(name);
	}

	@Override
	public SysUser getSysUserByToken(String token){
		String name = jwtUtils.getUsernameFromToken(token);
		return findByUserName(name);
	}


}
