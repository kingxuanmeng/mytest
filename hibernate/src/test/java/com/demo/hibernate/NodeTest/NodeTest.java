package com.demo.hibernate.NodeTest;

import java.awt.print.Printable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.demo.hibernate.dao.INodeDao;
import com.demo.hibernate.dao.NodeDao;
import com.demo.hibernate.entity.Node;
import com.demo.hibernate.util.HibernateUtil;

public class NodeTest {
	@Test
	public void save() {
		INodeDao nodeDao=new NodeDao();
		nodeDao.save();
		SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
		Session session=sessionFactory.getCurrentSession();
		session.beginTransaction();
		Node node=(Node)session.load(Node.class, 1);
		print(node,0);
		session.getTransaction().commit();
		
	}
	private void print(Node node,int level) {
		String pre="";
		for (int i = 0; i <level; i++) {
			pre+="------";
		}
		System.out.println(pre+node.getName());
		for(Node children:node.getChildren()) {
			print(children, level+1);
		}
	}
}
