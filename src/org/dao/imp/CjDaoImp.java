package org.dao.imp;
import java.util.*;

import org.dao.*;
import org.hibernate.*;
import org.model.*;
public class CjDaoImp extends BaseDAO implements CjDao{
	/* 实现：成绩信息录入 */
	public Cjb getXsCj(String xh, String kch){
		CjbId cjbId=new CjbId();
		cjbId.setXh(xh);
		cjbId.setKch(kch);
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		return (Cjb)session.get(Cjb.class, cjbId);
	}
	public void saveorupdateCj(Cjb cj){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(cj);
		ts.commit();
		session.close();
	}
	
	/* 实现：学生成绩查询 */
	public List findAllCj(int pageNow, int pageSize){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("SELECT c.id.xh,a.xm,b.kcm,c.cj,c.xf,c.id.kch FROM Xsb a,Kcb b,Cjb c WHERE a.xh=c.id.xh AND b.kch=c.id.kch");
		//query.setFirstResult((pageNow-1)*pageSize);			//分页从记录开始查找
		//query.setMaxResults(pageSize);						//查找到的最大条数
		List list=query.list();
		ts.commit();
		session.close();
		return list;
	}
	public int findCjSize(){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			return session.createQuery("from Cjb").list().size();			
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/* 实现：查看某个学生的成绩表 */
	public List getXsCjList(String xh){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("SELECT c.id.xh,a.xm,b.kcm,c.cj,c.xf FROM Xsb a,Kcb b,Cjb c WHERE c.id.xh=? AND a.xh=c.id.xh AND b.kch=c.id.kch");
		query.setParameter(0, xh);
		List list=query.list();
		ts.commit();
		session.close();
		return list;
	}
	
	/* 实现：删除学生成绩 */
	public void deleteCj(String xh, String kch){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.delete(getXsCj(xh, kch));
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void deleteOneXsCj(String xh){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			session.delete(getXsCjList(xh));
			ts.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
