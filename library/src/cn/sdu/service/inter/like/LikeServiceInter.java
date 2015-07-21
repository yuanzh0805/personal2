package cn.sdu.service.inter.like;

import cn.sdu.domain.Like;
import cn.sdu.service.inter.BaseServiceInter;

public interface LikeServiceInter extends BaseServiceInter {
	public void addLike(Like like);
	public void deleLike(Like like);
	public Like check(Like like);

}
