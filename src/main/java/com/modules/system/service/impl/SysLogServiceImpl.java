package com.modules.system.service.impl;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.modules.common.utils.PageInfo;
import com.modules.system.dao.SysLogDao;
import com.modules.system.entity.SysLog;
import com.modules.system.query.SysLogQuery;
import com.modules.system.service.SysLogService;
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
public class SysLogServiceImpl implements SysLogService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource
	private SysLogDao sysLogDao;

	@Override
	public SysLog get(Long id) {
	    Wrapper<SysLog> wrapper = new QueryWrapper<SysLog>().eq("id", id).eq("is_deleted",0);
		SysLog sysLog =  sysLogDao.selectOne(wrapper);
		return sysLog;
	}

	@Override
	public int delete(Long id) {
		SysLog entity = new SysLog();
	    entity.setIsDeleted(1);
		entity.setId(id);
		return sysLogDao.updateById(entity);
	}

	@Override
	public long insert(SysLog entity) {
	    entity.setIsDeleted(0);
		int i = sysLogDao.insert(entity);
        if(i > 0){
			return entity.getId();
			}
		return 0;
	}

	@Override
	public int insertAll(List<SysLog> list) {
		list.forEach(obj ->{
		obj.setCreateTime(new Date());
		obj.setIsDeleted(0);
		});
		return sysLogDao.insertList(list);
		}


	@Override
	public int update(Long id, SysLog entity) {
		Wrapper<SysLog> wrapper = new QueryWrapper<SysLog>().eq("id", id);
		return sysLogDao.update(entity,wrapper);
	}

	@Override
	public Integer getLastNumber() {
	return sysLogDao.getLastNumber();
	}

	@Override
	public PageInfo<SysLog> page(SysLogQuery query, int page, int size) {
		IPage<SysLog> iPageData = new Page<SysLog>();
		iPageData.setCurrent(page);
		iPageData.setSize(size);
		Wrapper<SysLog> wrapper = new QueryWrapper<SysLog>().eq("is_deleted",0).orderByDesc("create_time");
		IPage<SysLog> iPage = sysLogDao.selectPage(iPageData,wrapper);
		return new PageInfo<SysLog>(iPage);
	}

	@Override
	public SysLog next(Long id) {
		return sysLogDao.next(id);
	}

	@Override
	public SysLog prev(Long id) {
		return sysLogDao.prev(id);
	}
}
