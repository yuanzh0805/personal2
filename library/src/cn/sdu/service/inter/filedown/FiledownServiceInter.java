package cn.sdu.service.inter.filedown;

import cn.sdu.domain.Filedown;
import cn.sdu.service.inter.BaseServiceInter;

public interface FiledownServiceInter extends BaseServiceInter {
	public Filedown find(Filedown filedown);
}
