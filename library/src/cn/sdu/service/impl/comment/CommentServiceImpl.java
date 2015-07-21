package cn.sdu.service.impl.comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.sdu.domain.Comment;
import cn.sdu.domain.Document;
import cn.sdu.domain.User;
import cn.sdu.service.impl.BaseServiceImpl;
import cn.sdu.service.inter.comment.CommentServiceInter;

public class CommentServiceImpl extends BaseServiceImpl implements
		CommentServiceInter {

	@Override
	public void addComment(Comment comment) {
		save(comment);
	}

	@Override
	public List<Comment> findByDid(String str) {
		List<Comment> list = getResult("from Comment c where c.document.did=?", 
				new Object[]{Integer.valueOf(str)});
//		if(list != null && list.size() > 0){
//			List<Comment> newList = new ArrayList<>();
//			Comment comment = new Comment();
//			for(int i = 0; i < list.size();i++){
//				Object[] object = (Object[]) list.get(i);
//				comment.setCid((Integer)object[0]);
//				comment.setComtime((Date)object[1]);
//				comment.setContent((String)object[2]);
//				comment.setDocument((Document)object[3]);
//				comment.setUser((User)object[4]);
//				newList.add(comment);
//			}
//			return newList;
//		}
		return list;
	}

}
