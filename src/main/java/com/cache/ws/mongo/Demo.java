package com.cache.ws.mongo;

public class Demo {
	public static void main(String[] args) {
		MongoDBAbstractHandle handle = new MongoDBSummaryHandle();
		handle.load(new String[] { "2015-07-19", "2015-07-17" },
				new String[] { "se", "baidu" }, "1");
	}
}
