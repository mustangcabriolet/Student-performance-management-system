package org.service.imp;
import java.util.*;
import org.dao.*;
import org.service.*;
import org.model.*;
public class ZyServiceManage implements ZyService{
	private ZyDao zyDao;
	/* ҵ��ʵ�֣�ѧ����Ϣ��ѯ */
	public Zyb getOneZy(Integer zyId){
		return zyDao.getOneZy(zyId);
	}
	
	/* ҵ��ʵ�֣��޸�ĳѧ����Ϣ */
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
