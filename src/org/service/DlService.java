package org.service;
import org.model.*;
public interface DlService {
	//服务：根据学号和口令查找
	public Dlb find(String xh, String kl);
}
