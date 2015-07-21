package cn.sdu.service.impl.filedown;

import java.util.List;

import cn.sdu.domain.Filedown;
import cn.sdu.domain.User;
import cn.sdu.service.impl.BaseServiceImpl;
import cn.sdu.service.inter.filedown.FiledownServiceInter;

public class FiledownServiceImpl extends BaseServiceImpl implements
		FiledownServiceInter {

	@Override
	public Filedown find(Filedown filedown) {
		List<Filedown> list = getResult("from Filedown where userid=? and did=?", new Object[]
				{filedown.getUser().getUserid(),filedown.getDocument().getDid()});
		if(list.size() == 1){
			return  list.get(0);
		}else{
			return null;
		}
	}

}
