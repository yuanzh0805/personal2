package cn.sdu.service.impl.biaoqian;

import java.util.ArrayList;
import java.util.List;

import cn.sdu.domain.Biaodoc;
import cn.sdu.domain.Biaoqian;
import cn.sdu.domain.Document;
import cn.sdu.domain.User;
import cn.sdu.service.impl.BaseServiceImpl;
import cn.sdu.service.impl.document.DocumentServiceImpl;
import cn.sdu.service.inter.biaoqian.BiaoqianServiceInter;
import cn.sdu.service.inter.document.DocumentServiceInter;
import cn.sdu.springAop.GetCache;

public class BiaoqianServiceImpl extends BaseServiceImpl implements
		BiaoqianServiceInter {

	@Override
	public void addBiaoqian(Biaoqian biaoqian) {
		// TODO Auto-generated method stub
		save(biaoqian);
	}

	@Override
	public boolean check(Biaoqian biaoqian) {
		List<Biaoqian> list = getResult("from Biaoqian where bname=?", new Object[]{biaoqian.getBname()});
		System.out.println(biaoqian.getBname());
		if(list.size() > 0){
			return  true;
		}else{
			return false;
		}
	}

	@Override
	public Biaoqian findByName(String str) {
		List<Biaoqian> list = getResult("from Biaoqian where bname=?", new Object[]{str});		
		if(list.size() > 0){
			return  (Biaoqian)list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Biaoqian> listBiaoqian(List<Biaodoc> list) {
		List<Biaoqian> list_t = new ArrayList<>();
		for (Biaodoc biaodoc : list) {
			list_t.add((Biaoqian)findById(Biaoqian.class, biaodoc.getBiaoqian().getBid()));			
		}
		return list_t;
	}

}
