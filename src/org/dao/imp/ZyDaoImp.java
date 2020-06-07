package org.dao.imp;
import java.util.*;
import org.dao.*;
import org.hibernate.*;
import org.model.*;
public class ZyDaoImp extends BaseDAO implements ZyDao{
	/* 实现：学生信息查询 */
	public Zyb getOneZy(Integer zyId){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Zyb where id=?");
			query.setParameter(0, zyId);
			//query.setMaxResults(1);
			return (Zyb)query.uniqueResult();	
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
	
	/* 实现：修改某学生信息 */
	public List getAll(){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			List list=session.createQuery("from Zyb").list();
			ts.commit();
			session.close();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}		
	}
}
