package com.modules.system.service.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.common.utils.PageInfo;
import com.modules.system.dao.SysRoleDao;
import com.modules.system.entity.SysRole;
import com.modules.system.query.SysRoleQuery;
import com.modules.system.service.SysRoleService;
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
public class SysRoleServiceImpl implements SysRoleService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SysRoleDao sysRoleDao;

	@Override
	public SysRole get(Long id) {
	    Wrapper<SysRole> wrapper = new QueryWrapper<SysRole>().eq("id", id).eq("is_deleted",0);
		SysRole sysRole =  sysRoleDao.selectOne(wrapper);
		return sysRole;
	}

	@Override
	public int delete(Long id) {
		SysRole entity = new SysRole();
	    entity.setIsDeleted(1);
		entity.setId(id);
		return sysRoleDao.updateById(entity);
	}

	@Override
	public long insert(SysRole entity) {
	    entity.setIsDeleted(0);
		int i = sysRoleDao.insert(entity);
        if(i > 0){
			return entity.getId();
			}
		return 0;
	}

	@Override
	public int insertAll(List<SysRole> list) {
		list.forEach(obj ->{
		obj.setCreateTime(new Date());
		obj.setIsDeleted(0);
		});
		return sysRoleDao.insertList(list);
		}


	@Override
	public int update(Long id, SysRole entity) {
		Wrapper<SysRole> wrapper = new QueryWrapper<SysRole>().eq("id", id);
		return sysRoleDao.update(entity,wrapper);
	}

	@Override
	public Integer getLastNumber() {
	return sysRoleDao.getLastNumber();
	}

	@Override
	public PageInfo<SysRole> page(SysRoleQuery query, int page, int size) {
		IPage<SysRole> iPageData = new Page<SysRole>();
		iPageData.setCurrent(page);
		iPageData.setSize(size);
		Wrapper<SysRole> wrapper = new QueryWrapper<SysRole>().eq("is_deleted",0).orderByDesc("create_time");
		IPage<SysRole> iPage = sysRoleDao.selectPage(iPageData,wrapper);
		return new PageInfo<SysRole>(iPage);
	}

	@Override
	public SysRole next(Long id) {
		return sysRoleDao.next(id);
	}

	@Override
	public SysRole prev(Long id) {
		return sysRoleDao.prev(id);
	}
}
