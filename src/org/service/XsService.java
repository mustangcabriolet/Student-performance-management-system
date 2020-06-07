package org.service;
import java.util.*;
import org.model.*;
public interface XsService {
	/* 服务：学生信息查询 */
	public List findAll(int pageNow, int pageSize);		//显示所有学生信息
	public int findXsSize();							//查询一共多少条学生记录
	
	/* 服务：查看某个学生的详细信息 */
	public Xsb find(String xh);							//根据学号查询某学生信息
	
	/* 服务：删除某学生信息 */
	public void delete(String xh);						//根据学号删除学生
	
	/* 服务：修改某学生信息 */
	public void update(Xsb xs);							//修改学生信息
	
	/* 服务：学生信息录入 */
	public void save(Xsb xs);							//插入学生
}
