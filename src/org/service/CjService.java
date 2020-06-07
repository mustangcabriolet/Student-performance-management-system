package org.service;
import java.util.*;

import org.model.*;
public interface CjService {
	/* ���񣺳ɼ���Ϣ¼�� */
	public Cjb getXsCj(String xh, String kch);			//����ѧ�źͿγ̺Ų�ѯѧ���ɼ�
	public void saveorupdateCj(Cjb cj);					//¼��ѧ���ɼ�
	
	/* ����ѧ���ɼ���ѯ */
	public List findAllCj(int pageNow, int pageSize);	//��ҳ��ʾ����ѧ���ɼ�
	public int findCjSize();							//��ѯһ���������ɼ���¼
	
	/* ���񣺲鿴ĳ��ѧ���ĳɼ��� */
	public List getXsCjList(String xh);					//��ȡĳѧ���ĳɼ��б�
	
	/* ����ɾ��ѧ���ɼ� */
	public void deleteCj(String xh, String kch);		//����ѧ�źͿγ̺�ɾ��ѧ���ɼ�
	public void deleteOneXsCj(String xh);				//ɾ��ĳѧ���ĳɼ�����ɾ��������Ϣʱ��Ӧɾ����
}
