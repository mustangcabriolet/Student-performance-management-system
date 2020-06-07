package org.service.imp;
import org.dao.*;
import org.service.*;
import org.model.*;
public class DlServiceManage implements DlService{
	private DlDao dlDao;
	//业务实现：根据学号和口令查找
	public Dlb find(String xh, String kl){
		return dlDao.find(xh, kl);
	}
	
	public DlDao getDlDao(){
		return dlDao;
	}
	public void setDlDao(DlDao dlDao){
		this.dlDao = dlDao;
	}
}
