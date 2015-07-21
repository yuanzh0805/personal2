package cn.sdu.service.impl.document;

import java.util.List;

import cn.sdu.domain.Document;
import cn.sdu.service.impl.BaseServiceImpl;
import cn.sdu.service.inter.document.DocumentServiceInter;

public class DocumentServiceImpl extends BaseServiceImpl implements DocumentServiceInter {

	@Override
	public void saveDocument(Document document) {
		save(document);		
	}

	@Override
	public List<Document> findByName(String name) {
		List<Document> list = getResult("from Document where oldname like ?", new Object[]{"%"+name+"%"});
		return list;
	}

	@Override
	public Document findByNewName(String str) {
		List<Document> list = getResult("from Document where newname=?", new Object[]{str});
		return (Document)list.get(0);
	}

	

}
