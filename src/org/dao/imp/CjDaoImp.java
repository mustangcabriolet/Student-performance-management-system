package org.dao.imp;
import java.util.*;

import org.dao.*;
import org.hibernate.*;
import org.model.*;
public class CjDaoImp extends BaseDAO implements CjDao{
	/* ʵ�֣��ɼ���Ϣ¼�� */
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
	
	/* ʵ�֣�ѧ���ɼ���ѯ */
	public List findAllCj(int pageNow, int pageSize){
		Session session=getSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("SELECT c.id.xh,a.xm,b.kcm,c.cj,c.xf,c.id.kch FROM Xsb a,Kcb b,Cjb c WHERE a.xh=c.id.xh AND b.kch=c.id.kch");
		//query.setFirstResult((pageNow-1)*pageSize);			//��ҳ�Ӽ�¼��ʼ����
		//query.setMaxResults(pageSize);						//���ҵ����������
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
	
	/* ʵ�֣��鿴ĳ��ѧ���ĳɼ��� */
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
	
	/* ʵ�֣�ɾ��ѧ���ɼ� */
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
