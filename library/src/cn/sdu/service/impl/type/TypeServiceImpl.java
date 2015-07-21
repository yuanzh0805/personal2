package cn.sdu.service.impl.type;

import java.util.List;

import cn.sdu.domain.Type;
import cn.sdu.service.impl.BaseServiceImpl;
import cn.sdu.service.inter.type.TypeServiceInter;

public class TypeServiceImpl extends BaseServiceImpl implements
		TypeServiceInter {

	@Override
	public List<Type> getType(String str) {
		List<Type> list = getResult("from Type where extendid=?", new Object[]{Integer.valueOf(str)});
		if(list.size() > 0){
			return  list;
		}else{
			return null;
		}
	}

}
