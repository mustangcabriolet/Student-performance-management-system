package org.service.imp;
import java.util.*;

import org.dao.*;
import org.service.*;
import org.model.*;
public class CjServiceManage implements CjService{
	private CjDao cjDao;
	/* 业务实现：成绩信息录入 */
	public Cjb getXsCj(String xh, String kch){
		return cjDao.getXsCj(xh, kch);
	}
	public void saveorupdateCj(Cjb cj){
		cjDao.saveorupdateCj(cj);
	}
	
	/* 业务实现：学生成绩查询 */
	public List findAllCj(int pageNow, int pageSize){
		return cjDao.findAllCj(pageNow, pageSize);
	}
	public int findCjSize(){
		return cjDao.findCjSize();
	}
	
	/* 业务实现：查看某个学生的成绩表 */
	public List getXsCjList(String xh){
		return cjDao.getXsCjList(xh);
	}
	
	/* 业务实现：删除学生成绩 */
	public void deleteCj(String xh, String kch){
		cjDao.deleteCj(xh, kch);
	}
	public void deleteOneXsCj(String xh){
		cjDao.deleteOneXsCj(xh);
	}
	
	public CjDao getCjDao(){
		return cjDao;
	}
	public void setCjDao(CjDao cjDao){
		this.cjDao = cjDao;
	}
}
