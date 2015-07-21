package cn.sdu.action;

import java.io.File;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.beans.factory.annotation.Autowired;

import cn.sdu.domain.Biaodoc;
import cn.sdu.domain.Biaoqian;
import cn.sdu.domain.Comment;
import cn.sdu.domain.Document;
import cn.sdu.domain.Filedown;
import cn.sdu.domain.Like;
import cn.sdu.domain.Type;
import cn.sdu.domain.User;
import cn.sdu.service.impl.biaodoc.BiaodocServiceImpl;
import cn.sdu.service.impl.biaoqian.BiaoqianServiceImpl;
import cn.sdu.service.impl.comment.CommentServiceImpl;
import cn.sdu.service.impl.like.LikeServiceImpl;
import cn.sdu.service.inter.document.DocumentServiceInter;
import cn.sdu.service.inter.filedown.FiledownServiceInter;
import cn.sdu.service.inter.user.UserServiceInter;
import cn.sdu.util.ConvertThread;
import cn.sdu.util.MyTools;
import cn.sdu.util.ThreadPool;

import com.opensymphony.xwork2.ActionSupport;
public class FileAction extends ActionSupport implements ServletRequestAware {

	@Resource
	private Document document ;	
	@Resource
	private DocumentServiceInter documentServiceInter;
//	@Autowired
//	private Biaoqian biaoqian;
	@Autowired
	private BiaoqianServiceImpl biaoqianServiceImpl;
//	@Autowired
//	private BiaoDoc biaoDoc;
	@Autowired
	private BiaodocServiceImpl biaodocServiceImpl;
	@Autowired
	private UserServiceInter userServiceInter;
	@Autowired
	private FiledownServiceInter filedownServiceInter;
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@Autowired
	private LikeServiceImpl likeServiceImpl;
	

	private User user = (User)ServletActionContext.getRequest().getSession().getAttribute("userInfo");
	private File file;
	private String erji;
	private String yiji;
	private String label;
	private String jifen;

	//提交过来的file的名字
    private String fileFileName;   
    //提交过来的file的MIME类型
    private String fileContentType;
    private String savePath;
    private String findName;
    private String id;

    private HttpServletRequest request;
//    @Autowired
//	Map<String, Object> request;
//	@Autowired
//	Map<String, Object> session;

    
	public String getFindName() {
		return findName;
	}

	public void setFindName(String findName) {
		this.findName = findName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getYiji() {
		return yiji;
	}

	public void setYiji(String yiji) {
		this.yiji = yiji;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getErji() {
		return erji;
	}

	public void setErji(String erji) {
		this.erji = erji;
	}
	
    public String getJifen() {
		return jifen;
	}

	public void setJifen(String jifen) {
		this.jifen = jifen;
	}

	public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
    
	private String realpath = "";
	
    public String upfile(){
//    	System.out.println("-------------------------"+erji);
    	realpath = ServletActionContext.getServletContext().getRealPath(savePath);
        System.out.println("realpath: "+realpath);
        
        try {
        	if(jifen == null || jifen.equals(""))
        		jifen = "0";
        	if (file != null) {
        		String newname = MyTools.changeName(fileFileName);
                File savefile = new File(new File(realpath), newname);
                Type type = new Type();
                type.setTypeid(Integer.valueOf(erji));
                //路径不存在就创建目录
                if (!savefile.getParentFile().exists())               
                    savefile.getParentFile().mkdirs();
                FileUtils.copyFile(file, savefile);
                
                document.setDnum(0);
                document.setDtime(new Date());
                document.setType(type);
                document.setDnum(Integer.valueOf(jifen));
                document.setOldname(fileFileName);
                document.setNewname(newname);
                String swfname = MyTools.newname(newname,"swf");
//                System.out.println(realpath+"\\"+newname);
                document.setSwfname(swfname);     
                document.setUser(user);
                document.setLooknum(0);
                documentServiceInter.saveDocument(document);        
                
                if(label != null && !label.equals("")){       	
                	String[] strings = label.split(",");
                	for(int i=0;i<strings.length;i++){
                		Biaoqian biaoqian = new Biaoqian(); 
                		biaoqian.setBname(strings[i]);                		
                		if(!biaoqianServiceImpl.check(biaoqian))
                			biaoqianServiceImpl.save(biaoqian);
                		document = documentServiceInter.findByNewName(document.getNewname());
                		biaoqian = biaoqianServiceImpl.findByName(strings[i]);
                		Biaodoc biaoDoc = new Biaodoc();
                		biaoDoc.setBiaoqian(biaoqian);
                		biaoDoc.setDocument(document);
                		biaodocServiceImpl.save(biaoDoc);               		
                	}
                }
                
                ThreadPool.doJob(new ConvertThread(realpath+"\\"+newname,
                		realpath+"\\pdf\\"+MyTools.newname(newname,"pdf"), realpath+"\\swf\\"+swfname));
                   
                
                
                return "upok";
        	}else{
        		request.setAttribute("upmsg", "文件为空");
    			return "err";
        	}
            
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("upmsg", "文件类型错误");
			return "err";
		}
    	
    }
    
    public String findByName(){
    	System.out.println(findName);
    	
    	List<Document> list = documentServiceInter.findByName(findName);
    	if(list.size() > 0)
    		request.setAttribute("documentList", list);
    	return "findok";
    }
    
    public String detailfile(){
    	List<Comment> list = commentServiceImpl.findByDid(id);
		request.setAttribute("commentList", list);
    	document = (Document) documentServiceInter.findById(Document.class, Integer.valueOf(id));
    	request.setAttribute("document", document);
    	List<Biaodoc> list1 = biaodocServiceImpl.find(document);
    	if(list1 != null){    		
    		List<Biaoqian> list2 = biaoqianServiceImpl.listBiaoqian(list1);
    		request.setAttribute("biaoqianList", list2);
    	}
    	Like like = new Like();
    	like.setUser(user);
    	like.setDocument(document);
    	like  = likeServiceImpl.check(like);
    	if(like == null )
    		request.setAttribute("like", "no");
    	return "ok";
    }
    
    public void jifen(){
    	//document = (Document) documentServiceInter.findById(Document.class, Integer.valueOf(id));
    	int i = user.getUsernum();
    	int j = document.getDnum();
    	User user_t = document.getUser();
    	Filedown filedown = new Filedown();
    	filedown.setDocument(document);
    	filedown.setUser(user);
    	filedown.setDowntime(new Date());
    	if(user.getUserid() == user_t.getUserid())
    		return;
    	if(filedownServiceInter.find(filedown) != null)
    		return;
    	if(i >= j){
    		user.setUsernum(i-j);    
    		userServiceInter.update(user);
    		filedownServiceInter.save(filedown);
    		request.getSession().setAttribute("userInfo", user);    		
    		user_t.setUsernum(user_t.getUsernum()+ j);
    		userServiceInter.update(user_t);
    		return;
    	}
    	else
    		request.setAttribute("jifen", "false");
    		
    }
    
    //返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流  
    public InputStream getDownloadFile() throws Exception  
    {  
    	document = (Document) documentServiceInter.findById(Document.class, Integer.valueOf(id));
    	jifen();
    	fileFileName = java.net.URLEncoder.encode(document.getOldname() , "utf-8");
    	System.out.println("document/"+document.getNewname());
    	InputStream fin = ServletActionContext.getServletContext().getResourceAsStream("document/"+document.getNewname());
    	System.out.println(fin.toString());
    	return fin;
    }			


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	
}
