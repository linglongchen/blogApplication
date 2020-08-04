package com.modules.system.service.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.common.utils.PageInfo;
import com.modules.system.dao.SysRoleMenuDao;
import com.modules.system.entity.SysRoleMenu;
import com.modules.system.query.SysRoleMenuQuery;
import com.modules.system.service.SysRoleMenuService;
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
public class SysRoleMenuServiceImpl implements SysRoleMenuService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public SysRoleMenu get(Long id) {
	    Wrapper<SysRoleMenu> wrapper = new QueryWrapper<SysRoleMenu>().eq("id", id).eq("is_deleted",0);
		SysRoleMenu sysRoleMenu =  sysRoleMenuDao.selectOne(wrapper);
		return sysRoleMenu;
	}

	@Override
	public int delete(Long id) {
		SysRoleMenu entity = new SysRoleMenu();
	    entity.setIsDeleted(1);
		entity.setId(id);
		return sysRoleMenuDao.updateById(entity);
	}

	@Override
	public long insert(SysRoleMenu entity) {
	    entity.setIsDeleted(0);
		int i = sysRoleMenuDao.insert(entity);
        if(i > 0){
			return entity.getId();
			}
		return 0;
	}

	@Override
	public int insertAll(List<SysRoleMenu> list) {
		list.forEach(obj ->{
		obj.setCreateTime(new Date());
		obj.setIsDeleted(0);
		});
		return sysRoleMenuDao.insertList(list);
		}


	@Override
	public int update(Long id, SysRoleMenu entity) {
		Wrapper<SysRoleMenu> wrapper = new QueryWrapper<SysRoleMenu>().eq("id", id);
		return sysRoleMenuDao.update(entity,wrapper);
	}

	@Override
	public Integer getLastNumber() {
	return sysRoleMenuDao.getLastNumber();
	}

	@Override
	public PageInfo<SysRoleMenu> page(SysRoleMenuQuery query, int page, int size) {
		IPage<SysRoleMenu> iPageData = new Page<SysRoleMenu>();
		iPageData.setCurrent(page);
		iPageData.setSize(size);
		Wrapper<SysRoleMenu> wrapper = new QueryWrapper<SysRoleMenu>().eq("is_deleted",0).orderByDesc("create_time");
		IPage<SysRoleMenu> iPage = sysRoleMenuDao.selectPage(iPageData,wrapper);
		return new PageInfo<SysRoleMenu>(iPage);
	}

	@Override
	public SysRoleMenu next(Long id) {
		return sysRoleMenuDao.next(id);
	}

	@Override
	public SysRoleMenu prev(Long id) {
		return sysRoleMenuDao.prev(id);
	}
}
