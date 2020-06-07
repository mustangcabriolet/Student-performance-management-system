package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class ZyServiceManage implements ZyService{
	private ZyDao zyDao;
	/* 业务实现：学生信息查询 */
	public Zyb getOneZy(Integer zyId){
		return zyDao.getOneZy(zyId);
	}
	
	/* 业务实现：修改某学生信息 */
	public List getAll(){
		return zyDao.getAll();
	}
	
	public ZyDao getZyDao(){
		return zyDao;
	}
	public void setZyDao(ZyDao zyDao){
		this.zyDao = zyDao;
	}
}
