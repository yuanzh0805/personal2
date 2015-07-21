package cn.sdu.service.inter.biaodoc;

import java.util.List;

import cn.sdu.domain.Biaodoc;
import cn.sdu.domain.Biaoqian;
import cn.sdu.domain.Document;
import cn.sdu.service.inter.BaseServiceInter;
import cn.sdu.springAop.GetCache;

public interface BiaodocServiceInter extends BaseServiceInter {

	public void addBiaodoc(Biaodoc biaoDoc);
	public List<Biaodoc> find(Document document);	
	@GetCache(type = "document")
	public List<Document> listById(Integer integer);
}
