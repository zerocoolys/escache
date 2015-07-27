package com.cache.ws.mongo;

import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public abstract class MongoDB4Test {
	protected Mongo mg = null;
	protected DB db;
	protected DBCollection users;

	@Before
	public void init() {
		try {
			mg = new Mongo("192.168.100.10", 23135);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		// 获取xnmz_weims_test DB；如果默认没有创建，mongodb会自动创建
		db = mg.getDB("xnmz_weims_test");
		users = db.getCollection("users");
	}

	@After
	public void destory() {
		if (mg != null) {
			mg.close();
		}
		mg = null;
		db = null;
		System.gc();
	}

	public void print(Object o) {
		System.out.println(o);
	}
}
