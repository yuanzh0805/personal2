package cn.sdu.service.inter.document;

import java.util.List;

import cn.sdu.domain.Document;
import cn.sdu.service.inter.BaseServiceInter;

public interface DocumentServiceInter extends BaseServiceInter{

	public void saveDocument(Document document);
	public List<Document> findByName(String name);
	public Document findByNewName(String str);
}
