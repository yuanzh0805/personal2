package cn.sdu.service.impl.biaodoc;

import java.util.ArrayList;
import java.util.List;

import cn.sdu.domain.Biaodoc;
import cn.sdu.domain.Biaoqian;
import cn.sdu.domain.Document;
import cn.sdu.domain.User;
import cn.sdu.service.impl.BaseServiceImpl;
import cn.sdu.service.inter.biaodoc.BiaodocServiceInter;
import cn.sdu.springAop.GetCache;

public class BiaodocServiceImpl extends BaseServiceImpl implements
		BiaodocServiceInter {

	@Override
	public void addBiaodoc(Biaodoc biaoDoc) {
		// TODO Auto-generated method stub
		save(biaoDoc);
	}

	@Override
	public List<Biaodoc> find(Document document) {
		List<Biaodoc> list = getResult("from Biaodoc where did=?", new Object[]{document.getDid()});
		if(list.size() > 0){
			return  list;
		}else{
			return null;
		}
	}
	
	@Override
	@GetCache(type = "document")
	public List<Document> listById(Integer integer) {
		List<Biaodoc> list_Biaodoc = getResult("from Biaodoc where bid=?", new Object[]{integer});
		List<Document> list_Documents = new ArrayList<>();
//		DocumentServiceImpl documentServiceImpl = new DocumentServiceImpl();
		if(list_Biaodoc.size() > 0 ){
			for (Biaodoc biaodoc : list_Biaodoc) {
				list_Documents.add(biaodoc.getDocument());
			}
			return  list_Documents;
		}else{
			return null;
		}
	}

}
