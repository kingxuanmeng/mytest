package com.demo.hibernate.dao;

import com.demo.hibernate.entity.Node;

public interface INodeDao {
	public void save();
	public void detele(Node node);
	public Node findOne(int id);
	public void change(Node node);
}
