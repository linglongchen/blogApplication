package com.modules.system.service.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.common.utils.PageInfo;
import com.modules.system.dao.SysUserRoleDao;
import com.modules.system.entity.SysUserRole;
import com.modules.system.query.SysUserRoleQuery;
import com.modules.system.service.SysUserRoleService;
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
public class SysUserRoleServiceImpl implements SysUserRoleService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SysUserRoleDao sysUserRoleDao;

	@Override
	public SysUserRole get(Long id) {
	    Wrapper<SysUserRole> wrapper = new QueryWrapper<SysUserRole>().eq("id", id).eq("is_deleted",0);
		SysUserRole sysUserRole =  sysUserRoleDao.selectOne(wrapper);
		return sysUserRole;
	}

	@Override
	public int delete(Long id) {
		SysUserRole entity = new SysUserRole();
	    entity.setIsDeleted(1);
		entity.setId(id);
		return sysUserRoleDao.updateById(entity);
	}

	@Override
	public long insert(SysUserRole entity) {
	    entity.setIsDeleted(0);
		int i = sysUserRoleDao.insert(entity);
        if(i > 0){
			return entity.getId();
			}
		return 0;
	}

	@Override
	public int insertAll(List<SysUserRole> list) {
		list.forEach(obj ->{
		obj.setCreateTime(new Date());
		obj.setIsDeleted(0);
		});
		return sysUserRoleDao.insertList(list);
		}


	@Override
	public int update(Long id, SysUserRole entity) {
		Wrapper<SysUserRole> wrapper = new QueryWrapper<SysUserRole>().eq("id", id);
		return sysUserRoleDao.update(entity,wrapper);
	}

	@Override
	public Integer getLastNumber() {
	return sysUserRoleDao.getLastNumber();
	}

	@Override
	public PageInfo<SysUserRole> page(SysUserRoleQuery query, int page, int size) {
		IPage<SysUserRole> iPageData = new Page<SysUserRole>();
		iPageData.setCurrent(page);
		iPageData.setSize(size);
		Wrapper<SysUserRole> wrapper = new QueryWrapper<SysUserRole>().eq("is_deleted",0).orderByDesc("create_time");
		IPage<SysUserRole> iPage = sysUserRoleDao.selectPage(iPageData,wrapper);
		return new PageInfo<SysUserRole>(iPage);
	}

	@Override
	public SysUserRole next(Long id) {
		return sysUserRoleDao.next(id);
	}

	@Override
	public SysUserRole prev(Long id) {
		return sysUserRoleDao.prev(id);
	}



	@Override
	public List<SysUserRole> listByUserId(Long userId){
		Wrapper<SysUserRole> wrapper = new QueryWrapper<SysUserRole>().eq("is_deleted",0).eq("user_id",userId);
			return sysUserRoleDao.selectList(wrapper);
	}

}
