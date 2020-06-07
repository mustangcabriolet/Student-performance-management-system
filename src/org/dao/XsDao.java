package org.dao;
import java.util.*;
import org.model.*;
public interface XsDao {
	/* 方法：学生信息查询 */
	public List findAll(int pageNow, int pageSize);		//显示所有学生信息
	public int findXsSize();							//查询一共多少条学生记录
	
	/* 方法：查看某个学生的详细信息 */
	public Xsb find(String xh);							//根据学号查询某学生信息
	
	/* 方法：删除某学生信息 */
	public void delete(String xh);						//根据学号删除学生
	
	/* 方法：修改某学生信息 */
	public void update(Xsb xs);							//修改学生信息
	
	/* 方法：学生信息录入 */
	public void save(Xsb xs);							//插入学生
}
