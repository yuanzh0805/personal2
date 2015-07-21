package cn.sdu.service.impl.like;

import java.util.List;

import cn.sdu.domain.Like;
import cn.sdu.domain.User;
import cn.sdu.service.impl.BaseServiceImpl;
import cn.sdu.service.inter.like.LikeServiceInter;

public class LikeServiceImpl extends BaseServiceImpl implements LikeServiceInter{

	@Override
	public void addLike(Like like) {
		save(like);
	}

	@Override
	public Like check(Like like) {
		List<Like> list = getResult("from Like where userid=? and did=?", 
				new Object[]{like.getUser().getUserid(),like.getDocument().getDid()});
		if(list.size() > 0){
			return  list.get(0);
		}else{
			return null;
		}
	}

	@Override
	public void deleLike(Like like) {
		delete(like);
		
	}

}
