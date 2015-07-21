package cn.sdu.service.impl;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import cn.sdu.service.inter.BaseServiceInter;

@Transactional
public class BaseServiceImpl implements BaseServiceInter{

	@Autowired
	private SessionFactory sessionFactory;
	
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public void setSessionFactory(SessionFactory sessionFactory) {   //是否可以去掉？
//		this.sessionFactory = sessionFactory;
//	}

	/**
	 * 根据带问号的hql，返回语句查询信息
	 */
	@Override
	public List getResult(String hql, Object[] parameters) {
		//注入参数
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if(parameters!=null&&parameters.length>0){
			for(int i = 0;i<parameters.length;i++){
				query.setParameter(i, parameters[i]);
			}
		}
		return query.list();
	}

	@Override
	public void save(Object obj) {
		sessionFactory.getCurrentSession().save(obj);
		
	}

	@Override
	public void delete(Object obj) {
		sessionFactory.getCurrentSession().delete(obj);
		
	}

	@Override
	public void update(Object obj) {
		sessionFactory.getCurrentSession().update(obj);
		
	}

	@Override
	public Object findById(Class clazz, Serializable id) {
		return this.sessionFactory.getCurrentSession().load(clazz, id);
	}
}
