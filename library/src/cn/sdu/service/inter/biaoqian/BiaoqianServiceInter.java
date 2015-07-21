package cn.sdu.service.inter.biaoqian;

import java.util.List;

import cn.sdu.domain.Biaodoc;
import cn.sdu.domain.Biaoqian;
import cn.sdu.service.inter.BaseServiceInter;
import cn.sdu.springAop.GetCache;

public interface BiaoqianServiceInter extends BaseServiceInter {

	public void addBiaoqian(Biaoqian biaoqian);
	public boolean check(Biaoqian biaoqian);
	public Biaoqian findByName(String str);
	public List<Biaoqian> listBiaoqian(List<Biaodoc> list);
	
}
