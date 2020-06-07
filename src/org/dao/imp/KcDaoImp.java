package org.dao.imp;
import java.util.List;
import org.dao.*;
import org.hibernate.*;
import org.model.*;
public class KcDaoImp extends BaseDAO implements KcDao{
	/* 实现：成绩信息录入 */
	public List findAll(int pageNow, int pageSize){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Kcb");
		//int firstResult=(pageNow-1)*pageSize;
		//query.setFirstResult(firstResult);
		//query.setMaxResults(pageSize);
		List list=query.list();
		ts.commit();
		session.close();
		session=null;
		return list;
	}
	public int findKcSize(){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		return session.createQuery("from Kcb").list().size();
	}
	public Kcb find(String kch){
		try{
			Session session=getSession();
			Transaction ts=session.beginTransaction();
			Query query=session.createQuery("from Kcb where kch=?");
			query.setParameter(0, kch);
			//query.setMaxResults(1);
			Kcb kc=(Kcb)query.uniqueResult();
			ts.commit();
			session.clear();			// 清除缓存
			return kc;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
