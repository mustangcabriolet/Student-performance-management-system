package org.dao;
import org.model.*;
import java.util.*;
public interface ZyDao {
	/* ������ѧ����Ϣ��ѯ */
	public Zyb getOneZy(Integer zyId);		//����רҵID����רҵ��Ϣ
	
	/* �������޸�ĳѧ����Ϣ */
	public List getAll();					//��������רҵ��Ϣ��Ϊ����רҵ�����б��ã�
}
