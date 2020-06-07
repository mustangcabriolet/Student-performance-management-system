package org.dao;
import org.model.*;
public interface DlDao {
	//方法：根据学号和口令查找
	public Dlb find(String xh, String kl);
}
