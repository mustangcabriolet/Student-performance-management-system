package org.dao.imp;
import java.util.*;
import org.dao.*;
import org.model.*;
import org.hibernate.*;
public class DlDaoImp extends BaseDAO implements DlDao{
	//实现：根据学号和口令查找
	public Dlb find(String xh, String kl){
		//查询 DLB 表中的记录
		String hql="from Dlb u where u.xh=? and u.kl=?";
		Session session=getSession();
		Query query=session.createQuery(hql);
		query.setParameter(0, xh);
		query.setParameter(1, kl);
		List users=query.list();
		Iterator it=users.iterator();
		while(it.hasNext()){
			if(users.size()!=0){
				Dlb user=(Dlb)it.next();	//创建持久化的 JavaBean 对象 user
				return user;
			}
		}
		session.close();
		return null;
	}
}
