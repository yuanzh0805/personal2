package cn.sdu.service.inter.comment;

import java.util.List;

import cn.sdu.domain.Comment;
import cn.sdu.service.inter.BaseServiceInter;

public interface CommentServiceInter extends BaseServiceInter {

	public void addComment(Comment comment);
	public List<Comment> findByDid(String str);
}
