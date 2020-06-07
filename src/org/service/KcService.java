package org.service;
import java.util.*;
import org.model.*;
public interface KcService {
	/* 服务：成绩信息录入 */
	public List findAll(int pageNow, int pageSize);			//查询所有课程信息
	public int findKcSize();								//查询一共多少条课程记录
	public Kcb find(String kch);							//根据课程号查找课程信息
}
