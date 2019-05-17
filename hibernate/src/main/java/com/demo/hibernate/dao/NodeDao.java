package com.demo.hibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.demo.hibernate.entity.Node;
import com.demo.hibernate.util.HibernateUtil;

public class NodeDao implements INodeDao{
	private SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
	public void save() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.getCurrentSession();
		Node node0=new Node();;
		node0.setName("计算机学院");
		Node node1=new Node();
		node1.setName("软件3班");
		Node node2=new Node();
		node2.setName("软件2班");
		Node node3=new Node();
		node3.setName("庄东升1");
		Node node4=new Node();
		node4.setName("庄东升2");
		Node node5=new Node();
		node5.setName("温老师1");
		Node node6=new Node();
		node6.setName("温老师2");
		node0.getChildren().add(node1);
		node0.getChildren().add(node2);
		node1.getChildren().add(node3);
		node1.getChildren().add(node4);
		node1.setParent(node0);
		node2.getChildren().add(node5);
		node2.getChildren().add(node6);
		node2.setParent(node0);
		node3.setParent(node1);
		node4.setParent(node1);
		node5.setParent(node2);
		node6.setParent(node2);
		session.beginTransaction();
		session.save(node0);
		session.getTransaction().commit();
	}
	public void change(Node node) {
		Session session=sessionFactory.getCurrentSession();
		Node parentNode=node.getParent();
		session.beginTransaction();
		for(Node children:node.getChildren()) {
			children.setParent(parentNode);
			session.update(node);
		}
		node.setParent(null);
		node.setChildren(null);
		session.update(node);
		session.getTransaction().commit();
	}
	public Node findOne(int id) {
		//1.创建会话
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		Node entity = session.get(Node.class, id);
		//Event event = session.load(Event.class, id);
		//4.提交事务
		session.getTransaction().commit();
		
		return entity;
	}
	public void detele(Node node) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();//创建一个线程安全会话,自动回滚和关闭
		//2.开始事务
		session.beginTransaction();
		//3.执行会话  CRUD API
		session.delete(node);
		//4.提交事务
		session.getTransaction().commit();
	}
}
