package org.action;
import java.util.*;
import org.model.*;
import org.service.*;
import com.opensymphony.xwork2.*;
public class DlAction extends ActionSupport{
	private Dlb dl;
	protected DlService dlService;
	//处理用户请求的 execute 方法
	public String execute() throws Exception{
		boolean validated=false;				//验证成功标识
		Map session=ActionContext.getContext().getSession();		//获得会话对象，用来保存当前登录用户的信息
		Dlb dl1=null;
		//先获得 Dlb 对象，如果是第一次访问该页，用户对象肯定为空，但如果是第二次甚至是第三次，就直接登录主页而无须再次重复验证该用户的信息
		dl1=(Dlb)session.get("dl");
		//如果用户是第一次进入，会话中尚未存储 dl1 持久化对象，故为 null
		if(dl1==null){
			dl1=dlService.find(dl.getXh(), dl.getKl());
			if(dl1!=null){
				session.put("dl", dl1);			//把 dl1 对象存储在会话中
				validated=true;					//标识为 true 表示验证成功通过
    		}
		}
        else{
        	validated=true;						//该用户在之前已登录过并成功验证，故标识为 true 表示无须再验了
        }
        if(validated){
        	//验证成功返回字符串 "success"
        	return SUCCESS;
        }
        else{
            //验证失败返回字符串 "error"
        	return ERROR;
        }
	}
	
	public Dlb getDl(){
		return dl;
	}
	public void setDl(Dlb dl){
		this.dl = dl;
	}
	
	public DlService getDlService(){
		return dlService;
	}
	public void setDlService(DlService dlService){
		this.dlService = dlService;
	}
}
