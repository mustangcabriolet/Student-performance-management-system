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
	/* Action ģ�飺�޸�ĳѧ����Ϣ */
	private ZyService zyService;			//���ڲ�������רҵ��Ϣ�Լ���רҵ�����б�
	private File zpFile;					//���ڻ�ȡ��Ƭ�ļ�
	/* Action ģ�飺ѧ����Ϣ¼�� */
	private List list;						//���רҵ����	
	/* Action ģ�飺ѧ����Ϣ��ѯ */
	public String execute() throws Exception{
		List list=xsService.findAll(pageNow,pageSize);
		Map request=(Map)ActionContext.getContext().get("request");
		Pager page=new Pager(getPageNow(),xsService.findXsSize());
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	
	/* Action ģ�飺�鿴ĳ��ѧ������ϸ��Ϣ */
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
	
	/* Action ģ�飺ɾ��ĳѧ����Ϣ */
	public String deleteXs() throws Exception{
		String xh=xs.getXh();
		xsService.delete(xh);
		return SUCCESS;
	}
	
	/* Action ģ�飺�޸�ĳѧ����Ϣ */
	public String updateXsView() throws Exception{					//��ʾ�޸�ҳ��
		String xh=xs.getXh();
		Xsb xsInfo=xsService.find(xh);
		List zys=zyService.getAll();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("xsInfo", xsInfo);
		request.put("zys", zys);
		return SUCCESS;
	}
	public String updateXs() throws Exception{						//ִ���޸Ĳ���
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
	
	/* Action ģ�飺ѧ����Ϣ¼�� */
	public String addXsView() throws Exception{						//��ʾ¼��ҳ��
		return SUCCESS;
	}
	public String addXs() throws Exception{							//ִ��¼�����
		Xsb stu=new Xsb();
		String xh1=xs.getXh();
		//ѧ���Ѵ��ڣ������ظ�¼��
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
	
	/* Action ģ�飺�޸�ĳѧ����Ϣ */
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
	/* Action ģ�飺ѧ����Ϣ¼�� */
	public List getList(){
		return zyService.getAll();			//����רҵ�ļ���
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
