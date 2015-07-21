package cn.sdu.service.inter.type;

import java.util.List;
import cn.sdu.domain.Type;
import cn.sdu.service.inter.BaseServiceInter;

public interface TypeServiceInter extends BaseServiceInter {
	public List<Type> getType(String str);

}
