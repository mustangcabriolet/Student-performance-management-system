package org.action;
import java.util.*;
import java.io.*;
import org.model.*;
import org.service.*;
import org.tool.*;
import com.opensymphony.xwork2.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.struts2.*;
public class XsAction extends ActionSupport{
	private int pageNow = 1;
	private int pageSize = 8;
	private Xsb xs;
	private XsService xsService;
	/* Action 模块：修改某学生信息 */
	private ZyService zyService;			//用于查找所有专业信息以加载专业下拉列表
	private File zpFile;					//用于获取照片文件
	/* Action 模块：学生信息录入 */
	private List list;						//存放专业集合	
	/* Action 模块：学生信息查询 */
	public String execute() throws Exception{
		List list=xsService.findAll(pageNow,pageSize);
		Map request=(Map)ActionContext.getContext().get("request");
		Pager page=new Pager(getPageNow(),xsService.findXsSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	
	/* Action 模块：查看某个学生的详细信息 */
	public String findXs() throws Exception{
		String xh=xs.getXh();
		Xsb stu=xsService.find(xh);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xs", stu);
		return SUCCESS;
	}
	public String getImage() throws Exception{
		HttpServletResponse response=ServletActionContext.getResponse();
		String xh=xs.getXh();
		Xsb stu=xsService.find(xh);
		byte[] img=stu.getZp();
		response.setContentType("image/jpeg");
		ServletOutputStream os=response.getOutputStream();
		if(img!=null&&img.length!=0){
			for(int i=0; i<img.length; i++){
				os.write(img[i]);
			}
			os.flush();
		}
		return NONE;
	}
	
	/* Action 模块：删除某学生信息 */
	public String deleteXs() throws Exception{
		String xh=xs.getXh();
		xsService.delete(xh);
		return SUCCESS;
	}
	
	/* Action 模块：修改某学生信息 */
	public String updateXsView() throws Exception{					//显示修改页面
		String xh=xs.getXh();
		Xsb xsInfo=xsService.find(xh);
		List zys=zyService.getAll();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xsInfo", xsInfo);
		request.put("zys", zys);
		return SUCCESS;
	}
	public String updateXs() throws Exception{						//执行修改操作
		Xsb xs1=xsService.find(xs.getXh());
		xs1.setXm(xs.getXm());
		xs1.setXb(xs.getXb());
		xs1.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		xs1.setCssj(xs.getCssj());
		xs1.setZxf(xs.getZxf());
		xs1.setBz(xs.getBz());
		if(this.getZpFile()!=null){
			FileInputStream fis=new FileInputStream(this.getZpFile());
			byte[] buffer=new byte[fis.available()];
			fis.read(buffer);
			xs1.setZp(buffer);
		}
		Map request=(Map)ActionContext.getContext().get("request");
		xsService.update(xs1);
		return SUCCESS;
	}
	
	/* Action 模块：学生信息录入 */
	public String addXsView() throws Exception{						//显示录入页面
		return SUCCESS;
	}
	public String addXs() throws Exception{							//执行录入操作
		Xsb stu=new Xsb();
		String xh1=xs.getXh();
		//学号已存在，不可重复录入
		if(xsService.find(xh1)!=null){
			return ERROR;
		}
		stu.setXh(xs.getXh());
		stu.setXm(xs.getXm());
		stu.setXb(xs.getXb());
		stu.setCssj(xs.getCssj());
		stu.setZxf(xs.getZxf());
		stu.setBz(xs.getBz());
		stu.setZyb(zyService.getOneZy(xs.getZyb().getId()));
		if(this.getZpFile()!=null){
			FileInputStream fis=new FileInputStream(this.getZpFile());
			byte[] buffer=new byte[fis.available()];
			fis.read(buffer);
			stu.setZp(buffer);
		}
		xsService.save(stu);
		return SUCCESS;
	}
	
	public Xsb getXs(){
		return xs;
	}
	public void setXs(Xsb xs){
		this.xs = xs;
	}
	
	public XsService getXsService(){
		return xsService;
	}
	public void setXsService(XsService xsService){
		this.xsService = xsService;
	}
	
	/* Action 模块：修改某学生信息 */
	public ZyService getZyService(){
		return zyService;
	}
	public void setZyService(ZyService zyService){
		this.zyService = zyService;
	}
	
	public File getZpFile(){
		return zpFile;
	}
	public void setZpFile(File zpFile){
		this.zpFile = zpFile;
	}
	//
	/* Action 模块：学生信息录入 */
	public List getList(){
		return zyService.getAll();			//返回专业的集合
	}
	public void setList(List list){
		this.list = list;
	}
	
	public int getPageNow(){
		return pageNow;
	}
	public void setPageNow(int pageNow){
		this.pageNow = pageNow;
	}
	
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize = pageSize;
	}
}
