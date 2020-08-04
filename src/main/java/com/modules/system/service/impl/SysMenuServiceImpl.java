package com.modules.system.service.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.common.utils.PageInfo;
import com.modules.system.dao.SysMenuDao;
import com.modules.system.entity.SysMenu;
import com.modules.system.query.SysMenuQuery;
import com.modules.system.service.SysMenuService;
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
public class SysMenuServiceImpl implements SysMenuService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SysMenuDao sysMenuDao;

	@Override
	public SysMenu get(Long id) {
	    Wrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>().eq("id", id).eq("is_deleted",0);
		SysMenu sysMenu =  sysMenuDao.selectOne(wrapper);
		return sysMenu;
	}

	@Override
	public int delete(Long id) {
		SysMenu entity = new SysMenu();
	    entity.setIsDeleted(1);
		entity.setId(id);
		return sysMenuDao.updateById(entity);
	}

	@Override
	public long insert(SysMenu entity) {
	    entity.setIsDeleted(0);
		int i = sysMenuDao.insert(entity);
        if(i > 0){
			return entity.getId();
			}
		return 0;
	}

	@Override
	public int insertAll(List<SysMenu> list) {
		list.forEach(obj ->{
		obj.setCreateTime(new Date());
		obj.setIsDeleted(0);
		});
		return sysMenuDao.insertList(list);
		}


	@Override
	public int update(Long id, SysMenu entity) {
		Wrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>().eq("id", id);
		return sysMenuDao.update(entity,wrapper);
	}

	@Override
	public Integer getLastNumber() {
	return sysMenuDao.getLastNumber();
	}

	@Override
	public PageInfo<SysMenu> page(SysMenuQuery query, int page, int size) {
		IPage<SysMenu> iPageData = new Page<SysMenu>();
		iPageData.setCurrent(page);
		iPageData.setSize(size);
		Wrapper<SysMenu> wrapper = new QueryWrapper<SysMenu>().eq("is_deleted",0).orderByDesc("create_time");
		IPage<SysMenu> iPage = sysMenuDao.selectPage(iPageData,wrapper);
		return new PageInfo<SysMenu>(iPage);
	}

	@Override
	public SysMenu next(Long id) {
		return sysMenuDao.next(id);
	}

	@Override
	public SysMenu prev(Long id) {
		return sysMenuDao.prev(id);
	}
}
