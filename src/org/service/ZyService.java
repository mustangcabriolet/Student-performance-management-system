package org.service;
import java.util.*;
import org.model.*;
public interface ZyService {
	/* ����ѧ����Ϣ��ѯ */
	public Zyb getOneZy(Integer zyId);		//����רҵID����רҵ��Ϣ
	
	/* �����޸�ĳѧ����Ϣ */
	public List getAll();					//��������רҵ��Ϣ��Ϊ����רҵ�����б��ã�
}
